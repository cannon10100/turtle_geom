package model;

/**
 * Created by cannon on 9/8/16.
 *
 * Model handling the updating of Turtles being displayed.
 */
public class TurtleModel {

    /**
     * Adapter defining an interface to the view.
     */
    private IViewAdapter _viewAdpt;

    /**
     * Start the model.
     */
    public void start() {

    }

    /**
     * Constructor to initialize the model with an adapter to the accompanying view.
     * @param adapter view adapter for the model to use.
     */
    public TurtleModel(IViewAdapter adapter) {
        this._viewAdpt = adapter;
    }
}
