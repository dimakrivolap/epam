package util;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class GemValidator {
    private static final Logger LOGGER = Logger.getLogger(GemValidator.class);
    public static void validate(String fileName,String schemaName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            LOGGER.info(fileName + " is valid.");
        } catch (SAXException e) {
            LOGGER.error("validation "+ fileName + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            LOGGER.error(fileName + " is not valid because "
                    + e.getMessage());
        }
    }
}
