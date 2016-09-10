package strategy;

import model.Turtle;

/**
 * Strategy which executes an inner strategy and rotates it.
 */
public class SpinStrategy implements IProgramStrategy {

    /**
     * The angle to rotate by.
     */
    private double _theta;

    /**
     * The number of times to draw the inner strategy.
     */
    private int _times;

    /**
     * The inner turtle strategy to execute multiple times.
     */
    private IProgramStrategy _strategy;

    @Override
    public void execute(Turtle context) {
        for (int i = 0; i < _times; i++) {
            _strategy.execute(context);
            context.rotate(_theta);
        }
    }

    public SpinStrategy(double theta, int times, IProgramStrategy strategy) {
        this._theta = theta;
        this._times = times;
        this._strategy = strategy;
    }
}
