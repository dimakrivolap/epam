import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String text;
    public Parser(String file) {
        while (true) {
            try {
                FileReader fr = new FileReader(file);
                Scanner scan = new Scanner(fr);
                int i = 1;
                while (scan.hasNextLine()) {
                    text+=scan.nextLine();
                    i++;
                }
                fr.close();
            }
            catch (Exception e){

            }

        }
    }


    public void getSortedText(){
        int[] length = getSizeSentences();
        for (int j=0;j<length.length;j++) {
            for (int i = 0; i < length.length - 1; i++) {
                if (length[i] < length[i + 1]) {
                    int tmp = length[i];
                    length[i] = length[i + 1];
                    length[i + 1] = tmp;
                }
            }
        }
    }
    private List<String> getSentences(){
        Matcher matcher = Pattern.compile("([^.!?]+)").matcher(text);
        List<String> list = new ArrayList<>();
        while (matcher.find())
        {
            list.add(matcher.group(1));
        }
        return list;
    }

    private String[] getWords(String sentence){
        Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
        return pattern.split(sentence);
    }

    private int[] getSizeSentences(){
        List<String> sentences = getSentences();
        int[] length = new int[sentences.size()];
        int i = 0;
        for (String sentence : sentences){
            String[] words = getWords(sentence);
            length[i] = words.length;
            i++;
        }
        return length;
    }
}
