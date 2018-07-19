package service;
/*
 * service.GiftCharacteristic
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
import model.entity.Sweet;

import java.util.List;
/**
 * GiftCharacteristic is the class which give characteristic of a gift
 *
 * @author Dmitry Krivolap
 * @version 1.0
 * @see model.entity.Gift
 */
public class GiftCharacteristic {

    public static double getWeight(List<Sweet> sweets) {
        double sum = 0.0;
        for (Sweet sweet : sweets) {
            sum += sweet.getWeight();
        }
        return sum;
    }
}
