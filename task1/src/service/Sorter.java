package service;

import model.entity.Sweet;
import java.util.List;

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
