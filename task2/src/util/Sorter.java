package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Sorter is class which has method sort by count words.
 *
 * 08 August 2018
 * @version 1.0
 * @author Dmitry Krivolap
 */
public class Sorter {
    public Sorter() {
    }

    public static void sortByCountWords(List<String> sentences) {
        //List<String> sentences = getSentences();
        for (int i = 0; i < sentences.size(); i++) {
            for (int j = 0; j < sentences.size(); j++) {
                if (getCountWordsSentence(sentences.get(i)) <
                        getCountWordsSentence(sentences.get(j))) {
                    String buf = sentences.get(i);
                    sentences.set(i, sentences.get(j));
                    sentences.set(j, buf);
                }
            }
        }
        //return sentences.toString();
    }

    private static int getCountWordsSentence(String sentence) {
        List<String> words = getWordsInSentence(sentence);
        return words.size();
    }

    private static List<String> getWordsInSentence(String sentence) {
        Matcher matcher = Pattern.compile("\\w+").matcher(sentence);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
