/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlStuff;

/*
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.xml.parsers.*;
 import org.w3c.dom.Attr;
 import org.w3c.dom.Element;
 import org.w3c.dom.Document;
 import org.w3c.dom.Node;*/
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

/**
 *
 * @author christianlinde
 */
public class XMLProduct {

    public String getProduct() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root elements
            Document doc = docBuilder.newDocument();

            doc.setXmlVersion("1.0");
            doc.setXmlStandalone(true);

            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            //staff elements
            Element staff = doc.createElement("Staff");
            rootElement.appendChild(staff);

            //set attribute to staff element
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            staff.setAttributeNode(attr);

            //shorten way
            //staff.setAttribute("id", "1");

            //firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("yong"));
            staff.appendChild(firstname);

            //lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("mook kim"));
            staff.appendChild(lastname);

            //nickname elements
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("mkyong"));
            staff.appendChild(nickname);

            //salary elements
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("100000"));
            staff.appendChild(salary);


            //set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            //
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();

            return xmlString;

            //StreamResult result =  new StreamResult(new File("C:\\testing.xml"));
            //transformer.transform(source, result);

            //System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

        return "";
    }
}
