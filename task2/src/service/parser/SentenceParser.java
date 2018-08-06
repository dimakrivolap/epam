package service.parser;

import model.entity.TextComponent;
import model.entity.TextComposite;
import model.entity.TextElement;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {

    private static final Logger LOGGER = Logger.getLogger("SentenceParser");
    private String regex = ResourceBundle.getBundle("regex").getString("SENTENCE_REGEX");

    @Override
    public TextComponent parse(String text) {
        if (text.isEmpty()) {
            LOGGER.error("Parse method is called on empty string inside SentenceParser.");
            throw new IllegalArgumentException("Parse method is called on empty string inside SentenceParser.");
        }

        TextComponent sent = new TextComposite();

        Matcher match = Pattern.compile(regex, Pattern.UNICODE_CASE).matcher(text);
        while (match.find()) {
            String word = match.group();
            TextElement cWord = new TextElement(word);
            sent.add(cWord);
        }
        return sent;
    }


}
