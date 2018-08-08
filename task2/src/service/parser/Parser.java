package service.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Parser for programming book.
 *
 * 08 August 2018
 * @version 1.0
 * @author Dmitry Krivolap
 */
public class Parser {
    private String text;

    public Parser() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public List<String> getParagraphs() {
        Matcher matcher = Pattern.compile("([^\t]+)").matcher(text);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }

    public List<String> getSentences() {
        Matcher matcher = Pattern.compile("([^.!?]+)").matcher(text);
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

    public List<String> getAllWords() {
        List<String> allWords = new ArrayList<>();
        for (String sentance : getSentences()) {
            allWords.addAll(getWordsInSentence(sentance));
        }
        return allWords;
    }


    public void parse() {
        List<String> paragraphs = getParagraphs();
        List<String> sentences = getSentences();
        List<String> words = getAllWords();
        System.out.println("Paragraphs: " + paragraphs + "\n");
        System.out.println("Sentences: " + sentences + "\n");
        System.out.println("Words: " + words + "\n");
    }


}
