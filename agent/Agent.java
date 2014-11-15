package agent;

import slope.SlopeCell;

public class Agent {

	 public static int[] Direction = {1,2,3,4,5,6,7,8,9};
	 private int speed;
	 private int skill;
	 private SlopeCell[][] path;
	 private SlopeCell location;
	 
	 public boolean move(int dir){
		return false;};
	 public boolean turn(int dir){
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
