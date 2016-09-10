package strategy;

import model.Turtle;

/**
 * Strategy which executes an inner strategy and scales it.
 */
public class ScaleStrategy implements IProgramStrategy {

    /**
     * The double to scale the shape by.
     */
    private double _scalar;

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
            context.resize(_scalar);
        }
    }

    public ScaleStrategy(double scalar, int times, IProgramStrategy strategy) {
        this._scalar = scalar;
        this._times = times;
        this._strategy = strategy;
    }
}
