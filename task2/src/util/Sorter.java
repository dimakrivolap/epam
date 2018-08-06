package util;

import model.entity.TextComponent;
import model.entity.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sorter {
    private TextComponent component;
    private List<String> wordList = new ArrayList<>();
    private String regex = ResourceBundle.getBundle("regex").getString("WORD_REGEX");

    public Sorter(TextComponent component) {
        this.component = component;
    }

    public List<String> getWordContent(TextComponent curContent) {
        Matcher match;
        for (TextComponent c : curContent.getComponentList()) {
            if (c instanceof TextElement) {
                String sent = "";
                match = Pattern.compile(regex, Pattern.UNICODE_CASE).matcher(c.getTextComponent());
                while (match.find()) {
                    sent = match.group();
                }
                wordList.add(sent);
            } else {
                for (TextComponent cc : c.getComponentList())
                    getWordContent(cc);
            }
        }
        return wordList;
    }

    public List<String> sortPerWordQuantity(){

        List<String> result = new ArrayList<>();

        return result;
    }

    public List<String> getSentences() {
        Matcher matcher = Pattern.compile("([^.!?]+)").matcher(component.getTextComponent());
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }

    private List<String> getWordsInSentence(String sentence) {
        Matcher matcher = Pattern.compile("\\w+").matcher(sentence);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
