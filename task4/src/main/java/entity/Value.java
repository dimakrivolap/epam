package entity;
/**
 * Value.(Weight)
 * <p>
 * 26 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 * @see Unit
 */

import java.util.Objects;

public class Value {
    private Unit unit;
    private int value;

    public Value() {
    }

    public Value(Unit unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return value == value1.value &&
                unit == value1.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, value);
    }

    @Override
    public String toString() {
        return "Value{" +
                "unit=" + unit +
                ", value=" + value +
                '}';
    }
}
