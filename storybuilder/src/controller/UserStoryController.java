/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import model.AssignedStory;
import model.Story;
import model.User;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Y0239881
 */
public class UserStoryController {

    private List<Element> elements = null;
    private XMLParser parser = null;

    public UserStoryController() {
        parser = new XMLParser();
    }

    /*
     * Return a list of story that assigned to the @param username
     * @param username name of the user (child) to get data
     * @param isDone wherether the assigned stories is read or not
     */
    public LinkedList<AssignedStory> getAssignedStoriesByUser(String username, boolean isDone) throws Exception {
        String query = XpathBuilder.GetElementsByAttrNameAndValue(Common.Variables.ASSIGNED_STORY, Common.Variables.ASSIGNED_STORY_USER, username);

        return getAssignedList(query, isDone);
    }

    /*
     * Return the list of assigned children to a specific story
     * @param storyID the story to get the assigned children
     */
    public LinkedList<AssignedStory> getAssignedChidrenByStory(int storyID, boolean isDone) throws Exception {
        String query = XpathBuilder.GetElementsByAttrNameAndValue(Common.Variables.ASSIGNED_STORY, Common.Variables.ASSIGNED_STORY_STORY, String.valueOf(storyID));

        return getAssignedList(query, isDone);
    }

    public void assignStory(Story story, List<String> children) throws Exception {
        Document doc = parser.getDocument();
        Element parent = parser.getElement("//assigned");

        LinkedList<AssignedStory> assigned = getAssignedChidrenByStory(story.getId(), false);

        if (elements != null && elements.size() > 0) {
            // delete all first
            for (Element e : elements) {
                e.detach();
            }

            // then re-insert
            for (String username : children) {
                Element ne = new Element(Common.Variables.ASSIGNED_STORY);

                ne.setAttribute(new Attribute(Common.Variables.ASSIGNED_STORY_STORY, String.valueOf(story.getId())));
                ne.setAttribute(new Attribute(Common.Variables.ASSIGNED_STORY_USER, username));

                ne.addContent(new Element(Common.Variables.ASSIGNED_STORY_DONE).setText("0"));
                ne.addContent(new Element(Common.Variables.ASSIGNED_STORY_FEEDBACK).setText(""));

                if (parent != null) {
                    parent.addContent(ne);

                    XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());

                    //output xml to console for debugging
                    //xmlOutputter.output(doc, System.out);

                    xmlOutputter.output(doc, new FileOutputStream(Common.Variables.DATABASE_NAME));
                    
                    System.out.println("story assigned");
                }
            }

        }
    }

    private LinkedList<AssignedStory> getAssignedList(String query, boolean isDone) throws Exception {
        LinkedList<AssignedStory> result = null;

        elements = (List<Element>) parser.getElements(query);

        if (elements != null && elements.size() > 0) {
            AssignedStory item = null;

            for (Element el : elements) {
                if (el != null) {
                    String strDone = el.getChildText(Common.Variables.ASSIGNED_STORY_DONE);
                    if (!strDone.equals("")) {
                        boolean b = Boolean.parseBoolean(strDone);

                        if (Boolean.compare(b, isDone) == 0) {
                            item = new AssignedStory();

                            item.setIsDone(b);
                            item.setFeedback(el.getChildText(Common.Variables.ASSIGNED_STORY_FEEDBACK));
                            item.setStory(el.getAttributeValue(Common.Variables.ASSIGNED_STORY_STORY));
                            item.setUser(el.getAttributeValue(Common.Variables.ASSIGNED_STORY_USER));

                            result.add(item);
                        }

                    } else {
                        throw new Exception("status of assigned story is empty");
                    }
                }
            }
        }

        return result;
    }
}