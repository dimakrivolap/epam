package service.parser;

import model.entity.TextComponent;
import org.apache.log4j.Logger;

public class ProgrammingBookParser extends BaseParser{
    private static final Logger LOGGER = Logger.getLogger(ProgrammingBookParser.class);

    public ProgrammingBookParser() {
        setNextParser(new ParagraphParser());
    }

    @Override
    public TextComponent parse(String text) {
        return null;
    }
}
