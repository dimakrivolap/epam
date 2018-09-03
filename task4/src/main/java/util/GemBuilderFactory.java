package util;
/**
 * GemBuilderFactory. Class Factory for SAX, StAX , DOM Builders.
 * <p>
 * 26 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */

import org.apache.log4j.Logger;

public class GemBuilderFactory {
    private static final Logger LOGGER = Logger.getLogger(GemBuilderFactory.class);

    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractGemsBuilder createGemBuilder(String typeParser) {
        TypeParser parser = TypeParser.valueOf(typeParser.toUpperCase());
        switch (parser) {
            case SAX:
                return new GemsSaxBuilder();
            case STAX:
                return new GemsStaxBuilder();
            case DOM:
                return new GemsDOMBuilder();
            default:
                LOGGER.error("GemBuilderFactory Error");
                throw new EnumConstantNotPresentException(
                        parser.getDeclaringClass(), parser.name());

        }
    }
}
