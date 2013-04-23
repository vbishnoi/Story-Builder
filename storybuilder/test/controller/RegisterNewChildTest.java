/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import model.User;
import model.UserGroup;
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
public class RegisterNewChildTest {

    public RegisterNewChildTest() {
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
    public void testRegisterNewChild() {
        System.out.println("getAllAdults");
        UserController uc = new UserController();
        
        User child = new User();
        child.setAge(10);
        child.setGroup(UserGroup.Child);
        child.setImage("testimage.jpg");
        child.setName("testChild");
        child.setPassword("testPassword");
        
        LinkedList<User> children = uc.getAllChildren();
        
        int oldSize = children.size();
        System.out.println(oldSize);
        
        uc.createNewUser(child);
        
        children = new UserController().getAllChildren();
        
        // whether a new object added to the database
        assertTrue(oldSize == children.size() - 1);
        
        // whether that child is in the list 
//        assertTrue(children.contains(child));
        
        // get the new created child (last one in the list)
        User addedChild = children.getLast();
        
        // check that the added child is equal to the one that going to be added
        assertEquals(addedChild.getAge(), child.getAge());
        assertEquals(addedChild.getGroup(), child.getGroup());
        assertEquals(addedChild.getImage(), child.getImage());
        assertEquals(addedChild.getName(), child.getName());
        assertEquals(addedChild.getPassword(), child.getPassword());
    }
    
    
}
