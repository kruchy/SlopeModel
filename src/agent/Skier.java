package agent;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;

import slope.Slope;
import slope.SlopeCell;

public class Skier extends Agent {
	public static int numberOfSkiers = 20;
	private int ID;
	SlopeCell cell;
	BufferedImage image;

	public Skier() {
		Random rand = new Random();
		this.setDir(randomEnum(Direction.class));
		this.setSkill(rand.nextInt(10) + 1);
		this.setSpeed(rand.nextInt(getSkill()) + 1);
		this.setLocation(rand.nextInt(Slope.getWidth()-5), 0);
		this.getPath().add(this.getLocation());
		this.setState(State.ON_TRACK);
	}



	public double findAngle(SlopeCell a) {
		int x = getLocation().getPosx();
		int y = getLocation().getPosy();
		double angle = Math.atan2(y - a.getPosy(), x - a.getPosy());
		return angle;
	}

	public Direction randomizeWithWages(double[] probability) {
		Direction[] dirs = { Direction.R, Direction.FWD, Direction.L };
		double sum = 0;
		double totallyRandomValue = new Random().nextDouble();
		for (int i = 0; i < probability.length; i++) {
			if (totallyRandomValue < probability[i] + sum) {
				double x = (double) i / (double) dirs.length;
				if(i % 2 == 0) return return2(dirs[(int) Math.floor(x)],
						dirs[(int) Math.ceil(x)]);
				else return dirs[(int) Math.round(x)];
			}
			sum += probability[i];
		}
		return Direction.FWD;
	}

	public Direction return2(Direction first, Direction sec) {
		Random rand = new Random();
		if (rand.nextDouble() < 0.5)
			return first;
		else
			return sec;
	}

	public void findCell() {
		int x = getLocation().getPosx();
		int y = getLocation().getPosy();
		int[][] mapa = Slope.getHeightmap();
		Random rand = new Random();
		double[] probability = new double[5];
		double sum;
		if (y + 2 < Slope.getHeight()) {
			sum = 0;
			for (int i = -2; i < 3; i++) {
				if (x + i > 0 && x + i < Slope.getWidth())
					probability[i + 2] = rand.nextDouble() * mapa[x + i][y + 2]
							+ (rand.nextDouble() * 0.2 - 0.1);
				else
					probability[i + 2] = 0;
				sum += probability[i + 2];
			}
		}

		else {
			sum = 0;
			for (int i = -1; i < 2; i++) {
				probability[i + 2] = rand.nextDouble() * mapa[x + i][y + 1]
						+ (rand.nextDouble() * 0.2 - 0.1);
				sum += probability[i + 1];
			}
			probability[0] = 0;
			probability[4] = 0;

		}

		for (int i = 0; i < probability.length; i++) {
			probability[i] = probability[i] / sum;
		}
		setDir(randomizeWithWages(probability));
	}

	public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
		Random rand = new Random();
		int x = rand.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}

	public SlopeCell createSkier(SlopeCell[][] slope) {
		Random r = new Random();
		int random = r.nextInt(slope.length);
		cell.setCell(0, random);
		return slope[0][random];
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}