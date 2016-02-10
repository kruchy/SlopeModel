package pl.krzysiek.agent;

import pl.krzysiek.slope.Slope;
import pl.krzysiek.slope.SlopeCell;

import java.awt.image.BufferedImage;
import java.util.Random;


/**
 * Skier representation of Agent class. Moves on the slope depending on skills
 * and speed.
 *
 * @author Kruchy
 */
public class Skier extends Agent {
    private int ID;
    SlopeCell cell;
    public static int numberOfSkiers = 20;
    BufferedImage image;

    /**
     * Default constructor, creates Skier at random location at the start of the
     * slope.
     */
    public Skier() {
        Random rand = new Random();
        this.setDir(randomEnum(Direction.class));
        this.setSkill(rand.nextInt(10) + 1);
        this.setSpeed(rand.nextInt(getSkill()) + 1);
        this.setLocation(rand.nextInt(Slope.getWidth() - 5), 0);
        this.getPath().add(this.getLocation());
        this.setState(State.ON_TRACK);
    }

    /**
     * Currently not used function.
     *
     * @param a
     * @return
     */
    public double findAngle(SlopeCell a) {
        int x = getLocation().getPosx();
        int y = getLocation().getPosy();
        double angle = Math.atan2(y - a.getPosy(), x - a.getPosy());
        return angle;
    }

    /**
     * Choses one direction with given probability.
     *
     * @param probability
     * @return
     */
    public Direction randomizeWithWages(double[] probability) {
        Direction[] dirs = {Direction.R, Direction.FWD, Direction.L};
        double sum = 0;
        double totallyRandomValue = new Random().nextDouble();
        for (int i = 0; i < probability.length; i++) {
            if (totallyRandomValue < probability[i] + sum) {
                double x = (double) i / (double) dirs.length;
                if (i % 2 == 0)
                    return return2(dirs[(int) Math.floor(x)],
                            dirs[(int) Math.ceil(x)]);
                else
                    return dirs[(int) Math.round(x)];
            }
            sum += probability[i];
        }
        return Direction.FWD;
    }

    /**
     * Random from 2 directions
     */
    public Direction return2(Direction first, Direction sec) {
        Random rand = new Random();
        if (rand.nextDouble() < 0.5)
            return first;
        else
            return sec;
    }

    /**
     * Finds the best cell to move to with small randomization
     */
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
        } else {
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

    /**
     * Helper function to return random from enum
     */
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        Random rand = new Random();
        int x = rand.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    /**
     * Random creation of skiers
     *
     * @param slope
     * @return
     */
    public SlopeCell createSkier(SlopeCell[][] slope) {
        Random r = new Random();
        int random = r.nextInt(slope.length);
        cell.setCell(0, random);
        return slope[0][random];
    }

    /**
     * Getter for ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter for ID
     *
     * @param iD
     */
    public void setID(int iD) {
        ID = iD;
    }

}