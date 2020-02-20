package sample;

/**
 * This interface represents logical element properties.
 *
 * <p>Every class implementing this interface must have {@link LogicValue} property.
 * This interface allows the implementing class to have logic states.
 * These states are represented by enum {@link LogicValue}.
 */

public interface LogicalElement {

    /**
     * Returns enum value being state of the logic element;
     * These values can be converted into int value {@link LogicValue#getValue()}
     *
     * @return enum value being state of the logic element.
     */
    LogicValue getLogicValue();

    /**
     * Sets the state of logic element to not null {@code logicValue}.
     *
     * @param logicValue enum value which not necessarily become a new state of LogicalElement.
     */
    void setLogicValue(LogicValue logicValue);
}
