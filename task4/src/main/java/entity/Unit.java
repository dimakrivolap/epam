package entity;

/**
 * Unit. (unit weight)
 * <p>
 * 26 August 2018
 *
 * @author Dmitry Krivolap
 * @version 1.0
 * @see Value
 */
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
        if ("g".equals(s)) {
            return Unit.GRAM;
        } else
            return Unit.CARAT;
    }
}
