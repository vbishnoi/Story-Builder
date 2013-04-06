/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import com.uoy.sb.Common.Variables;
import com.uoy.sb.Global;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author Y0239881
 */
public class UserController {
    private XMLParser parser = null;

    public UserController() {
        parser = new XMLParser();
    }

    public LinkedList<User> getAllUsers() {
        LinkedList<User> users = new LinkedList<>();

        String query = "//user";
        List<Element> elements = (List<Element>) parser.getElements(query);

        if (elements != null && elements.size() > 0) {
            for (Element e : elements) {
                if (e != null) {
                    users.add(new User(e.getAttributeValue(Variables.USER_NAME), e.getChildText(Variables.USER_PASSWORD)));
                } else {
                    Logger.getLogger(UserController.class.getName()).log(Level.WARNING, null, "Element is null");
                }
            }
        }

        return users;
    }

    public User getUserByName(String name) {
        User u = new User();
        String query = XpathBuilder.GetElementsByAttrNameAndValue(Variables.USER_SINGLE_NODE, Variables.USER_NAME, name);

        Element element = parser.getElement(query);

        if (element != null) {
            u.setName(name);
            u.setPassword(element.getChildText(Variables.USER_PASSWORD));
        }

        return u;
    }

    /**
     * Attempt to login to the system using name and password
     *
     * @param name
     * @param password
     */
    public boolean login(String name, String password) {
        boolean success = false;
//        System.out.println(Common.Security.MD5(password));

        User u = getUserByName(name);
        if (u != null && u.getPassword().equals(Common.Security.MD5(password))) {
            System.out.println("Logged in");

            Global.loggedIn = true;
            Global.loggedInUser = name;
            success = true;
        }
        return success;
    }
}
