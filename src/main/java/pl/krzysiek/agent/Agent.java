package pl.krzysiek.agent;

import pl.krzysiek.slope.SlopeCell;

import
java.util.ArrayList;


/**
 * Parent class of all agents existing on the slope.
 * @author Kruchy
 *
 */
public class Agent {

	public static enum Direction {
		L, FWD, R
	} // {N,NE,E,SE,S,SW,W,NW};

	public static enum State {
		ON_LIFT, ON_TRACK, SAFE_ZONE
	};

	private Direction dir;
	private State state;
	private int speed;
	private int skill;
	public double time = 0.0;
	private ArrayList<SlopeCell> path;
	private SlopeCell location;

	/**
	 * Standard constructor.
	 */
	public Agent() {
		path = new ArrayList<>();
		location = new SlopeCell();
		setState(State.ON_TRACK);
	}

	
	/**
	 * Moves agent in chosen direction.
	 * @return currently not used.
	 */
	public boolean move() {

		if (getDir() == Direction.R)
			updateLocation(-1, 1);
		if (getDir() == Direction.L)
			updateLocation(1, 1);
		else
			updateLocation(0, 1);
		return true;
	};

/*	public boolean turn(Direction dir) {
		return false;
	}*/

	/**
	 * Getter for location.
	 * @return
	 */
	public SlopeCell getLocation() {
		return location;
	}

	/**
	 * Updates coordinates.
	 * @param x
	 * @param y
	 */
	public void updateLocation(int x, int y) {
		this.location.updateCell(x, y);
	}

	/**
	 * Setter for location
	 * @param x
	 * @param y
	 */
	public void setLocation(int x, int y) {
		this.location = new SlopeCell(x, y);
	}

	/**
	 * Getter for speed.
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Setter for speed.
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Getter for skill.
	 * @return
	 */
	public int getSkill() {
		return skill;
	}

	/**
	 * Setter for skill.
	 * @param skill
	 */
	public void setSkill(int skill) {
		this.skill = skill;
	}

	/**
	 * Returns traveled path. 
	 * @return
	 */
	public ArrayList<SlopeCell> getPath() {
		return path;
	}

	public void setPath(ArrayList<SlopeCell> path) {
		this.path = path;
	}

	/**
	 * Getter for  direction.
	 * @return
	 */
	public Direction getDir() {
		return dir;
	}

	/**
	 * Setter for direction.
	 * @param dir
	 */
	public void setDir(Direction dir) {
		this.dir = dir;
	}

	/**
	 * Getter for state.
	 * @return
	 */
	public State getState() {
		return state;
	}

	/**
	 * Setter of state.
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	};
}