package util;

import entity.*;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class DomTest {

    GemsDOMBuilder gemsDOMBuilder = new GemsDOMBuilder();
    String schemaName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gems.xsd";

    @Test
    public void testDom() {
    }


    @Test
    public void domTestWithOneGem() throws ParseException {
        String fileName = "D:\\EPAM\\tasks\\mytasks\\task4\\src\\main\\resources\\gem_for_test.xml";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
        Gem original = new Gem("ID-1", "amethyst", Preciousness.PRECIOUS,
                new Locale("RU"), new VisualParameter("purple",
                (byte) 100, (byte) 6), formatter.parse("2018-08-25"),
                new Value(Unit.GRAM, 5));
        gemsDOMBuilder.buildSetGems(fileName);
        Gem gem = gemsDOMBuilder.getGems().iterator().next();
        assertTrue(original.hashCode() == gem.hashCode());
    }

}
