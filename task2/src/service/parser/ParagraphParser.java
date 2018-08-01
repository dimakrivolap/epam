package service.parser;

import model.entity.TextComponent;
import model.entity.TextComposite;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends BaseParser{
    private static final Logger LOGGER = Logger.getLogger(ParagraphParser.class);
    private static final String PARAGRAPH_REGEX = "[^.!?]+";

    public ParagraphParser(BaseParser nextParser) {
        setNextParser(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        if (text.isEmpty()) {
            LOGGER.error("Parse method is called on empty string inside TextParser.");
            throw new IllegalArgumentException("Parse method is called on empty string inside TextParser.");
        }
        TextComposite paragraph = new TextComposite();

        Matcher match = Pattern.compile(PARAGRAPH_REGEX, Pattern.UNICODE_CASE).matcher(text);
        while (match.find()) {
            String sentence = match.group();
            TextComponent component = this.getNextParser().parse(sentence);
            paragraph.add(component);
        }
        return paragraph;
    }

}
