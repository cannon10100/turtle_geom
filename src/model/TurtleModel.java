package model;

import javafx.util.Pair;
import strategy.*;
import util.Dispatcher;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cannon on 9/8/16.
 *
 * Model handling the updating of Turtles being displayed.
 */
public class TurtleModel {

    /**
     * Dispatcher controlling when objects in the model paint themselves.
     */
    private Dispatcher _dispatcher;

    /**
     * Adapter defining an interface to the view.
     */
    private IViewAdapter _viewAdpt;

    /**
     * The time increment for the Timer.
     */
    private int _timeDelta = 50;

    /**
     * Timer that controls the updating of the view.
     */
    private Timer _timer = new Timer(_timeDelta, (e) -> _viewAdpt.update());

    /**
     * Start the model.
     */
    public void start() {
        _timer.start();
    }

    /**
     * Constructor to initialize the model with an adapter to the accompanying view.
     * @param adapter view adapter for the model to use.
     */
    public TurtleModel(IViewAdapter adapter) {
        this._viewAdpt = adapter;
        this._dispatcher = new Dispatcher();
    }

    /**
     * Method to paint the model by delegating to registered observers.
     * @param g Graphics object to paint on.
     */
    public void paint(Graphics g) {
        _dispatcher.notifyAll(g);
    }

    /**
     * Method to load a turtle with a default ProgramStrategy.
     */
    public void makeTurtle() {
        Turtle turtle = new Turtle(new Pair<Double,Double>(300.0, 200.0), 200.0);
        _dispatcher.addObserver(turtle);
        turtle.doStrategy(new PolyGasketStrategy(3, 5));
    }
}
