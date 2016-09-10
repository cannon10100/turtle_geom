package strategy;

import model.Turtle;

/**
 * Strategy causing a ball to draw an arbitrary regular polygon.
 */
public class SpiralStrategy implements IProgramStrategy {

    /**
     * The number of times for the spiral to repeat
     */
    private int _times;

    /**
     * The angle to rotate by.
     */
    private double _theta;

    /**
     * The scalar to resize the heading by.
     */
    private double _scalar;



    @Override
    public void execute(Turtle context) {
        for (int i = 0; i < _times; i++) {
            context.forward(1);
            context.rotate(_theta);
            context.resize(_scalar);
        }
    }

    public SpiralStrategy(int times, double theta, double scalar) {
        this._times = times;
        this._theta = theta;
        this._scalar = scalar;
    }
}
