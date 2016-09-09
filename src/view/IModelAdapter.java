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
    void paint(Graphics g);
}
