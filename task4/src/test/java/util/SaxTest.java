package util;

import entity.*;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.testng.Assert.*;

public class SaxTest {

    GemsSaxBuilder saxBuilder = new GemsSaxBuilder();

    String schemaName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xsd";

    @Test
    public void testWithOneGemValid() {
        String fileName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gem_for_test.xml";
        assertTrue(GemValidator.isValid(fileName, schemaName));
    }

    @Test
    public void testTaskValid() {
        String fileName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xml";
        assertTrue(GemValidator.isValid(fileName, schemaName));
    }

    @Test
    public void saxTestWithOneGem() throws ParseException {
        String fileName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gem_for_test.xml";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
        Gem original = new Gem("ID-1", "amethyst", Preciousness.PRECIOUS,
                new Locale("RU"), new VisualParameter("purple",
                (byte) 100, (byte) 6), formatter.parse("2018-08-25"),
                new Value(Unit.GRAM, 5));
        saxBuilder.buildSetGems(fileName);
        Gem gem = saxBuilder.getGems().iterator().next();
        assertTrue(original.hashCode() == gem.hashCode());
    }


}
