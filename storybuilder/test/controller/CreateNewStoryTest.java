/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import java.util.List;
import model.Page;
import model.Story;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Y0239881
 */
public class CreateNewStoryTest {

    public CreateNewStoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNewStory() {
        Story story = new Story();
        story.setTitle("This is a new story");
        story.setBackgroundColor("BLACK");
        story.setCreatedBy("admin");
        story.setFeedbackRequired(true);
        story.setFont("Arial");
        story.setFontSize(14);
        story.setTextColor("WHITE");

        Page p = new Page();
        p.setText("This is the first test page with the singing goat and two images");
        p.setSound("resources/sounds/goat.wav");
        p.getImages().add("resources/images/default.jpg");
        p.getImages().add("resources/images/default.jpg");
        story.getPages().add(p);

        p = new Page();
        p.setText("This is the second page with one image and no sound");
        p.getImages().add("resources/images/default.jpg");
        story.getPages().add(p);

        // get the size of all the current stories in the database
        int oldSize = new StoryController().getAllStories().size();

        // attempt to insert to database
        new StoryController().createNewStory(story);

        // get the list of all stories including the newly created
        LinkedList<Story> stories = new StoryController().getAllStories();

        // compare the old size and new size
        assertEquals(oldSize, stories.size() - 1);

        // get the new created story
        Story newStory = stories.getLast();

        assertEquals(story.getBackgroundColor(), newStory.getBackgroundColor());
        assertEquals(story.getCreatedBy(), newStory.getCreatedBy());
        assertEquals(story.getFont(), newStory.getFont());
        assertEquals(story.getFontSize(), newStory.getFontSize());
        assertEquals(story.getTextColor(), newStory.getTextColor());
        assertEquals(story.getTitle(), newStory.getTitle());


        // whether two stories has the same number of pages
        assertEquals(story.getPages().size(), newStory.getPages().size());

        // then check through all the pages
        LinkedList<Page> pages = story.getPages();
        LinkedList<Page> newPages = newStory.getPages();

        if (pages.size() > 0) {
            for (int i = 0; i < pages.size(); i++) {
                Page _p = pages.get(i);
                Page _newP = newPages.get(i);

                // check the same sound on two pages
                assertEquals(_p.getSound(), _newP.getSound());
                // check same text on two pages
                assertEquals(_p.getText(), _newP.getText());

                // check same number of images 
                assertEquals(_p.getImages().size(), _newP.getImages().size());

                // then check each of the image
                List<String> oImages = _p.getImages();
                List<String> nImages = _newP.getImages();

                for (int j = 0; i < oImages.size(); i++) {
                    // check same image value
                    assertEquals(oImages.get(i), nImages.get(i));
                }
            }
        }

        System.out.println("CreateNewStoryTest: -> all passed");
    }
}
