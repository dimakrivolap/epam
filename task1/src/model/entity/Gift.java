package model.entity;/*
 * model.entity.Gift
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */

import java.util.ArrayList;
import java.util.List;

public class Gift {

    private List<Sweet> sweets;

    public Gift() {
        sweets = new ArrayList<>();
    }

    public void addSweet(Sweet sweet){
        this.sweets.add(sweet);
    }

    public void setSweets(List<Sweet> sweets) {
        this.sweets = sweets;
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

}
