package service;
/*
 * service.Sorter
 *
 * Version 1.0
 *
 * Copyright Dmitry Krivolap, 2018
 */
import model.entity.Sweet;
import java.util.List;
/**
 * Sorter is the class of buisness-logic which have ability to sort sweets by:
 * -weight
 * -sugar
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */
public class Sorter {

    public static void sortWeight(List<Sweet> sweets) {
        sweets.sort((sweet1, sweet2) ->
                (int) (sweet1.getWeight() - sweet2.getWeight()));
    }

    public static void sortSugar(List<Sweet> sweets) {
        sweets.sort((sweet1, sweet2) ->
                (int) (sweet1.getSugar() - sweet2.getSugar()));
    }
}
