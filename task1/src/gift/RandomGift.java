package gift;

import sweet.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomGift extends Gift {

    private Random random = new Random();

    public RandomGift() {
        createGift();
    }

    private void createGift() {
        List<Sweetable> sweets = new ArrayList<>();
        for (int i = 0; i < random.nextInt(5); i++) {
            sweets.add(new Twix());
        }
        for (int i = 0; i < random.nextInt(5); i++) {
            sweets.add(new Mars());
        }
        for (int i = 0; i < random.nextInt(5); i++) {
            sweets.add(new MiniSnickers());
        }
        for (int i = 0; i < random.nextInt(5); i++) {
            sweets.add(new BigSnickers());
        }
        setSweets(sweets);
    }

}
