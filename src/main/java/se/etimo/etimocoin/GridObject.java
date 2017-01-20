package se.etimo.etimocoin;

/**
 * Created by ozgunayaz on 1/19/17.
 * license: https://creativecommons.org/licenses/by-nc-sa/4.0/
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
