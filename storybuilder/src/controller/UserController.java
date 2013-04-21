/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import com.uoy.sb.Common.Variables;
import com.uoy.sb.Global;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.UserGroup;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Y0239881
 */
public class UserController {

    private XMLParser parser = null;

    public UserController() {
        parser = new XMLParser();
    }

    /**
     * Get all users from database
     * 
     * @return List of all users
     */
    public LinkedList<User> getAllUsers() {
        LinkedList<User> users = new LinkedList<>();

        String query = "//user";
        List<Element> elements = (List<Element>) parser.getElements(query);

        if (elements != null && elements.size() > 0) {
            for (Element e : elements) {
                if (e != null) {
                    User u = new User();

                    u.setName(e.getAttributeValue(Variables.USER_NAME));
                    u.setPassword(e.getChildText(Variables.USER_PASSWORD));
                    u.setGroup(UserGroup.fromInteger(Integer.parseInt(e.getAttributeValue(Variables.USER_GROUP))));
                    u.setImage(e.getChildText(Variables.USER_IMAGE));
                    u.setAge(Integer.parseInt(e.getChildText(Variables.USER_AGE)));

                    users.add(u);
                } else {
                    Logger.getLogger(UserController.class.getName()).log(Level.WARNING, null, "Element is null");
                }
            }
        }

        return users;
    }

    /**
     * Get all adults from database
     * 
     * @return List of all adult users
     */
    public LinkedList<User> getAllAdults() {
        LinkedList<User> adults = new LinkedList<>();
        LinkedList<User> users = getAllUsers();

        if (users != null & users.size() > 0) {
            for (User u : users) {
                if (u.getGroup() == UserGroup.Adult) {
                    adults.add(u);
                }
            }
        }

        return adults;
    }

    /**
     * Get all the children from database
     * 
     * @return List of all children
     */
    public LinkedList<User> getAllChildren() {
        LinkedList<User> children = new LinkedList<>();
        LinkedList<User> users = getAllUsers();

        if (users != null & users.size() > 0) {
            for (User u : users) {
                if (u.getGroup().equals(UserGroup.Child)) {
                    children.add(u);
                }
            }
        }

        return children;
    }

    /**
     * Get the User object using the given name
     * 
     * @param name Name of the user
     * @return User object
     */
    public User getUserByName(String name) {
        User u = null;
        String query = XpathBuilder.getByAttribute(Variables.USER_SINGLE_NODE, Variables.USER_NAME, name);

        Element element = parser.getElement(query);

        if (element != null) {
            u = new User();
            u.setName(name);
            u.setPassword(element.getChildText(Variables.USER_PASSWORD));
            u.setGroup(UserGroup.fromInteger(Integer.parseInt(element.getAttributeValue(Common.Variables.USER_GROUP))));
            u.setImage(element.getChildText(Common.Variables.USER_IMAGE));
            u.setAge(Integer.parseInt(element.getChildText(Common.Variables.USER_AGE)));
        }

        return u;
    }

    /**
     * Update user's information
     * 
     * @param user user to update
     */
    public void updateUser(User user) {
        String query = XpathBuilder.getByAttribute(Variables.USER_SINGLE_NODE, Variables.USER_NAME, user.getName());

        Element element = parser.getElement(query);
        if (element != null) {
            element.detach();
            
            createNewUser(user);
        }
    }

    /**
     * Create a new instance of user and save into the database
     * 
     * @param user User to save
     */
    public void createNewUser(User user) {
        Document doc = parser.getDocument();
        Element elm = new Element("user");

        // attributes
        elm.setAttribute("name", user.getName());
        elm.setAttribute("group", String.valueOf(UserGroup.toInt(user.getGroup())));

        // elements
        elm.addContent(new Element(Common.Variables.USER_PASSWORD).setText(user.getPassword()));
        elm.addContent(new Element(Common.Variables.USER_AGE).setText(String.valueOf(user.getAge())));
        String avatar = "resources/images/default.jpg";
        if(!user.getImage().equals(""))
            avatar = user.getImage();
        
        elm.addContent(new Element(Common.Variables.USER_IMAGE).setText(user.getImage()));

        Element parent = parser.getElement("//users");
        if (parent != null) {
            try {
                parent.addContent(elm);

                XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());

                //output xml to console for debugging
                //xmlOutputter.output(doc, System.out);

                xmlOutputter.output(doc, new FileOutputStream(Common.Variables.DATABASE_NAME));
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            Global.group = u.getGroup();
            success = true;
        }
        return success;
    }
}
