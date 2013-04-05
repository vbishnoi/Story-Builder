package controller;

import com.uoy.sb.Common;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import model.*;
import org.jdom2.Element;
import org.w3c.dom.Document;

public class DataController {

    private LinkedList<Adult> adultList;
    private LinkedList<Child> childrenList;
    private LinkedList<Story> storyList;

    public DataController() {
        this.init();
    }

    /**
     * Load all data from XML database into appropriate list
     *
     * @author Y0239881
     */
    private void init() {
        adultList = new LinkedList<>();
        childrenList = new LinkedList<>();
        storyList = new LinkedList<>();

        Element root = new XMLReader().getRootElement(Common.Variables.DATABASE_NAME);
        Element node = null;

        List secondLvlNodes = root.getChildren();

        for (int i = 0; i < secondLvlNodes.size(); i++) {
            node = (Element) secondLvlNodes.get(i);

            List tmpList = null;
            Element tmpNode = null;

            switch (node.getName()) {
                case Common.Variables.CHILDREN_NODE:
                    tmpList = node.getChildren(Common.Variables.CHILD_SINGLE_NODE);

                    for (int j = 0; j < tmpList.size(); j++) {
                        tmpNode = (Element) tmpList.get(j);

                        childrenList.add(new Child(tmpNode.getChildText(Common.Variables.USER_NAME), tmpNode.getChildText(Common.Variables.USER_PASSWORD),
                                tmpNode.getChildText(Common.Variables.CHILD_IMAGE), Integer.parseInt(tmpNode.getChildText(Common.Variables.CHILD_AGE))));
                    }

                    break;
                case Common.Variables.ADULTS_NODE:
                    tmpList = node.getChildren(Common.Variables.ADULT_SINGLE_NODE);

                    for (int j = 0; j < tmpList.size(); j++) {
                        tmpNode = (Element) tmpList.get(j);

                        adultList.add(new Adult(tmpNode.getChildText(Common.Variables.USER_NAME), tmpNode.getChildText(Common.Variables.USER_PASSWORD)));
                    }
                    break;
                case Common.Variables.STORIES_NODE:
                    tmpList = node.getChildren(Common.Variables.STORY_SINGLE_NODE);

                    for (int j = 0; j < tmpList.size(); j++) {
                        tmpNode = (Element) tmpList.get(j);

                        Story story = new Story();
                        story.setBackgroundColor(tmpNode.getChildText(Common.Variables.STORY_BG_COLOR));
                        story.setFont(tmpNode.getChildText(Common.Variables.STORY_FONT));
                        story.setFontSize(Integer.parseInt(tmpNode.getChildText(Common.Variables.STORY_FONT_SIZE)));
                        story.setTextColor(tmpNode.getChildText(Common.Variables.STORY_TEXT_COLOR));
                        story.setTitle(tmpNode.getChildText(Common.Variables.STORY_TITLE));

                        storyList.add(story);
                    }

                    break;
            }
        }
    }

    /**
     *
     */
    public static void saveData() {
    }

    /**
     *
     * @param doc
     * @param file
     */
    public static void saveXml(Document doc, File file) {
    }

    /**
     * @return the adultList
     */
    public LinkedList<Adult> getAdultList() {
        return adultList;
    }

    /**
     * @return the childrenList
     */
    public LinkedList<Child> getChildrenList() {
        return childrenList;
    }

    /**
     * @return the storyList
     */
    public LinkedList<Story> getStoryList() {
        return storyList;
    }
}
