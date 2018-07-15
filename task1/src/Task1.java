/*
 * Task1
 *
 * Version 1.0
 *
 * Copyright Криволап Д.Э., 2018
 */

import gift.Gift;
import gift.RandomGift;
import sweet.Sweetable;

import java.util.List;

public class Task1 {
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

    private static void printSweets(List<Sweetable> list) {
        System.out.println();
        for (Sweetable sweet : list) {
            System.out.println(sweet.getClass().getName()
                    + " Weight: " + sweet.getWeight()
                    + " Sugar: " + sweet.getSugar());
        }
    }
}
