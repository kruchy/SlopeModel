package agent;

import java.util.Random;

import slope.Slope;
import slope.SlopeCell;

public class Skier extends Agent {
	SlopeCell cell;

	public Skier() {
		Random rand = new Random();
		this.setDir(randomEnum(Direction.class));
		this.setSkill(rand.nextInt(10));
		this.setSpeed(rand.nextInt(getSkill()));
		this.setLocation(rand.nextInt(Slope.getWidth()),0);
		this.getPath().add(this.getLocation());
		// cell = new SlopeCell(5,5);
	}

	
	public double findAngle(SlopeCell a)
	{
		int x = getLocation().getPosx();
		int y = getLocation().getPosy();
		double angle = Math.atan2(y - a.getPosy(),x - a.getPosy() );
		return angle;
	}
	

	
	public void findCell()
	{
		int x = getLocation().getPosx();
		int y = getLocation().getPosy();
		int[][] mapa = Slope.getHeightmap();
		double[] probability  = new double[3];
		for (int i = -1 ; i < 2 ; i++)
			probability[i+1] =  getSkill()*getSpeed()* mapa[x+i][y+1];
		
		
		if(mapa[x-1][y+1] < mapa[x][y]) setDir(Direction.R);
		if(mapa[x][y+1] < mapa[x][y]) setDir(Direction.FWD);
		else setDir(Direction.L);
	}
	public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
		Random rand = new Random();
		int x = rand.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}

	public SlopeCell createSkiier(SlopeCell[][] slope) {
		Random r = new Random();
		int random = r.nextInt(slope.length);
		cell.setCell(0, random);
		return slope[0][random];
	}

}
