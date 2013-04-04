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

    private Element root = DataController.loadDatabase();

    public ChildController() {
    }

    public LinkedList<Child> getAllChildren() {
        LinkedList<Child> childrenList = new LinkedList<>();

        Element children = root.getChild("children");
        
        List list = children.getChildren("child");

        Element node = null;

        for (int i = 0; i < list.size(); i++) {
            node = (Element) list.get(i);

            childrenList.add(new Child(node.getChildText("name"), node.getChildText("password"), node.getChildText("image")));
        } 
        
        return childrenList;
    }
    
    
}
