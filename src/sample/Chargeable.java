package sample;

/**
 * This interface represents chargeable elements properties.
 *
 * <p>Every class implementing this interface must have {@link ChargeValue} property.
 * This interface allows to be charged positively or negatively.
 * Charge is represented by enum {@link ChargeValue}
 *
 * {@code ChargeValue} property should be set in the constructor.
 * This property cannot be changed after class initialization.
 */

public interface Chargeable {

    /**
     * Returns enum value being state of the logic element;
     * These values can be converted into int value {@link ChargeValue#getValue()}
     *
     * @return enum value being charge of chargeable element.
     */
    ChargeValue getCharge();
}
