package service.parser;

import model.entity.TextComponent;
import model.entity.TextComposite;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends BaseParser{

    private static final Logger LOGGER = Logger.getLogger(TextParser.class);
    private String regex = ResourceBundle.getBundle("regex").getString("TEXT_REGEX");

    @Override
    public TextComponent parse(String text) {
        if (text.isEmpty()) {
            LOGGER.error("Parse method is called on empty string inside TextParser.");
            throw new IllegalArgumentException("Parse method is called on empty string inside TextParser.");
        }

        TextComponent entireText = new TextComposite();

        Matcher match = Pattern.compile(regex, Pattern.UNICODE_CASE).matcher(text);
        while (match.find()) {
            String parag = match.group();
            TextComponent content = nextParser.parse(parag);
            entireText.add(content);
        }
        return entireText;
    }
}