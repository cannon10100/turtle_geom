package controller;

import model.TurtleModel;
import view.TurtleGUI;

/**
 * Created by cannon on 9/8/16.
 *
 * Controller for the Turtle application, responsible for creating the GUI and model and
 * connecting the two.
 */
public class TurtleController {

    /**
     * The model representing the state of this application.
     */
    private TurtleModel _model;

    /**
     * The Swing view for the application.
     */
    private TurtleGUI _view;

    /**
     * Method to start the application.
     */
    public void start() {
        _model.start();
        _view.start();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

    }
}
