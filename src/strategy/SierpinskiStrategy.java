package strategy;

import model.Turtle;

/**
 * Strategy which draws the Sierpinksi Triangle.
 */
public class SierpinskiStrategy implements IProgramStrategy {

    /**
     * The current level of the recursive tree.
     */
    private int _level;

    @Override
    public void execute(Turtle context) {
        if (_level == 0) {
            IProgramStrategy strat = new RegularShapeStrategy(3);
            strat.execute(context);
        } else {
            for (int i = 0; i < 3; i++) {
                context.resize(0.5);
                IProgramStrategy strat = new SierpinskiStrategy(_level - 1);
                strat.execute(context);
                context.resize(2.0);
                context.move(1);
                context.rotate(2.0 * Math.PI / 3.0);
            }
        }
    }

    public SierpinskiStrategy(int level) {
        this._level = level;
    }
}
