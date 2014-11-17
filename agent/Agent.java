package agent;

import java.util.ArrayList;

import slope.SlopeCell;

public class Agent {

	 public static enum Direction {L,FWD,R} // {N,NE,E,SE,S,SW,W,NW};
	 private Direction dir;
	 private int speed;
	 private int skill;
	 public double time = 0.0;
	 private ArrayList<SlopeCell> path;
	 private SlopeCell location;
	 
	 public Agent()
	 {
		 path = new ArrayList<>();
		 location = new SlopeCell();
	 }
	 
	 public boolean move(){
		 
		if (getDir() == Direction.R ) updateLocation(-1,1);
		if (getDir() == Direction.L  ) updateLocation(1,1);
		else updateLocation(0, 1);
		return true;
		};
	 public boolean turn(Direction dir){
		return false;}
	public SlopeCell getLocation() {
		return location;
	}
	public void updateLocation(int x, int y)
	{
		this.location.updateCell(x, y);
	}
	public void setLocation(int x, int y) {
		this.location = new SlopeCell(x,y);
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
	};
	 
	 
	 
	 

}
