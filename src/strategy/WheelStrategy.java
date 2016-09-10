package strategy;

import model.Turtle;

/**
 * Strategy causing a ball to draw a wheel.
 */
public class WheelStrategy implements IProgramStrategy {

    /**
     * The number of sides for the wheel to be drawn.
     */
    private int _sides;

    /**
     * The radius of the wheel to be drawn.
     */
    private int _radius;

    @Override
    public void execute(Turtle context) {
        double outer_theta = (2.0 * Math.PI) / _sides;
        double inner_theta = ((_sides - 2) * Math.PI) / (2 * _sides);
        double sideLength = 2.0 * _radius * Math.cos(inner_theta);

        for (int i = 0; i < _sides; i++) {
            context.resize(_radius / context.getVelNorm());
            context.forward(1);
            context.rotate((Math.PI / 2.0) - (Math.PI / _sides) + outer_theta);
            context.resize(sideLength / context.getVelNorm());
            context.forward(1);
            context.rotate(outer_theta + inner_theta);
            context.resize(_radius / context.getVelNorm());
            context.forward(1);
            context.rotate(Math.PI);
        }
    }

    public WheelStrategy(int sides, int radius) {
        this._sides = sides;
        this._radius = radius;
    }
}
