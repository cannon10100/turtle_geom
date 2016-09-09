package model;

/**
 * Adapter that allows the model to communicate with the view.
 */
public interface IViewAdapter {

    /**
     * Method to cause the view to update itself.
     */
    public void update();
}
