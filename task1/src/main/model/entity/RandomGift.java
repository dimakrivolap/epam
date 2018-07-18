/*
 * RandomGift
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
package main.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGift extends Gift {

    private Random random = new Random();

    public RandomGift() {
        createGift();
    }

    private void createGift() {
        List<Sweet> sweets = new ArrayList<>();
        SweetFactory sweetFactory = new SweetFactory();
        for(SweetType type: SweetType.values()) {
            for (int i = 0; i < random.nextInt(5); i++) {
                sweets.add(sweetFactory.getSweet(type.name()));
            }
        }
        setSweets(sweets);
    }

}
