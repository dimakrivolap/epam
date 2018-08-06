
import model.entity.TextComponent;
import org.apache.log4j.Logger;

import service.parser.*;
import service.reader.FileReader;
import util.Sorter;

public class Runner2 {
    private static final Logger LOGGER = Logger.getLogger(Runner2.class);

    public static void main(String[] args) {

        String fileName = "D:\\EPAM\\tasks\\mytasks\\task2\\resources\\text.txt";
        LOGGER.info("Reading file...");
        String text = FileReader.read(fileName).toString();

        BaseParser textParser = new TextParser();
        BaseParser paragraphParser = new ParagraphParser();
        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(new SentenceParser());

        TextComponent content = textParser.parse(text);
        System.out.println(content.toString());

        Sorter sorter = new Sorter(content);
        System.out.println(sorter.getWordContent(content));

    }
}
