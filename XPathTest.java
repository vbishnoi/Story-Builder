/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class XPathTest {
    
    public XPathTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     
         @Test
	public void testNewInstance() {
		try {
			Document doc = new Document(new Element("main"));
			XPath xp = XPath.newInstance("/");
			assertTrue(doc == xp.selectSingleNode(doc));
		} catch (JDOMException e) {
			e.printStackTrace();
			fail("Could not process XPath.newInstance()");
		}
	}
     }
}
