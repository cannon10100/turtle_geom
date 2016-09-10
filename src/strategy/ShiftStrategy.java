package strategy;

import model.Turtle;

/**
 * Strategy which executes an inner strategy and shifts its location.
 */
public class ShiftStrategy implements IProgramStrategy {

    /**
     * The distance to move the shape by.
     */
    private int _distance;

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
            context.move(_distance);
        }
    }

    public ShiftStrategy(int distance, int times, IProgramStrategy strategy) {
        this._distance = distance;
        this._times = times;
        this._strategy = strategy;
    }
}
