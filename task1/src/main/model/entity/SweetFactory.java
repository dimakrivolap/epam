/*
 * SweetFactory
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
package main.model.entity;

public class SweetFactory {
    public Sweet getSweet(String sweetType){
        if(sweetType == null){
            return null;
        }
        if(sweetType.equalsIgnoreCase("TWIX")){
            return new Twix();

        } else if(sweetType.equalsIgnoreCase("MARS")){
            return new Mars();

        } else if(sweetType.equalsIgnoreCase("SNICKERS")){
            return new Snickers();
        }

        return null;
    }
}