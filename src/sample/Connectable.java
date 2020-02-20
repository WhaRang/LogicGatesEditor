package sample;

import java.util.Collection;

/**
 * This interface represents observable/observer element in simple observer pattern.
 *
 * <p>Any class implementing this interface declare itself connectable
 * and can be observed by {@link ModificationObserver}.
 * After any changes in observed properties {@link ModificationObserver#sendNotification()}
 * method should be called.
 *
 * <p>Every class implementing this interface must have {@code boolean} property.
 * This property allows to be observer too.
 *
 * <p>{@code Collection<ModificationObserver>} property allows to store observers in collection.
 * Notifications should be send to every observer.
 */

public interface Connectable {

    /**
     * Adds observer to the collection of observers for this object.
     * It's better to initialize collection of modification observer as set.
     * This allows to control that it is not the same as some observer already in the set
     *
     * @param mo observer to be added to observers collection
     */
    void connectTo(ModificationObserver mo);

    /**
     * Removes observer from the collection of observers for this object.
     *
     * @param mo observer to be removed from observers collection
     */
    void disconnectFrom(ModificationObserver mo);

    /**
     * Returns the capability of the object to be an observer.
     *
     * @return boolean value which is {@code isConnectable} property
     */
    boolean isConnectable();

    /**
     * Sets the capability of the object to be an observer.
     *
     * @param isConnectable boolean value which is {@code isConnectable} property
     */
    void setConnectable(boolean isConnectable);

    /**
     * Returns the collection of observers for this object;
     * This method should be implemented safely and
     * return a copy of collection, but not the collection itself.
     *
     * @return collection of observers for this object
     */

    Collection<ModificationObserver> getConnectedElements();
}
