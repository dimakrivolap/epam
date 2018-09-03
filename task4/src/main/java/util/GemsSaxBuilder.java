package util;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class GemsSaxBuilder extends AbstractGemsBuilder {
    private static final Logger LOGGER = Logger.getLogger(GemsSaxBuilder.class);
    private GemHandler gemHandler;
    private XMLReader reader;

    public GemsSaxBuilder() {
        gemHandler = new GemHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemHandler);
        } catch (SAXException e) {
            LOGGER.error("ошибка SAX парсера: " + e);

        }
    }

    public void buildSetGems(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.error("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            LOGGER.error("ошибка I/О потока: " + e);
        }
        gems = gemHandler.getGems();
    }
}
