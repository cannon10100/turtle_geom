package strategy;

import model.Turtle;

/**
 * Strategy causing a ball to draw an arbitrary regular polygon.
 */
public class StarStrategy implements IProgramStrategy {

    /**
     * The number of sides for the regular polygon to be drawn.
     */
    private int _sides;

    @Override
    public void execute(Turtle context) {
        for (int i = 0; i < _sides; i++) {
            context.forward(1);
            context.rotate((4.0 * Math.PI) / _sides);
        }
    }

    public StarStrategy(int sides) {
        this._sides = sides;
    }
}
