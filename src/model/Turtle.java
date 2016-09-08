package model;

import javafx.util.Pair;

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
    private Point _loc;

    /**
     * The heading/velocity of the Turtle.
     */
    private Pair<Double, Double> _vel;

    /**
     * List of lines to be drawn, defined by their endpoints.
     */
    private ArrayList<Pair<Point, Point>> _lineList;


    /**
     * Moves the Turtle forward "moves" times in the heading direction, drawing a straight line.
     * @param moves the number of times to move.
     */
    public void forward(int moves) {
        Point oldPoint = new Point(_loc);
        _loc.setLocation(Math.round(_loc.getX() + _vel.getKey()), Math.round(_loc.getY() + _vel.getValue()));
        Point newPoint = new Point(_loc);

        _lineList.add(new Pair<>(oldPoint, newPoint));
    }

    /**
     * Move the Turtle forward without drawing a line.
     * @param moves the number of times to move.
     */
    public void move(int moves) {
        _loc.setLocation(Math.round(_loc.getX() + _vel.getKey()), Math.round(_loc.getY() + _vel.getValue()));
    }

    /**
     * Rotate the Turtle's heading by "theta" radians counter-clockwise.
     * @param theta the number of radians to rotate the heading vector.
     */
    public void rotate(double theta) {
        double newVelX = _vel.getKey() * Math.cos(theta) - _vel.getValue() * Math.sin(theta);
        double newVelY = _vel.getKey() * Math.sin(theta) + _vel.getValue() * Math.cos(theta);

        _vel = new Pair<Double, Double>(newVelX, newVelY);
    }

    /**
     * Rescales the velocity vector by "scale".
     * @param scale the scale to multiply the length of the current velocity vector by.
     */
    public void resize(double scale) {
        _vel = new Pair<Double, Double>(_vel.getKey() * scale, _vel.getValue() * scale);
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
     * Constructor which initializes an ArrayList for lines to be displayed.
     */
    public Turtle() {
        this._lineList = new ArrayList<>();
    }

}
