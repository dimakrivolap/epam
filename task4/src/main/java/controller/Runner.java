package controller;

import util.GemValidator;
import util.GemsSaxBuilder;

class Runner {
    public static void main(String[ ] args) {
        String fileName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xml";
        String schemaName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xsd";
        GemValidator.validate(fileName,schemaName);
/*        String filename = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xml";
        String schemaname = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xsd";
        try {
// создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            GemHandler handler = new GemHandler();
            reader.setContentHandler(handler);
            reader.parse(filename);
            reader.
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }*/
    }
}

