package controller;

import org.apache.log4j.Logger;

import service.parser.Parser;
import service.reader.FileReader;
import util.Sorter;

import java.util.List;
/**
 * Runner2 is class controller for task 2.
 *
 * 08 August 2018
 * @version 1.0
 * @author Dmitry Krivolap
 */
public class Runner2 {
    private static final Logger LOGGER = Logger.getLogger(Runner2.class);

    public static void main(String[] args) {

        String fileName = "D:\\EPAM\\tasks\\mytasks\\task2\\resources\\text.txt";
        LOGGER.info("file is reading...");
        String text = FileReader.read(fileName).toString();
        LOGGER.info("File :" + fileName+ "is read");
        Parser parser = new Parser();
        parser.setText(text);
        parser.parse();
        LOGGER.info("The parser is completed");
        
        //idividual task
        List<String> sentences = parser.getSentences();
        Sorter.sortByCountWords(sentences);
        LOGGER.info("Text is sorted");
        System.out.println("Sorted text:");
        System.out.println(sentences);
    }
}
