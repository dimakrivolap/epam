package service;
/*
 * service.Searcher
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
import model.entity.Sweet;
import java.util.ArrayList;
import java.util.List;
/**
 * Searcher is the class of buisness-logic which have ability to search sweets by sugar
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */
public class Searcher {

    public static List<Sweet> find(List<Sweet> sweets, double sugarMin, double sugarMax) {
        List<Sweet> list = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if ((sweet.getSugar() > sugarMin) && (sweet.getSugar() < sugarMax)) {
                list.add(sweet);
            }
        }
        return list;
    }
}
