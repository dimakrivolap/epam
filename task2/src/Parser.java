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

    private void getSizeSentences(){
        List<String> sentences = getSentences();
        for (String sentence : sentences){
            String[] words = getWords(sentence);


        }
    }
}
