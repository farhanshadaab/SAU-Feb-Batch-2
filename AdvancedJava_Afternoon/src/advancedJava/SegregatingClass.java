package advancedJava;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class SegregatingClass {
	public static final void upload(Document xml, String file) throws Exception {
        Transformer tfactory = TransformerFactory.newInstance().newTransformer();
        tfactory.transform(new DOMSource(xml), new StreamResult(new File(file)));
    }

    public static void main(String argv[]) {
        try {

            File file = new File("C:\\Users\\MD SHADAAB FARHAN\\eclipse-workspace\\AdvancedJava_Afternoon\\merge.xml");

            DocumentBuilderFactory doc_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder doc_builder = doc_factory.newDocumentBuilder();

            Document valid = doc_builder.newDocument();
            Document invalid = doc_builder.newDocument();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();
            ArrayList<String> expiry = new ArrayList<>();

            NodeList nodeList = doc.getElementsByTagName("License");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element tElement = (Element) node;

                    expiry.add(tElement.getAttribute("License_Expiration_Date"));

                }
            }

            Element validRoot = valid.createElement("CSR_Producer");
            valid.appendChild(validRoot);
            Element invalidRoot = invalid.createElement("CSR_Producer");
            invalid.appendChild(invalidRoot);

            for (int i = 0, j = 0; i < nodeList.getLength() && j < expiry.size(); i++, j++) {

                String d1 = expiry.get(j);
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(d1);

                long millis = System.currentTimeMillis();
                java.sql.Date date2 = new java.sql.Date(millis);
                Element curr_license = (Element) nodeList.item(i);

                if (date1.before(date2)) {

                    Node invalid_license = invalid.importNode(curr_license, true);

                    invalidRoot.appendChild(invalid_license);
                    upload(invalid, "C:\\Users\\MD SHADAAB FARHAN\\eclipse-workspace\\AdvancedJava_Afternoon\\invalid.xml");
                }

                else {

                    Node valid_license = valid.importNode(curr_license, true);

                    validRoot.appendChild(valid_license);
                    upload(valid, "C:\\Users\\MD SHADAAB FARHAN\\eclipse-workspace\\AdvancedJava_Afternoon\\valid.xml");
                }

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}
