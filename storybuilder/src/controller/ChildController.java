/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import java.util.List;
import model.Child;
import org.jdom2.Element;

/**
 *
 * @author Y0239881
 */
public class ChildController {
XMLParser parser = null;
    
    public ChildController() {
        parser = new XMLParser();
    }

    public LinkedList<Child> getAllChildren() {
        
        String query = "//story";
        
        return null;
    }
}
