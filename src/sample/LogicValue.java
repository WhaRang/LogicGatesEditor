package sample;

public enum LogicValue {
    LOGICAL_HIGH(1),
    LOGICAL_LOW(0),
    LOGICAL_ERROR(-1);

    private int value;

    LogicValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
