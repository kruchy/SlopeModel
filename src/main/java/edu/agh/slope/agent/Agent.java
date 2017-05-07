package edu.agh.slope.agent;

import edu.agh.slope.slope.SlopeCell;

import java.util.ArrayList;


/**
 * Parent class of all agents existing on the slope.
 *
 * @author Kruchy
 */
public class Agent {

    public enum Direction {
        L, FWD, R
    }

    public enum State {
        ON_LIFT, ON_TRACK, SAFE_ZONE
    }

    private Direction dir;
    private State state;
    private int speed;
    private int skill;
    public double time = 0.0;
    private ArrayList<SlopeCell> path;
    private SlopeCell location;

    public Agent() {
        path = new ArrayList<>();
        location = new SlopeCell();
        setState(State.ON_TRACK);
    }


    public boolean move() {

        if (getDir() == Direction.R)
            updateLocation(-1, 1);
        if (getDir() == Direction.L)
            updateLocation(1, 1);
        else
            updateLocation(0, 1);
        return true;
    }

    public SlopeCell getLocation() {
        return location;
    }

    public void updateLocation(int x, int y) {
        this.location.updateCell(x, y);
    }

    public void setLocation(int x, int y) {
        this.location = new SlopeCell(x, y);
    }

    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkill() {
        return skill;
    }


    public void setSkill(int skill) {
        this.skill = skill;
    }

    public ArrayList<SlopeCell> getPath() {
        return path;
    }

    public void setPath(ArrayList<SlopeCell> path) {
        this.path = path;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    ;
}