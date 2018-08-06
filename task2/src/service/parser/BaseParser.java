package service.parser;

import model.entity.TextComponent;
import org.apache.log4j.Logger;

public abstract class BaseParser implements Parser{

    /**
     * Base parser takes entire content and parses it down to words using parsing chain and separate parsers: Paragraph, Sentence and Word parsers.
     * @see TextParser
     * @see ParagraphParser
     * @see SentenceParser
     */

    BaseParser nextParser;

    @Override
    public abstract TextComponent parse(String text);

    public void setNextParser(BaseParser parser){
        nextParser = parser;
    }

    public BaseParser getNextParser() {
        return nextParser;
    }
}

