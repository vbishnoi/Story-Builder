/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import java.util.LinkedList;
import java.util.List;
import model.Page;
import model.Story;
import org.jdom2.Element;

/**
 *
 * @author Y0239881
 */
public class StoryController {
    
    private XMLParser parser = null;
    
    public StoryController() {
        parser = new XMLParser();
    }
    
    public LinkedList<Story> getAllStories() {
        String query = "//story";
        
        List<Element> elements = (List<Element>) parser.getElements(query);
        
        return buildList(elements);
    }
    
    public LinkedList<Story> getStoriesByUser(String username) {
        String query = XpathBuilder.GetElementsByAttrNameAndValue(Common.Variables.STORY_SINGLE_NODE, Common.Variables.STORY_CREATED_BY, username);
        
        List<Element> elements = (List<Element>) parser.getElements(query);
        
        return buildList(elements);
    }
    
    private LinkedList<Story> buildList(List<Element> elements) {
        LinkedList<Story> stories = new LinkedList<>();
        
        Story s = null;
        LinkedList<Page> pages = null;
        Page page = null;
        
        if (elements != null && elements.size() > 0) {
            for (Element e : elements) {
                if (e != null) {
                    s = new Story();
                    
                    s.setTitle(e.getChildText(Common.Variables.STORY_TITLE));
                    s.setBackgroundColor(e.getChildText(Common.Variables.STORY_BG_COLOR));
                    s.setFont(e.getChildText(Common.Variables.STORY_FONT));
                    s.setFontSize(Integer.parseInt(e.getChildText(Common.Variables.STORY_FONT_SIZE)));
                    s.setTextColor(e.getChildText(Common.Variables.STORY_TEXT_COLOR));
                    s.setCreatedBy(e.getAttributeValue(Common.Variables.STORY_CREATED_BY));
                    s.setId(Integer.parseInt(e.getAttributeValue(Common.Variables.STORY_ID)));
                    /*
                     * Get all the pages that belong to the story
                     */
                    List<Element> pageElements = e.getChildren(Common.Variables.PAGE_SINGLE_NODE);
                    if (pages != null && pages.size() > 0) {
                        for (Element e1 : pageElements) {
                            if (e1 != null) {
                                page = new Page();
                                
                                page.setText(e1.getChildText(Common.Variables.PAGE_CONTENT));
                                
                                pages.add(page);
                            }
                        }
                    }
                    
                    // Then add to the list
                    s.setPages(pages);
                    
                    stories.add(s);
                }
            }
        }
        
        return stories;
    }
    
    public LinkedList<Page> getAllPagesByStory(int storyID) {
        LinkedList<Page> allPages = new LinkedList<>();
        String query = XpathBuilder.GetElementsByAttrNameAndValue(Common.Variables.STORY_SINGLE_NODE, Common.Variables.STORY_ID, String.valueOf(storyID));
        
        System.out.println(query);
        
        Element elm = parser.getElement(query);
        
        if(elm != null) {
            Element pagesContainer = elm.getChild(Common.Variables.PAGES_NODE);
            
            List<Element> pages = pagesContainer.getChildren(Common.Variables.PAGE_SINGLE_NODE);
            
            if(pages != null && pages.size() > 0) {
                for(Element p : pages) {
                    allPages.add(new Page(p.getChildText(Common.Variables.PAGE_CONTENT)));
                }               
            }
        }
        
        return allPages;
    }
}
