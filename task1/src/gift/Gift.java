package gift;

import sweet.Sweetable;
import java.util.ArrayList;
import java.util.List;


public class Gift {
    private List<Sweetable> sweets;

    Gift() {
        sweets = new ArrayList<>();
    }

    public void setSweets(List<Sweetable> sweets) {
        this.sweets = sweets;
    }

    public List<Sweetable> getSweets() {
        return sweets;
    }

    public double getWeight() {
        double sum = 0.0;
        for (Sweetable sweet : sweets) {
            sum += sweet.getWeight();
        }
        return sum;
    }

    public List<Sweetable> find(double sugarMin, double sugarMax) {
        List<Sweetable> list = new ArrayList<>();
        for (Sweetable sweet : sweets) {
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
