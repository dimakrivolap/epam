package util;
/**
 * GemHandler. Handler for SAX Parser.
 * <p>
 * 26 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */

import entity.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GemHandler extends DefaultHandler {
    private static final Logger LOGGER = Logger.getLogger(GemHandler.class);
    private Set<Gem> gems;
    private Gem current = null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;

    public GemHandler() {
        gems = new HashSet<Gem>();
        withText = EnumSet.range(GemEnum.NAME, GemEnum.EXTRACTIONTIME);
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public void setGems(Set<Gem> gems) {
        this.gems = gems;
    }

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("gem".equals(localName)) {
            current = new Gem();
            current.setId(attributes.getValue(0));
        } else if ("value".equals(localName)) {
            if (attributes.getValue(0) != null) {
                current.getValue().setUnit(Unit.getUnit(attributes.getValue(0)));
                currentEnum = GemEnum.VALUE;
            } else {
                current.getValue().setUnit(Unit.CARAT);
            }
        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case PRECIOUSNESS:
                    current.setPreciousness(Preciousness.valueOf(s.toUpperCase()));
                    break;
                case ORIGIN:
                    current.setOrigin(new Locale(s));
                    break;
                case COLOR:
                    current.getVisualParameter().setColor(s);
                    break;
                case TRANSPARENCY:
                    current.getVisualParameter().setTransparency(new Byte(s));
                    break;
                case COUNTFACETS:
                    current.getVisualParameter().setCountFacets(new Byte(s));
                    break;
                case EXTRACTIONTIME:
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
                    try {
                        current.setExtractionTime(formatter.parse(s));
                    } catch (ParseException e) {
                        LOGGER.error("Parse error :" + s);
                    }
                    break;
                case VALUE:
                    current.getValue().setValue(new Integer(s));
                    break;
                default:
                    LOGGER.error("EnumConstantNotPresentException");
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("gem".equals(localName)) {
            gems.add(current);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("\nParsing ended");
    }
}
