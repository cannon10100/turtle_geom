package model;

import javafx.util.Pair;
import strategy.IProgramStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by cannon on 9/8/16.
 *
 * Class representing a turtle for drawing.
 */
public class Turtle implements Observer {

    /**
     * The location of the Turtle in 2D.
     */
    private Pair<Double, Double> _loc;

    /**
     * The heading/velocity of the Turtle.
     */
    private Pair<Double, Double> _vel;

    /**
     * List of lines to be drawn, defined by their endpoints.
     */
    private ArrayList<Pair<Point, Point>> _lineList;

    /**
     * Method to get the norm of the current heading.
     * @return the norm of the current heading.
     */
    public double getVelNorm() {
        return Math.sqrt(Math.pow(_vel.getKey(), 2) + Math.pow(_vel.getValue(), 2));
    }


    /**
     * Moves the Turtle forward "moves" times in the heading direction, drawing a straight line.
     * @param moves the number of times to move.
     */
    public void forward(int moves) {
        Point oldPoint = new Point((int)Math.round(_loc.getKey()), (int)Math.round(_loc.getValue()));
        for (int i = 0; i < moves; i++) {
            _loc = new Pair<>(_loc.getKey() + _vel.getKey(), _loc.getValue() + _vel.getValue());
        }
        Point newPoint = new Point((int)Math.round(_loc.getKey()), (int)Math.round(_loc.getValue()));;

        _lineList.add(new Pair<>(oldPoint, newPoint));
    }

    /**
     * Move the Turtle forward without drawing a line.
     * @param moves the number of times to move.
     */
    public void move(int moves) {
        for (int i = 0; i < moves; i++) {
            _loc = new Pair<>(_loc.getKey() + _vel.getKey(), _loc.getValue() + _vel.getValue());
        }
    }

    /**
     * Rotate the Turtle's heading by "theta" radians counter-clockwise.
     * @param theta the number of radians to rotate the heading vector.
     */
    public void rotate(double theta) {
        double newVelX = _vel.getKey() * Math.cos(theta) - _vel.getValue() * Math.sin(theta);
        double newVelY = _vel.getKey() * Math.sin(theta) + _vel.getValue() * Math.cos(theta);

        _vel = new Pair<>(newVelX, newVelY);
    }

    /**
     * Rescales the velocity vector by "scale".
     * @param scale the scale to multiply the length of the current velocity vector by.
     */
    public void resize(double scale) {
        _vel = new Pair<>(_vel.getKey() * scale, _vel.getValue() * scale);
    }

    /**
     * Display the Turtle when notified by the model.
     * @param o observable within the model which passes a Graphics object.
     * @param arg the Graphics object to paint on.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Graphics) {
            Graphics g = (Graphics) arg;

            // Draw all lines
            for (Pair<Point, Point> line : _lineList) {
                g.drawLine(line.getKey().x, line.getKey().y,
                        line.getValue().x, line.getValue().y);
            }
        }
    }

    /**
     * Method causing the turtle to execute the given strategy.
     * @param strategy the strategy to execute.
     */
    public void doStrategy(IProgramStrategy strategy) {
        strategy.execute(this);
    }

    /**
     * Constructor which initializes an ArrayList for lines to be displayed.
     */
    public Turtle(Pair<Double, Double> loc, double norm) {
        this._lineList = new ArrayList<>();
        this._loc = loc;
        this._vel = new Pair<>(0.0, norm);
    }
}
