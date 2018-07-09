/*
 * Snickers
 *
 * Version 1.0
 *
 * Copyright Криволап Д.Э., 2018
 */
package sweet;

public abstract class Snickers implements Sweetable {

    @Override
    public double getSugar() {
        return 50;
    }

    @Override
    abstract public double getWeight();
}
