package main.controller;/*
 * main.controller.Runner
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */

import main.model.entity.Gift;
import main.model.entity.RandomGift;
import main.model.entity.Sweet;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Gift gift = new RandomGift();
        System.out.println("Total Weight : " + gift.getWeight());
        System.out.println("Original: ");
        printSweets(gift.getSweets());
        gift.sortWeight();
        System.out.println("Sorted: ");
        printSweets(gift.getSweets());
        System.out.println("Found sweets: ");
        printSweets(gift.find(50, 60));
    }

    private static void printSweets(List<Sweet> list) {
        System.out.println();
        for (Sweet sweet : list) {
            System.out.println(sweet.getClass().getName()
                    + " Weight: " + sweet.getWeight()
                    + " Sugar: " + sweet.getSugar());
        }
    }
}
