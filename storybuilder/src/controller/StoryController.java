/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Page;
import model.Story;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Y0239881
 */
public class StoryController {

    private XMLParser parser = null;

    public StoryController() {
        parser = new XMLParser();
    }
// get all the stories from xml file

    public LinkedList<Story> getAllStories() {
        String query = "//story";

        List<Element> elements = (List<Element>) parser.getElements(query);

        return buildList(elements);
    }
    
    /*
     * get all the stories for the logged in user 
     * 
     * @param username 
     * 
     */

    public LinkedList<Story> getStoriesByUser(String username) {
        String query = XpathBuilder.getByAttribute(Common.Variables.STORY_SINGLE_NODE, Common.Variables.STORY_CREATED_BY, username);

        List<Element> elements = (List<Element>) parser.getElements(query);

        return buildList(elements);
    }

    private LinkedList<Story> buildList(List<Element> elements) {
        LinkedList<Story> stories = new LinkedList<>();

        if (elements != null && elements.size() > 0) {
            for (Element e : elements) {
                if (e != null) {
                    stories.add(getStory(e));
                }
            }
        }

        return stories;
    }

    /*
     * Create a new story and save to the database
     */
    public int createNewStory(Story s) {
        int sId = 0;

        LinkedList<Story> allStories = getAllStories();
        if (allStories.size() > 0) {
            Story last = allStories.get(allStories.size() - 1);

            sId = last.getId() + 1;
        } else {
            sId = 1;
        }

        Document objDoc = parser.getDocument();
        Element story = new Element(Common.Variables.STORY_SINGLE_NODE);

        story.setAttribute(new Attribute(Common.Variables.STORY_ID, String.valueOf(sId)));
        story.setAttribute(new Attribute(Common.Variables.STORY_CREATED_BY, s.getCreatedBy()));
        story.setAttribute(new Attribute(Common.Variables.STORY_REQUIRE_FEEDBACK, String.valueOf(s.isFeedbackRequired())));
        story.addContent(new Element(Common.Variables.STORY_TITLE).setText(s.getTitle()));
        story.addContent(new Element(Common.Variables.STORY_BG_COLOR).setText(s.getBackgroundColor()));
        story.addContent(new Element(Common.Variables.STORY_FONT_SIZE).setText(String.valueOf(s.getFontSize())));
        story.addContent(new Element(Common.Variables.STORY_FONT).setText(s.getFont()));
        story.addContent(new Element(Common.Variables.STORY_TEXT_COLOR).setText(s.getTextColor()));

        Element pages = new Element(Common.Variables.PAGES_NODE);
        Element page = null;

//        System.out.println(s.getPages().size());
//        int count = 0;

        if (s.getPages().size() > 0) {
            for (Page p : s.getPages()) {
//                count++;
//                System.out.println("page count:" + count);

                // create a new instance of the page element
                page = new Element(Common.Variables.PAGE_SINGLE_NODE);

                // then add the content
                page.addContent(new Element(Common.Variables.PAGE_CONTENT).setText(p.getText()));
                page.addContent(new Element(Common.Variables.PAGE_SOUND).setText(p.getSound()));

                Element images = new Element(Common.Variables.PAGE_IMAGES);

                // loop through the list of all the images
                if (p.getImages() != null && p.getImages().size() > 0) {
                    for (int i = 0; i < p.getImages().size(); i++) {
                        // create a new image element and add the the image list
                        images.addContent(new Element(Common.Variables.PAGE_IMAGE).setText(p.getImages().get(i)));
                    }
                }
                // add the image list to the current page
                page.addContent(images);

                // add the current page to the page list
                pages.addContent(page);
            }

            // add the page list to the story
            story.addContent(pages);
        }

        Element parent = parser.getElement("//stories");
        parent.addContent(story);

        saveXML(objDoc);

        System.out.println("Story created!");

        return sId;
    }

    /*
     * Delete the story from database
     */
    public void deleteStory(Story story) {
        Document doc = parser.getDocument();
        Element elm = getStoryElement(story.getId());

        if (elm != null) {
            elm.detach();
        }

        saveXML(doc);
    }

    /*
     * update the xml file with the updated content
     * 
     */
    public void updateStory(Story storyToUpdate) {
        Document objDoc = parser.getDocument();

        Element story = getStoryElement(storyToUpdate.getId());

        if (story != null) {
            // update the story
            story.getChild(Common.Variables.STORY_TITLE).setText(storyToUpdate.getTitle());
//            story.getChild(Common.Variables.STORY_TITLE).setText("test");
            story.getChild(Common.Variables.STORY_BG_COLOR).setText(storyToUpdate.getBackgroundColor());
            story.getChild(Common.Variables.STORY_FONT).setText(storyToUpdate.getFont());
            story.getChild(Common.Variables.STORY_FONT_SIZE).setText(String.valueOf(storyToUpdate.getFontSize()));
            story.getChild(Common.Variables.STORY_TEXT_COLOR).setText(storyToUpdate.getTextColor());
            story.getAttribute(Common.Variables.STORY_REQUIRE_FEEDBACK).setValue(String.valueOf(storyToUpdate.isFeedbackRequired()));

            // update pages
            Element pagesContainer = story.getChild(Common.Variables.PAGES_NODE);

            List<Element> pageElements = pagesContainer.getChildren(Common.Variables.PAGE_SINGLE_NODE);
            LinkedList<Page> pages = storyToUpdate.getPages();

            // delete all current pages
            if (pageElements != null && !pageElements.isEmpty()) {
                Iterator itr = pageElements.iterator();
                while (itr.hasNext()) {
                    Element child = (Element) itr.next();
                    itr.remove();
                }
            }

            // re-insert
            if (pages != null && !pages.isEmpty()) {
                Element pe = null;
                for (Page page : pages) {
                    pe = new Element(Common.Variables.PAGE_SINGLE_NODE);

                    pe.addContent(new Element(Common.Variables.PAGE_CONTENT).setText(page.getText()));
                    pe.addContent(new Element(Common.Variables.PAGE_SOUND).setText(page.getSound()));
                    Element imagesElm = new Element(Common.Variables.PAGE_IMAGES);
                    pe.addContent(imagesElm);

                    List<String> images = page.getImages();

                    if (images != null && !images.isEmpty()) {
                        for (String img : images) {
                            imagesElm.addContent(new Element(Common.Variables.PAGE_IMAGE).setText(img));
                        }
                    }

                    pagesContainer.addContent(pe);
                }
            }

            saveXML(objDoc);

            System.out.println("Story updated!");
        }
    }

    /*
     * get element contents from the xml file by the story ID 
     * 
     */
    private Element getStoryElement(int StoryID) {
        String query = XpathBuilder.getByAttribute(Common.Variables.STORY_SINGLE_NODE, Common.Variables.STORY_ID, String.valueOf(StoryID));

        System.out.println(query);

        return parser.getElement(query);
    }

    /*
     * Initialize new Story object form a xml story element
     */
    private Story getStory(Element storyElm) {
        Story story = null;
        LinkedList<Page> pages = new LinkedList<>();
        Page page = null;

        if (storyElm != null) {
            story = new Story();

            story.setTitle(storyElm.getChildText(Common.Variables.STORY_TITLE));
            story.setBackgroundColor(storyElm.getChildText(Common.Variables.STORY_BG_COLOR));
            story.setFont(storyElm.getChildText(Common.Variables.STORY_FONT));
            story.setFontSize(Integer.parseInt(storyElm.getChildText(Common.Variables.STORY_FONT_SIZE)));
            story.setTextColor(storyElm.getChildText(Common.Variables.STORY_TEXT_COLOR));
            story.setCreatedBy(storyElm.getAttributeValue(Common.Variables.STORY_CREATED_BY));
            story.setId(Integer.parseInt(storyElm.getAttributeValue(Common.Variables.STORY_ID)));
            story.setFeedbackRequired(Boolean.parseBoolean(storyElm.getAttributeValue(Common.Variables.STORY_REQUIRE_FEEDBACK)));

            Element pagesContainer = storyElm.getChild(Common.Variables.PAGES_NODE);

            /*
             * Get all the pages that belong to the story
             */
            List<Element> pageElements = pagesContainer.getChildren(Common.Variables.PAGE_SINGLE_NODE);
            if (pageElements != null && pageElements.size() > 0) {
                for (Element e : pageElements) {
                    if (e != null) {
                        page = new Page();

                        page.setText(e.getChildText(Common.Variables.PAGE_CONTENT));
                        page.setSound(e.getChildText(Common.Variables.PAGE_SOUND));

                        Element images = e.getChild(Common.Variables.PAGE_IMAGES);
                        if (images != null) {
                            List<Element> imageList = images.getChildren(Common.Variables.PAGE_IMAGE);

                            if (imageList != null && imageList.size() > 0) {
                                for (Element img : imageList) {
                                    page.addImage(img.getText());
                                }
                            }
                        }

                        pages.add(page);
                    }
                }
            }

            // Then add to the list
            story.setPages(pages);
        } else {
            throw new NullPointerException("Story element is null");
        }

        return story;
    }

    /*
     * Get a Story from the database by the @param storyID
     * @param storyID ID of the story to get
     * @return Story object
     */
    public Story getStory(int storyID) {
        Element e = getStoryElement(storyID);

        return getStory(e);
    }

    private void saveXML(Document doc) {
        // create new output writer to update back to file
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter(Common.Variables.DATABASE_NAME));

            // print out
            // xmlOutput.output(objDoc, System.out);
        } catch (IOException ex) {
            Logger.getLogger(StoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
