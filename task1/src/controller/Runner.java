package controller;
/*
 * service.Runner
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
import model.entity.Gift;
import service.GiftCharacteristic;
import service.RandomGiftCreator;
import model.entity.Sweet;
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
    public static void main(String[] args) {
        Gift gift = RandomGiftCreator.createGift();
        System.out.println("Total Weight : " + GiftCharacteristic.getWeight(gift.getSweets()));
        System.out.println("Original: ");
        printSweets(gift.getSweets());
        System.out.println("Sorted by weight: ");
        Sorter.sortWeight(gift.getSweets());
        printSweets(gift.getSweets());
        System.out.println("Sorted by sugar: ");
        Sorter.sortSugar(gift.getSweets());
        printSweets(gift.getSweets());
        System.out.println("Found sweets: ");
        printSweets(Searcher.find(gift.getSweets(),50, 60));
    }

    private static void printSweets(List<Sweet> list) {
        System.out.println();
        for (Sweet sweet : list) {
            System.out.println(sweet.getSweetType()
                    + " Weight: " + sweet.getWeight()
                    + " Sugar: " + sweet.getSugar());
        }
    }
}
