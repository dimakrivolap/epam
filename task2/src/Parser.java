import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String getSortedText() {
        String result = "";
        int maxLength = 0;
        String maxSentence = "";
        String[] sentences = (String[]) getSentences().toArray();
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < sentences.length; j++) {
                if (getWordsInSentence(sentences[i]).toArray().length < getWordsInSentence(sentences[j]).toArray().length) {
                    //maxLength = sizeSentence;
                    maxSentence = sentences[j];
                }
            }
            result += maxSentence;
        }
        return result;
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

    private int[] getSizeSentences(List<String> sentences) {
        int[] length = new int[sentences.size()];
        int i = 0;
        for (String sentence : sentences) {
            List<String> words = getWordsInSentence(sentence);
            length[i] = words.size();
            i++;
        }
        return length;
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
