package strategy;

import model.Turtle;

/**
 * Interface for an abstract program for a turtle to execute.
 */
public interface IProgramStrategy {

    /**
     * Execute the current program strategy by calling turtle methods.
     * @param context the turtle to use to execute the program.
     */
    public void execute(Turtle context);
}
