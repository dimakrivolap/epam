package util;

public class GemBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractGemsBuilder createGemBuilder (String typeParser) {
        TypeParser parser = TypeParser.valueOf(typeParser.toUpperCase());
        switch (parser) {
            case SAX:
                return new GemsSaxBuilder();
            case STAX:
                return new GemsStaxBuilder();
            case DOM:
                return new GemsDOMBuilder();
            default:
                throw new EnumConstantNotPresentException(
                        parser.getDeclaringClass(), parser.name());
        }
    }
}
