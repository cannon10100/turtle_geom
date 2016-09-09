package controller;

import model.IViewAdapter;
import model.TurtleModel;
import view.IModelAdapter;
import view.TurtleGUI;

import java.awt.*;

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
    private void start() {
        _model.start();
        _view.start();
    }

    public TurtleController() {
        _model = new TurtleModel(new IViewAdapter() {

            @Override
            public void update() {
                _view.update();
            }
        });

        _view = new TurtleGUI(new IModelAdapter() {

            @Override
            public void paint(Graphics g) {
                _model.paint(g);
            }

            @Override
            public void makeTurtle() {
                _model.makeTurtle();
            }
        });
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TurtleController controller = new TurtleController();
                    controller.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
