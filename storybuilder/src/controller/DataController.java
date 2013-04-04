package controller;

import java.io.File;
import org.jdom2.Element;
import org.w3c.dom.Document;

public class DataController {

    public static Element loadDatabase() {
        return (new XMLReader().readXMLFile("resources/database.xml"));
    }

    public static void saveData() {
    }

    public static void saveXml(Document doc, File file) {
    }
}
