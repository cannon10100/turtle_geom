package util;

import java.util.Observable;

/**
 * Simple class to make Observables work more intuitively.
 */
public class Dispatcher extends Observable {

    /**
     * Notifies all observers with the input object.
     * @param param the object to send to observers.
     */
    public void notifyAll(Object param) {
        setChanged();
        notifyObservers(param);
    }
}
