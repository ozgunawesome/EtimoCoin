package se.etimo.etimocoin;

/**
 * Created by ozgunayaz on 1/19/17.
 */
public abstract class GridObject {

    int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    boolean isOnSameCoords(GridObject object) {
        return object.x == this.x && object.y == this.y;
    }
}
