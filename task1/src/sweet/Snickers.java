package sweet;

public abstract class Snickers implements Sweetable {

    @Override
    public double getSugar() {
        return 50;
    }

    @Override
    abstract public double getWeight();
}
