/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

/**
 *
 * @author Y0239881
 */
public class XMLReader {

    public XMLReader() {
    }

    public Document getXMLDocument(String fileName) {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(fileName);
        Document document = null;

        try {
            document = (Document) builder.build(xmlFile);
        } catch (JDOMException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return document;
    }

    public Element getRootElement(String fileName) {
        return getXMLDocument(fileName).getRootElement();
    }
}
