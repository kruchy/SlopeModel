package agent;

import java.util.Random;

import slope.Slope;
import slope.SlopeCell;

public class Skier extends Agent {
	SlopeCell cell;

	public Skier() {
		Random rand = new Random();
		this.setDir(randomEnum(Direction.class));
		this.setSpeed(rand.nextInt(10));
		this.setSkill(5);
		this.setLocation(rand.nextInt(Slope.getWidth()),0);
		this.getPath().add(this.getLocation());
		// cell = new SlopeCell(5,5);
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
