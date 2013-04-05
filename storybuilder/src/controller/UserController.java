/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import com.uoy.sb.Common.Variables;
import java.util.LinkedList;
import java.util.List;
import model.User;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 *
 * @author Y0239881
 */
public class UserController {

    private Document doc = null;

    public UserController() {
        doc = new XMLReader().getXMLDocument(Variables.DATABASE_NAME);
    }

    public LinkedList<User> getAllUsers() {
        LinkedList<User> users = new LinkedList<>();

        String query = "//user";
        
        return users;
    }

    public User getUserByName(String name) {
        User u = null;
        String query = XpathBuilder.GetElementByAttNameAndValue(Variables.USER_SINGLE_NODE, Variables.USER_NAME, name);

        XPathExpression<Element> xpath = XPathFactory.instance().compile(query, Filters.element());
        Element element = xpath.evaluateFirst(doc);

        if (element != null) {
            u.setName(name);
            u.setPassword(element.getChildText(Variables.USER_PASSWORD));
        }

        return u;
    }

    public void login(String name, String password) {
        System.out.println(Common.Security.MD5(password));

        User u = getUserByName(name);
        if (u != null && u.getPassword().equals(Common.Security.MD5(password))) {
            System.out.println("Logged in");
        }


    }
}
