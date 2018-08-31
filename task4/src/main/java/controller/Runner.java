package controller;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import util.GemHandler;

class Runner {
    public static void main(String[ ] args) {
        String filename = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xml";
        String schemaname = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xsd";
        try {
// создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            GemHandler handler = new GemHandler();
            reader.setContentHandler(handler);
            reader.parse(filename);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }
}

