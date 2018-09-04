package util;

import entity.*;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * GemsStaxBuilder  . Builder gems set.
 * <p>
 * 26 August 2018
 *
 * @author Dmitry Krivolap
 * @version 1.0
 */
public class GemsStaxBuilder extends AbstractGemsBuilder {
    private static final Logger LOGGER = Logger.getLogger(GemsSaxBuilder.class);
    private XMLInputFactory inputFactory;

    public GemsStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildSetGems(String filename) {
        XMLStreamReader reader = null;
        String name;
        try (InputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamReader.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.GEM) {
                        Gem gem = buildGem(reader);
                        gems.add(gem);
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error("ошибка StAX парсера: " + e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл не найден" + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("ошибка I/О потока: " + e.getMessage());
        }

    }

    private Gem buildGem(XMLStreamReader reader) throws XMLStreamException {
        Gem gem = new Gem();
        gem.setId(reader.getAttributeValue(0));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
        String name;
        int type;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            gem.setName(getXMLText(reader));
                            break;
                        case PRECIOUSNESS:
                            gem.setPreciousness(Preciousness.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case ORIGIN:
                            gem.setOrigin(new Locale(getXMLText(reader)));
                            break;
                        case VISUALPARAMETERS:
                            gem.setVisualParameter(getXMLVisualParameter(reader));
                            break;
                        case EXTRACTIONTIME:
                            try {
                                gem.setExtractionTime(formatter.parse(getXMLText(reader)));
                            } catch (ParseException e) {
                                LOGGER.error("Parse error :" + e.getMessage());
                            } finally {
                                break;
                            }
                        case VALUE:
                            gem.setValue(getXMLValue(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.GEM) {
                        return gem;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Gem");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private VisualParameter getXMLVisualParameter(XMLStreamReader reader) throws XMLStreamException {
        VisualParameter visualParameter = new VisualParameter();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemEnum.valueOf(name.toUpperCase())) {
                        case COLOR:
                            visualParameter.setColor(getXMLText(reader));
                            break;
                        case TRANSPARENCY:
                            visualParameter.setTransparency(new Byte(getXMLText(reader)));
                            break;
                        case COUNTFACETS:
                            visualParameter.setCountFacets(new Byte(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.VISUALPARAMETERS) {
                        return visualParameter;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag VisualParameter");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        if (reader.getAttributeCount() > 0) {
            value.setUnit(Unit.getUnit(reader.getAttributeValue(0)));
        } else {
            value.setUnit(Unit.CARAT);
        }
        value.setValue(new Integer(getXMLText(reader)));
        return value;
    }
}
