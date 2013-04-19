/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AssignedStory;
import model.Feedback;
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
     * @param notDone If true return the un-finished stories otherwise return all.
     */
    public LinkedList<AssignedStory> getAssignedStoriesByUser(String username, boolean notDone) throws Exception {
        String query = XpathBuilder.getByAttribute(Common.Variables.ASSIGNED_STORY, Common.Variables.ASSIGNED_STORY_USER, username);

        return getAssignedList(query, notDone);
    }

    /*
     * Return the list of assigned children to a specific story
     * @param storyID the story to get the assigned children
     * @param notDone If true return the un-finished stories otherwise return all.
     */
    public LinkedList<AssignedStory> getAssignedChidrenToStory(int storyID, boolean notDone) throws Exception {
        String query = XpathBuilder.getByAttribute(Common.Variables.ASSIGNED_STORY, Common.Variables.ASSIGNED_STORY_STORY, String.valueOf(storyID));

        return getAssignedList(query, notDone);
    }

    public void deleteAssignedChildren(int storyID) {
        Document doc = parser.getDocument();
        String query = XpathBuilder.getByAttribute(Common.Variables.ASSIGNED_STORY, Common.Variables.ASSIGNED_STORY_STORY, String.valueOf(storyID));

        elements = (List<Element>) parser.getElements(query);

        if (elements != null && !elements.isEmpty()) {
            Iterator itr = elements.iterator();
            while (itr.hasNext()) {
                Element child = (Element) itr.next();
//                itr.remove();
                child.detach();
            }
        }

        saveXML(doc);
    }

    public void updateFeedback(int storyID, String user, String feedback) {
        Document doc = parser.getDocument();

        String query = "//assigned/item[@story='" + storyID + "' and @user='" + user + "']";
        Element item = parser.getElement(query);

        if (item != null) {
            item.getChild(Common.Variables.ASSIGNED_STORY_FEEDBACK).setText(feedback.toUpperCase());
            item.getChild(Common.Variables.ASSIGNED_STORY_DONE).setText(Boolean.TRUE.toString());
        }

        saveXML(doc);
    }

    public void assignStory(Story story, List<String> children) throws Exception {
        Document doc = parser.getDocument();
        Element parent = parser.getElement("//assigned");

        LinkedList<AssignedStory> assigned = getAssignedChidrenToStory(story.getId(), false);

        // delete all un-finished story first
        if (elements != null && elements.size() > 0) {
            for (Element e : elements) {
                for (int i = 0; i < assigned.size(); i++) {
                    if (e.getAttributeValue(Common.Variables.ASSIGNED_STORY_STORY).equals(assigned.get(i).getStory()) && e.getChildText(Common.Variables.ASSIGNED_STORY_DONE).equals("FALSE")) {
                        e.detach();
                    }
                }
            }
        }

        // then re-insert
        for (String username : children) {
            Element ne = new Element(Common.Variables.ASSIGNED_STORY);

            ne.setAttribute(new Attribute(Common.Variables.ASSIGNED_STORY_STORY, String.valueOf(story.getId())));
            ne.setAttribute(new Attribute(Common.Variables.ASSIGNED_STORY_USER, username));

            ne.addContent(new Element(Common.Variables.ASSIGNED_STORY_DONE).setText("FALSE"));
            ne.addContent(new Element(Common.Variables.ASSIGNED_STORY_FEEDBACK).setText(""));

            if (parent != null) {
                parent.addContent(ne);
            }
        }

        saveXML(doc);

        System.out.println("story assigned");

    }

    private LinkedList<AssignedStory> getAssignedList(String query, boolean notDone) throws Exception {
        LinkedList<AssignedStory> result = null;

        elements = (List<Element>) parser.getElements(query);

        if (elements != null && elements.size() > 0) {
            AssignedStory item = null;
            result = new LinkedList<>();

            for (Element el : elements) {
                if (el != null) {
                    String strDone = el.getChildText(Common.Variables.ASSIGNED_STORY_DONE);
                    if (!strDone.equals("")) {
                        boolean b = Boolean.parseBoolean(strDone);

                        if (notDone) {
                            if (Boolean.compare(b, false) == 0) {
                                item = new AssignedStory();

                                item.setIsDone(b);
                                item.setFeedback(el.getChildText(Common.Variables.ASSIGNED_STORY_FEEDBACK));
                                item.setStory(el.getAttributeValue(Common.Variables.ASSIGNED_STORY_STORY));
                                item.setUser(el.getAttributeValue(Common.Variables.ASSIGNED_STORY_USER));

                                result.add(item);
                            }
                        } else {
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