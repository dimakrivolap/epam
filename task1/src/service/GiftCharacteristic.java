package service;

import model.entity.Sweet;

import java.util.List;

public class GiftCharacteristic {

    public static double getWeight(List<Sweet> sweets) {
        double sum = 0.0;
        for (Sweet sweet : sweets) {
            sum += sweet.getWeight();
        }
        return sum;
    }
}
