package slope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Slope {
	static public SlopeCell[][] slope;
	static private int[][] heightmap;
	private static int width;
	private static int height;
	private int maxHeight;
	private int minHeight;
	
	static public ArrayList<SlopeCell> route;
	public Slope(int width, int height, int maxHeight, int minHeight){
		this.setHeight(height);
		this.setWidth(width);
		
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		setHeightmap(new int[height][width]);
		slope = new SlopeCell[height][width];
		route = new ArrayList<>();
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
			{
				slope[i][j] = new SlopeCell(i,j);
			}
		fillRandomHighmap();
		Random rand = new Random();
	/*	for (int i = 0; i < width -1; i++)
			for ( int j = 0 ; j < height - 1; j++)
			{
				route.add(getSlopeTable()[i+ rand.nextInt(1)][j+rand.nextInt(1)]);
			}
		*/
	}
	public static SlopeCell[][] getSlopeTable(){
		return slope;
	}
	public void fillRandomHighmap(){
		Random r = new Random();
		int random;
		int max = maxHeight;
		for(int i = 0; i < getHeightmap().length; i++){
			for(int j = 0; j < getHeightmap()[i].length; j++){
			
					 random = r.nextInt(max - (max - 2) + 1) + (max - 2);
				getHeightmap()[i][j] = r.nextInt(100);  //random;
				
			}
			max--;
		}

	}
	public static void printHeightmap(){
		for(int[] t : getHeightmap()){
			System.out.println(Arrays.toString(t));
			//System.out.println();
		}
	}
	public static int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public static int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public static int[][] getHeightmap() {
		return heightmap;
	}
	public static void setHeightmap(int[][] heightmap) {
		Slope.heightmap = heightmap;
	}
}