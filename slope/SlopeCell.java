package slope;

import agent.Skiier;

public class SlopeCell {
	private int posx, posy;
	Skiier skiier;
	public SlopeCell(){};
	/*
	public SlopeCell(int x, int y){
		posx = x;
		posy = y;
	}*/
	public void setCell(int x, int y){
		posx = x; 
		posy = y;
	}
}
