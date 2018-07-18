/*
 * Gift
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
package main.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Gift {

    private List<Sweet> sweets;

    Gift() {
        sweets = new ArrayList<>();
    }

    public void setSweets(List<Sweet> sweets) {
        this.sweets = sweets;
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    public double getWeight() {
        double sum = 0.0;
        for (Sweet sweet : sweets) {
            sum += sweet.getWeight();
        }
        return sum;
    }

    public List<Sweet> find(double sugarMin, double sugarMax) {
        List<Sweet> list = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if ((sweet.getSugar() > sugarMin) && (sweet.getSugar() < sugarMax)) {
                list.add(sweet);
            }
        }
        return list;
    }

    public void sortWeight() {
        sweets.sort((sweet1, sweet2) ->
                (int) (sweet1.getWeight() - sweet2.getWeight()));
    }
}
