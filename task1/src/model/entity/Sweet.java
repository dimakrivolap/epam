package model.entity;/*
 * model.entity.Sweet
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */

public class Sweet {
    private double sugar;
    private double weight;
    private SweetType sweetType;

    public Sweet(SweetType sweetType, double sugar, double weight) {
        this.sweetType = sweetType;
        this.sugar = sugar;
        this.weight = weight;
    }

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

    public SweetType getSweetType() {
        return sweetType;
    }
}
