import gift.Gift;
import gift.RandomGift;
import sweet.Sweetable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gift gift = new RandomGift();
        System.out.println("Total Weight : " + gift.getWeight());
        printSweets(gift.getSweets());
        gift.sortWeight();
        printSweets(gift.getSweets());
        printSweets(gift.find(50, 60));
    }

    private static void printSweets(List<Sweetable> list) {
        System.out.println();
        for (Sweetable sweet : list) {
            System.out.println(sweet.getClass().getName()
                    + " Weight: " + sweet.getWeight()
                    + " Sugar: " + sweet.getSugar());
        }
    }
}
