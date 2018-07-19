package model.entity;
/*
 * model.entity.SweetType
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
/**
 * Enum type that consist of all types of sweets.
 *
 * @author Dmitry Krivolap
 * @version 1.0
 * @see Sweet
 */
public enum SweetType {
    TWIX, SNICKERS, MARS;


    public static SweetType getType(String type){
        switch (type) {
            case "TWIX":
                return TWIX;
            case "SNICKERS":
                return SNICKERS;
            case "MARS":
                return MARS;
        }
        return null;
    }
}
