package slope;

import java.util.Arrays;
import java.util.Random;

public class Slope {
	static private SlopeCell[][] slope;
	private int[][] heightmap;
	private int width, height, maxHeight;
	private int minHeight;
	public Slope(int width, int height, int maxHeight, int minHeight){
		this.height = height;
		this.width = width;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		heightmap = new int[height][width];
		slope = new SlopeCell[height][width];
	}
	public static SlopeCell[][] getSlopeTable(){
		return slope;
	}
	public void fillRandomHighmap(){
		Random r = new Random();
		int random;
		int max = maxHeight;
		System.out.println(max);
		for(int i = 0; i < heightmap.length; i++){
			for(int j = 0; j < heightmap[i].length; j++){
			
					 random = r.nextInt(max - (max - 2) + 1) + (max - 2);
				heightmap[i][j] = random;
				
			}
			max--;
		}

	}
	public void printHeightmap(){
		for(int[] t : heightmap){
			System.out.println(Arrays.toString(t));
			//System.out.println();
		}
	}
}
