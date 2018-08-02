
import org.apache.log4j.Logger;

import service.parser.BaseParser;
import service.parser.ParagraphParser;
import service.reader.FileReader;

public class Runner2 {
    private static final Logger LOGGER = Logger.getLogger(Runner2.class);

    public static void main(String[] args) {

        String fileName = "D:\\EPAM\\tasks\\mytasks\\task2\\resources\\text.txt";
        String text = FileReader.read(fileName).toString();
        Parser parser = new Parser();
        parser.setText(text);
        parser.parse();
        System.out.println(parser.getSortedText());
        //System.out.println(parser.getSentences());
        //System.out.println(parser.getParagraphs());
        //BaseParser textParser = new ProgrammingBookParser(text);
        //LOGGER.info("File :" + fileName+ "is read");
        //TextComposite textComposite = textParser.parse();
        //String sortedText = Sorter.sort(textComposite);

    }
}
