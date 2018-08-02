package service.parser;

import model.entity.TextComponent;
import model.entity.TextComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {

    public SentenceParser() {
        setNextParser(new WordParser());
    }

    @Override
    public TextComponent parse(String text) {
        Matcher matcher = Pattern.compile("([^.!?]+)").matcher(text);
        TextComponent textComposite = new TextComposite();
        while (matcher.find())
        {
            //textComposite.add(matcher.group(1));
        }
        return null;
    }
}
