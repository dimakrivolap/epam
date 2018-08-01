package service.parser;

import model.entity.TextComponent;
import model.entity.TextComposite;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseParser implements Parser{
    private BaseParser nextParser;
    private static final Logger LOGGER = Logger.getLogger(BaseParser.class);

    public BaseParser getNextParser() {
        return nextParser;
    }

    public void setNextParser(BaseParser nextParser) {
        this.nextParser = nextParser;
    }

    public TextComponent parse(String text){
        return null;
    }

}
