package service;
/*
 * service.RandomGiftCreator
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */

import model.entity.Gift;
import model.entity.Sweet;
import java.util.Random;
import static model.entity.SweetType.*;
/**
 * Factory class for gift creation commands.
 *
 * @author Dmitry Krivolap
 * @version 1.0
 * @see Gift
 */
public class RandomGiftCreator {

    private static Random random = new Random();

    public static Gift createGift() {
        Gift gift = new Gift();
            for (int i = 0; i < 10; i++) {
                gift.addSweet(createSweet());
            }
        return gift;
    }

    public static Sweet createSweet(){
        switch (random.nextInt(3)) {
            case 0:
                return new Sweet(TWIX, 70, 70);
            case 1:
                return new Sweet(SNICKERS, 50, 80);
            default:
                return new Sweet(MARS, 60, 60);
        }
    }

}
