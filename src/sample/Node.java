package sample;

/**
 * Represents simple electric node in circuits.
 *
 * <p>Any class implementing {@code Node} should have properties necessary
 * for every interface which {@code Node} implements.
 */

public interface Node extends Connectable, LogicalElement, Chargeable {
}
