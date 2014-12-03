package agent;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.util.Random;

import javax.imageio.ImageIO;

import slope.Slope;
import slope.SlopeCell;

public class Skier extends Agent {
	SlopeCell cell;
	BufferedImage image;
	
	public Skier() {
		Random rand = new Random();
		this.setDir(randomEnum(Direction.class));
		this.setSpeed(rand.nextInt(10));
		this.setSpeed(rand.nextInt(getSkill()+1));
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
	public Direction randomizeWithWages(double pLeft, double pUp, double pRight) {
        double totallyRandomValue = new Random().nextDouble();
        if (totallyRandomValue < pLeft) {
            return Direction.L;
        } else if (totallyRandomValue >= pLeft && totallyRandomValue < (pLeft + pUp)) {
            return Direction.R;
        } else {
            return Direction.FWD;
        }
	}
    }
    
    
	public void findCell()
	{
		int x = getLocation().getPosx();
		int y = getLocation().getPosy();
		int[][] mapa = Slope.getHeightmap();
		Random rand = new Random();
		double[] probability = new double[3];
		double sum = 0;
		for (int i = -1 ;  i < 2;i++)
		{
			probability[i+1] = rand.nextDouble()*mapa[x+i][y+1] + (rand.nextDouble()*0.2 - 0.1);
			sum += probability[i+1];
		}
		
		for (int i = 0; i < 3; i++) 
		{
			probability[i] = probability[i]/sum;
		}
		
		setDir(randomizeWithWages(probability[0], probability[1], probability[2]));
		
		
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