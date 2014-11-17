package agent;

import java.util.Random;

import slope.SlopeCell;

public class Skier extends Agent {
	SlopeCell cell;
	public Skier(){
		this.setSpeed(10);
		this.setSkill(5);	
		this.setLocation(5,5);
		//cell = new SlopeCell(5,5);
	}
	
	public SlopeCell createSkiier(SlopeCell[][] slope){
		Random r = new Random();
		int random = r.nextInt(slope.length);
		cell.setCell(0,random);
		return slope[0][random];
	}
	

}
