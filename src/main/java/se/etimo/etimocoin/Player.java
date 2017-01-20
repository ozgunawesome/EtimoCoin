package se.etimo.etimocoin;

/**
 * Created by ozgunayaz on 1/19/17.
 */
public class Player extends GridObject {

    private static final int GRID_SIZE = 50;

    final int homeX, homeY;
    int coins = 0, score = 0;

    final CharacterColor color;

    Player(CharacterColor c) {
        switch (c) {

            case red:
                x = y = 0;
                break;
            case blue:
                x = y = (GRID_SIZE - 1);
                break;
            case green:
                x = GRID_SIZE - 1;
                y = 0;
        }
        homeX = x;
        homeY = y;
        color = c;
    }

    boolean canGetCoin() {
        return coins < 5;
    }

    void giveCoin() {
        coins++;
    }

    boolean isOnHomeCoords(GridObject object) {
        return this.homeX == object.x && this.homeY == object.y;
    }

    void checkArrivedHome() {
        if (x == homeX && y == homeY) {
            score += coins;
            coins = 0;
        }
    }

    public int getCoins() {
        return coins;
    }

    public int getScore() {
        return score;
    }

    public CharacterColor getColor() {
        return color;
    }
}
