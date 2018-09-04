package util;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void testTaskValid() {
        String fileName = "src\\main\\resources\\gems.xml";
        String schemaName = "src\\main\\resources\\gems.xsd";
        assertTrue(GemValidator.isValid(fileName, schemaName));
    }
}
