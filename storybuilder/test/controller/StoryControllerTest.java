/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
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
public class StoryControllerTest {
    
    public StoryControllerTest() {
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

    /**
     * Test of getAllStories method, of class StoryController.
     */
    @Test
    public void testGetAllStories() {
        System.out.println("getAllStories");
        StoryController instance = new StoryController();
        LinkedList expResult = null;
        LinkedList result = instance.getAllStories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoriesByUser method, of class StoryController.
     */
    @Test
    public void testGetStoriesByUser() {
        System.out.println("getStoriesByUser");
        String username = "";
        StoryController instance = new StoryController();
        LinkedList expResult = null;
        LinkedList result = instance.getStoriesByUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewStory method, of class StoryController.
     */
    @Test
    public void testCreateNewStory() {
        System.out.println("createNewStory");
        
        String storyName = "A test name";
        
        
        Story s = null;
        StoryController instance = new StoryController();
        int expResult = 0;
        int result = instance.createNewStory(s);
        
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStory method, of class StoryController.
     */
    @Test
    public void testDeleteStory() {
        System.out.println("deleteStory");
        Story story = null;
        StoryController instance = new StoryController();
        instance.deleteStory(story);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStory method, of class StoryController.
     */
    @Test
    public void testUpdateStory() {
        System.out.println("updateStory");
        Story storyToUpdate = null;
        StoryController instance = new StoryController();
        instance.updateStory(storyToUpdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStory method, of class StoryController.
     */
    @Test
    public void testGetStory() {
        System.out.println("getStory");
        int storyID = 0;
        StoryController instance = new StoryController();
        Story expResult = null;
        Story result = instance.getStory(storyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
