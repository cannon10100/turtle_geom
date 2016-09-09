package strategy;

import model.Turtle;

/**
 * Class representing a basic program for a turtle.
 */
public class BasicStrategy implements IProgramStrategy {

    /**
     * Draw a square.
     * @param context the turtle to use to execute the program.
     */
    @Override
    public void execute(Turtle context) {
        for (int i = 0; i < 4; i++) {
            context.forward(5);
            context.rotate(Math.PI / 2.0);
        }
    }
}
