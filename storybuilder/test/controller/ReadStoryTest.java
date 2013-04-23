/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ReadStoryTest {

    public ReadStoryTest() {
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
    public void testReadStory() {
        Story s = new StoryController().getStory(1);
        
        // check story not null
        assertNotNull(s);
        
        // check all the pages
        assertNotNull(s.getPages());
        
        
    }
    
    
}
