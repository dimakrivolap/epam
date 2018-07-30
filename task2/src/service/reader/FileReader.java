package service.reader;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;


public class FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class);

    public static StringBuilder read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(fileName)) {
            String data = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
                    Charset.forName("UTF-8")));
            while ((data = reader.readLine()) != null) {
                stringBuilder.append(data);
                stringBuilder.append("\n");
            }
            reader.close();
        } catch (Exception e) {
            LOGGER.error("Error while reading " + fileName, e);
        }
        return stringBuilder;
    }
}