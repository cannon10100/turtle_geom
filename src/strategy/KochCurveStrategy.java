package strategy;

import model.Turtle;

/**
 * Strategy which recursively draws the Koch curve.
 */
public class KochCurveStrategy implements IProgramStrategy {

    /**
     * The current level of recursion.
     */
    private int _level;

    @Override
    public void execute(Turtle context) {
        if (_level == 0) {
            context.forward(1);
        } else {
            IProgramStrategy strat = new KochCurveStrategy(_level - 1);

            context.resize(1 / 3.0);
            strat.execute(context);
            context.rotate(Math.PI / 3.0);
            strat.execute(context);
            context.rotate(-Math.PI * 2.0 / 3.0);
            strat.execute(context);
            context.rotate(Math.PI / 3.0);
            strat.execute(context);
            context.resize(3.0);
        }
    }

    public KochCurveStrategy(int level) {
        this._level = level;
    }
}
