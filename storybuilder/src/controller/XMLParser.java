/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.uoy.sb.Common;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 *
 * @author Y0239881
 */
public class XMLParser {
    private Document doc = null;
    
    public XMLParser() {
        doc = new XMLReader().getXMLDocument(Common.Variables.DATABASE_NAME);
    }
    
    public List<?> getElements(String xpathQuery) {
        XPathExpression<Element> xpath = XPathFactory.instance().compile(xpathQuery, Filters.element());
        List<Element> elements = xpath.evaluate(doc);
 
        return elements;
    }
    
    public Element getElement(String xpathQuery) {
        XPathExpression<Element> xpath = XPathFactory.instance().compile(xpathQuery, Filters.element());
        Element element = xpath.evaluateFirst(doc);
 
        return element;
    }
    
    
}
