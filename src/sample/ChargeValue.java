package sample;

public enum ChargeValue {
    POSITIVE_CHARGE(1),
    NEGATIVE_CHARGE(-1);

    private int value;

    ChargeValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
