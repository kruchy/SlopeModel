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
		setPosx(x); 
		setPosy(y);
	}
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	private int getPosy() {
		return posy;
	}
	private void setPosy(int posy) {
		this.posy = posy;
	}
}
