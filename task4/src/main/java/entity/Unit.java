package entity;

public enum Unit {
    GRAM("g"), CARAT("ct");

    private String value;
    Unit(String unit) {
        value = unit;
    }

    public String getValue() {
        return value;
    }
}
