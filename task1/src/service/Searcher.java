package service;

import model.entity.Sweet;
import java.util.ArrayList;
import java.util.List;

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
