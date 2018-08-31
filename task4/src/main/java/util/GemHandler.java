package util;

import entity.Gem;
import entity.GemEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class GemHandler extends DefaultHandler {
    private Set<Gem> gems;
    private Gem current = null;
    private GemEnum currentEnum = null;

    public GemHandler() {
        gems = new HashSet<Gem>();
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public void setGems(Set<Gem> gems) {
        this.gems = gems;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String s = localName;
        for (int i = 0; i < attributes.getLength(); i++) {
            s += " " + attributes.getLocalName(i) + "=" + attributes.getValue(i);
        }
        System.out.print(s.trim());
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("gem".equals(localName)) {
            gems.add(current);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nParsing ended");
    }
}
