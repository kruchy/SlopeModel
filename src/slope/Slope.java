package slope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class represents ski slope
 * 
 * @author Pawel
 * 
 */
public class Slope {
	/**
	 * One cell on ski slope
	 */
	static public SlopeCell[][] slope;
	/**
	 * Map filling values of ski slope's height
	 */
	static private int[][] heightmap;
	private static int width;
	private static int height;
	private int maxHeight;
	static public ArrayList<SlopeCell> route;
	public static int number = 0;

	public Slope(int width, int height, int maxHeight, int minHeight) {
		this.setHeight(height);
		this.setWidth(width);
		number++;
		System.out.println(number);
		this.maxHeight = maxHeight;
		setHeightmap(new int[width][height]);
		slope = new SlopeCell[width][height];
		route = new ArrayList<>();
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				slope[i][j] = new SlopeCell(i, j);
			}
		fillRandomHighmap();
		Random rand = new Random();
	}

	/**
	 * Getting slope table
	 * 
	 * @return
	 */
	public static SlopeCell[][] getSlopeTable() {
		return slope;
	}

	/**
	 * Filling heightmap on random values
	 */
	public void fillRandomHighmap() {
		Random r = new Random();
		int random;
		int max = maxHeight;
		for (int i = 0; i < getHeightmap().length; i++) {
			for (int j = 0; j < getHeightmap()[i].length; j++) {

				random = r.nextInt(max - (max - 2) + 1) + (max - 2);
				getHeightmap()[i][j] = r.nextInt(100); // random;

			}
			max--;
		}

	}

	/**
	 * Printing heightmap on console
	 */
	public static void printHeightmap() {
		for (int[] t : getHeightmap()) {
			System.out.println(Arrays.toString(t));
			// System.out.println();
		}
	}

	public static int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		Slope.height = height;
	}

	public static int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		Slope.width = width;
	}

	public static int[][] getHeightmap() {
		return heightmap;
	}

	public static void setHeightmap(int[][] heightmap) {
		Slope.heightmap = heightmap;
	}
}