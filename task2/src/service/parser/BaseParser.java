package service.parser;

import model.entity.TextComponent;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class BaseParser implements Parser{
    private BaseParser nextParser;
    private static final Logger LOGGER = Logger.getLogger(BaseParser.class);

    public BaseParser getNextParser() {
        return nextParser;
    }

    public void setNextParser(BaseParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract TextComponent parse(String text);



    protected void saveToFile(TextComponent component){
        try {
            Files.write(Paths.get("result.txt"), component.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            LOGGER.error("IOException" + e.getStackTrace());
        }
    }

}
