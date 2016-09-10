package strategy;

import model.Turtle;

/**
 * Strategy which recursively draws the given polygon.
 */
public class PolyGasketStrategy implements IProgramStrategy {

    /**
     * The current level of recursion.
     */
    private int _level;

    /**
     * The number of sides of the polygon to recursively draw.
     */
    private int _sides;

    @Override
    public void execute(Turtle context) {
        if (_level == 0) {
            IProgramStrategy strat = new RegularShapeStrategy(_sides);
            strat.execute(context);
        } else {
            for (int i = 0; i < _sides; i++) {
                context.resize(0.5);
                IProgramStrategy strat = new PolyGasketStrategy(_level - 1, _sides);
                strat.execute(context);
                context.resize(2.0);
                context.move(1);
                context.rotate(Math.PI * 2.0 / _sides);
            }
        }
    }

    public PolyGasketStrategy(int level, int sides) {
        this._level = level;
        this._sides = sides;
    }
}
