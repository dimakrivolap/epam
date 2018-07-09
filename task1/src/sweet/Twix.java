package sweet;

public class Twix implements Sweetable {
    public Twix() {
    }

    @Override
    public double getSugar() {
        return 55;
    }

    @Override
    public double getWeight() {
        return 70;
    }
}
