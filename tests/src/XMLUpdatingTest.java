
import controller.XMLParser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.xml.sax.XMLReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Y0239881
 */
public class XMLUpdatingTest {

    private Document document = null;

    public XMLUpdatingTest() {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("database.xml");

        try {
            document = (Document) builder.build(xmlFile);
            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
//            xmlOutput.setFormat(Format.getPrettyFormat());
//
//            xmlOutput.output(document, System.out);


        } catch (JDOMException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void test() {
        try {
            controller.XMLParser parser = new XMLParser();
            Document doc = parser.getDocument();

            Element story = parser.getElement("//story[@id='1']");

            story.getChild("title").setText("Buzzy 3343");

            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());

            xmlOutput.output(doc, System.out);
        } catch (IOException ex) {
            Logger.getLogger(XMLUpdatingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new XMLUpdatingTest().test();
    }
}
