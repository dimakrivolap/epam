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

    public static Unit getUnit(String s) {
        if("g".equals(s)){
            return Unit.GRAM;
        }
        else
            return Unit.CARAT;
    }
}
