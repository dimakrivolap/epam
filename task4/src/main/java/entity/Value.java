package entity;

public class Value {
    private Unit unit;
    private int Value;

    public Value(Unit unit, int value) {
        this.unit = unit;
        Value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }
}
