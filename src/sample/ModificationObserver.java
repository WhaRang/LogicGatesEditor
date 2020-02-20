package sample;

/**
 * This interface represents observer element in simple observer pattern.
 *
 * <p> A class can implement the {@code ModificationObserver} interface
 * when it wants to be informed of changes in observable objects.
 * This interface allows to get notifications that something has changed
 * in observable objects, but not about changes itself.
 */

public interface ModificationObserver {

    /**
     * This method is called whenever the observed object or
     * property is changed.
     */
    void sendNotification();
}
