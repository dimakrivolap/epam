import model.entity.TextComposite;
import org.apache.log4j.Logger;
import service.parser.BaseParser;
import service.parser.TextParser;
import service.reader.FileReader;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        String fileName = "text.txt";
        String text = FileReader.read(fileName).toString();
        BaseParser textParser = new TextParser(text);
        LOGGER.info("File :" + fileName+ "is read");
        TextComposite textComposite = textParser.parse();
        String sortedText = Sorter.sort(textComposite);

    }
}
