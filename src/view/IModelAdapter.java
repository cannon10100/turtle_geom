package view;

import java.awt.*;

/**
 * Adapter that allows a view to communicate with the model.
 */
public interface IModelAdapter {

    /**
     * Method to cause the model to paint itself.
     * @param g Graphics object to paint on.
     */
    public void paint(Graphics g);

    /**
     * Method to cause the model to make a new Turtle.
     */
    public void makeTurtle();
}
