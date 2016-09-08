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

    private TurtleModel _model;

    private TurtleGUI _view;

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
