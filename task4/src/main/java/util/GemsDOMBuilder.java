package util;
/**
 * GemsDOMBuilder. Builder gems set.
 * <p>
 * 26 August 2018
 *
 * @author Dmitry Krivolap
 * @version 1.0
 */

import entity.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;


public class GemsDOMBuilder extends AbstractGemsBuilder {
    private static final Logger LOGGER = Logger.getLogger(GemsDOMBuilder.class);
    private DocumentBuilder documentBuilder;

    public GemsDOMBuilder() {
        gems = new HashSet<Gem>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Ошибка конфигурации парсера: " + e.getMessage());
        }
    }

    public void buildSetGems(String filename) {
        Document document = null;
        try {
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList gemList = root.getElementsByTagName("gem");
            for (int i = 0; i < gemList.getLength(); i++) {
                Element gemElement = (Element) gemList.item(i);
                Gem gem = buildGem(gemElement);
                gems.add(gem);
            }
        } catch (IOException e) {
            LOGGER.error("Ошибка файла I/O: " + e.getMessage());
        } catch (SAXException e) {
            LOGGER.error("ошибка SAX парсера: " + e.getMessage());
        }
    }

    private Gem buildGem(Element gemElement) {
        Gem gem = new Gem();

        gem.setId(gemElement.getAttribute("id"));
        gem.setName(getElementTextContent(gemElement, "name"));
        gem.setPreciousness(Preciousness.valueOf(getElementTextContent(gemElement, "preciousness").toUpperCase()));
        gem.setOrigin(new Locale(getElementTextContent(gemElement, "origin")));
        Element elementVisualParameter = (Element) gemElement.getElementsByTagName("visualParameters").item(0);
        VisualParameter visualParameter = new VisualParameter();
        visualParameter.setColor(getElementTextContent(elementVisualParameter, "color"));
        visualParameter.setTransparency(new Byte(getElementTextContent(elementVisualParameter, "transparency")));
        visualParameter.setCountFacets(new Byte(getElementTextContent(elementVisualParameter, "countFacets")));
        gem.setVisualParameter(visualParameter);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
        try {
            gem.setExtractionTime(formatter.parse(getElementTextContent(gemElement, "extractionTime")));
        } catch (ParseException e) {
            LOGGER.error("Parse error :" + e);
        }
        Value value = new Value();
        Element elementValue = (Element) gemElement.getElementsByTagName("value").item(0);
        if (elementValue.hasAttribute("unit")) {
            value.setUnit(Unit.getUnit(elementValue.getAttribute("unit")));
        } else {
            value.setUnit(Unit.CARAT);
        }
        value.setValue(new Integer(getElementTextContent(gemElement, "value")));
        gem.setValue(value);
        return gem;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }


}
