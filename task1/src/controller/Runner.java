package controller;
/*
 * service.Runner
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
import model.entity.Gift;
import model.entity.Sweet;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import service.GiftCharacteristic;
import service.RandomGiftCreator;
import service.Searcher;
import service.Sorter;

import java.util.List;


/**
 * Runner contains controls for the most important classes from task1 package.
 *
 * @author Dmitry Krivolap
 * @version 1.0
 */
public class Runner {
    private static final Logger logger = Logger.getLogger("Runner");

    public static void main(String[] args) {
        Gift gift = RandomGiftCreator.createGift();
        logger.info("Total Weight : " + GiftCharacteristic.getWeight(gift.getSweets()));
        logger.debug("Original: ");
        printSweets(gift.getSweets());
        logger.debug("Sorted by weight: ");
        Sorter.sortWeight(gift.getSweets());
        printSweets(gift.getSweets());
        logger.debug("Sorted by sugar: ");
        Sorter.sortSugar(gift.getSweets());
        printSweets(gift.getSweets());
        logger.debug("Found sweets: ");
        printSweets(Searcher.find(gift.getSweets(),50, 60));
    }

    private static void printSweets(List<Sweet> list) {
        for (Sweet sweet : list) {
            logger.info(sweet.getSweetType()
                    + " Weight: " + sweet.getWeight()
                    + " Sugar: " + sweet.getSugar());
        }
    }
}
