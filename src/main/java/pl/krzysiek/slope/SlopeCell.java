package pl.krzysiek.slope;


import pl.krzysiek.agent.Skier;

/**
 * Class represents one cell on ski slope
 *
 * @author Pawel
 */
public class SlopeCell {
    private int posx, posy;
    Skier skiier;

    public SlopeCell() {
    }

    ;

    public SlopeCell(int x, int y) {
        posx = x;
        posy = y;
    }

    public void setCell(int x, int y) {
        setPosx(x);
        setPosy(y);
    }

    public void setCell(double x, double y) {
        setPosx((int) x);
        setPosy((int) y);
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public void incPosx() {
        this.posx++;
    }

    public void incPosy() {
        this.posy++;
    }

    public void decPosx() {
        this.posx--;

    }

    public void decPosy() {
        this.posy--;
    }

    /**
     * Updating cell on new values
     *
     * @param x
     * @param y
     */
    public void updateCell(int x, int y) {
        this.posx += x;
        this.posy += y;
    }
}