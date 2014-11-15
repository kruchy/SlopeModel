package agent;

import java.util.Random;

import slope.SlopeCell;

public class Skiier extends Agent {
	SlopeCell cell;
	public Skiier(){
		
	}
	public SlopeCell createSkiier(SlopeCell[][] slope){
		Random r = new Random();
		int random = r.nextInt(slope.length);
		cell.setCell(0,random);
		return slope[0][random];
	}
	

}
