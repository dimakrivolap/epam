package service.parser;

import org.apache.log4j.Logger;

public abstract class BaseParser implements Parser{
    private BaseParser baseParser;
    private static final Logger LOGGER = Logger.getLogger(BaseParser.class);
    public void parse(String text){
        if (text.isEmpty()) {
            LOGGER.error("Parse method is called on empty string inside TextParser.");
            throw new IllegalArgumentException("Parse method is called on empty string inside TextParser.");
        }
    }

    public BaseParser getBaseParser() {
        return baseParser;
    }

    public void setBaseParser(BaseParser baseParser) {
        this.baseParser = baseParser;
    }
}
