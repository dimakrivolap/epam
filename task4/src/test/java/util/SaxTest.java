package util;

import entity.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.testng.Assert.*;

public class SaxTest {

    GemsSaxBuilder saxBuilder = new GemsSaxBuilder();

    String schemaName = "src\\main\\resources\\gems.xsd";
    String fileName;
    SimpleDateFormat formatter;

    @BeforeClass
    public void initData(){
        fileName = "src\\main\\resources\\gem_for_test.xml";
        formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
    }

    @Test
    public void testWithOneGemValid() {
        fileName = "src\\main\\resources\\gem_for_test.xml";
        assertTrue(GemValidator.isValid(fileName, schemaName));
    }

    @Test
    public void saxTestWithOneGem() throws ParseException {
        fileName = "src\\main\\resources\\gem_for_test.xml";
        Gem original = new Gem("ID-1", "amethyst", Preciousness.PRECIOUS,
                new Locale("RU"), new VisualParameter("purple",
                (byte) 100, (byte) 6), formatter.parse("2018-08-25"),
                new Value(Unit.GRAM, 5));
        saxBuilder.buildSetGems(fileName);
        Gem gem = saxBuilder.getGems().iterator().next();
        assertTrue(original.hashCode() == gem.hashCode());
    }


}
