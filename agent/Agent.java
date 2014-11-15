package agent;

import slope.SlopeCell;

public class Agent {

	 public static enum Direction {N,NE,E,SE,S,SW,W,NW};
	 private int speed;
	 private int skill;
	 private SlopeCell[][] path;
	 private SlopeCell location;
	 
	 public boolean move(Direction dir){
		return false;};
	 public boolean turn(Direction dir){
		return false;}
	public SlopeCell getLocation() {
		return location;
	}
	public void setLocation(SlopeCell location) {
		this.location = location;
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
	public SlopeCell[][] getPath() {
		return path;
	}
	public void setPath(SlopeCell[][] path) {
		this.path = path;
	};
	 
	 
	 
	 

}
