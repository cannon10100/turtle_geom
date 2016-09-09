package strategy;

import model.Turtle;

/**
 * Strategy causing a ball to draw an arbitrary regular polygon.
 */
public class RegularShapeStrategy implements IProgramStrategy {

    /**
     * The number of sides for the regular polygon to be drawn.
     */
    private int _sides;

    @Override
    public void execute(Turtle context) {
        for (int i = 0; i < _sides; i++) {
            context.forward(1);
            context.rotate((2.0 * Math.PI) / _sides);
        }
    }

    public RegularShapeStrategy(int sides) {
        this._sides = sides;
    }
}
