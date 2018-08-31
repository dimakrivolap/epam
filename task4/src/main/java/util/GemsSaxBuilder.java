package util;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class GemsSaxBuilder extends AbstractGemsBuilder {
    private GemHandler gemHandler;
    private XMLReader reader;

    public GemsSaxBuilder() {
        gemHandler = new GemHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemHandler);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public void buildSetGems(String fileName) {
        try {
// разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        gems = gemHandler.getGems();
    }
}
