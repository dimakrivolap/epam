/*
 * Sweet
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
package main.model.entity;

public abstract class Sweet {
    private double sugar;
    private double weight;

    public double getSugar(){
        return sugar;
    }

    public double getWeight(){
        return weight;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
