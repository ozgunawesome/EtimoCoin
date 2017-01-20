package se.etimo.etimocoin;

/**
 * Created by ozgunayaz on 1/19/17.
 * license: https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

public class MoveCommandWrapper {

    private Direction direction;
    private String playerKey;

    public MoveCommandWrapper() {
    }

    public MoveCommandWrapper(Direction direction, String playerKey) {
        this.direction = direction;
        this.playerKey = playerKey;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(String playerKey) {
        this.playerKey = playerKey;
    }
}
