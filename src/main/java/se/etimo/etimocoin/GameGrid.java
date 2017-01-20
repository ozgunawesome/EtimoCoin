package se.etimo.etimocoin;

import java.util.*;

/**
 * Created by ozgunayaz on 1/19/17.
 */
public class GameGrid {

    private static GameGrid SINGLETON = null;

    private static final int GRID_SIZE = 50;

    static GameGrid getGrid() {
        if (SINGLETON == null) {
            SINGLETON = new GameGrid();
        }
        return SINGLETON;
    }

    private final Random random = new Random();

    private Set<Coin> coins = new HashSet<>();

    private Set<Player> players = new HashSet<>();

    private Map<String, Player> playerMap = new HashMap<>();

    private GameGrid() {
        Player blue = new Player(CharacterColor.blue);
        Player red = new Player(CharacterColor.red);
        //Player green = new Player(CharacterColor.green);
        players.add(blue);
        players.add(red);
        //players.add(green);
        playerMap.put("metallica", blue);
        playerMap.put("blacksabbath", red);
        //playerMap.put("vanhalen", green);
        int newCoins = 30;
        while (newCoins-- > 0) {
            addOneNewCoin();
        }
    }

    private void addOneNewCoin() {
        while (true) {

            Coin newCoin = new Coin(random.nextInt(GRID_SIZE), random.nextInt(GRID_SIZE));

            for (Coin existingCoin : coins) {
                if (existingCoin.isOnSameCoords(newCoin)) {
                    newCoin = null;
                    break;
                }
            }

            if (newCoin != null) {
                for (Player existingPlayer : players) {
                    if (existingPlayer.isOnSameCoords(newCoin) || existingPlayer.isOnHomeCoords(newCoin)) {
                        newCoin = null;
                        break;
                    }
                }
            }

            if (newCoin != null) {
                coins.add(newCoin);
                break;
            }
        }
    }

    private void checkAndGivePlayerHisCoin(Player player) {
        Coin coinToTake = null;
        for (Coin coin : coins) {
            if (coin.isOnSameCoords(player)) {
                coinToTake = coin;
                break;
            }
        }

        if (coinToTake != null) {
            coins.remove(coinToTake);
            player.giveCoin();
            if (coins.size() < 20) {
                int i = random.nextInt(30) + 10;
                while (i-- > 0) {
                    addOneNewCoin();
                }
            }
        }
    }

    boolean commandMove(MoveCommandWrapper wrapper) {
        if (playerMap.containsKey(wrapper.getPlayerKey())) {
            return move(playerMap.get(wrapper.getPlayerKey()), wrapper.getDirection());
        }
        return false;
    }

    private boolean move(Player player, Direction direction) {
        int newX = player.x, newY = player.y;
        switch (direction) {
            case up:
                if (player.y == 0) return false;
                newY--;
                break;
            case down:
                if (player.y == GRID_SIZE - 1) return false;
                newY++;
                break;
            case left:
                if (player.x == 0) return false;
                newX--;
                break;
            case right:
                if (player.x == GRID_SIZE - 1) return false;
                newX++;
                break;
        }

        for (Player otherPlayer : players) {
            if (player != otherPlayer && otherPlayer.x == newX && otherPlayer.y == newY) {
                return false;
            }
        }

        player.x = newX;
        player.y = newY;

        player.checkArrivedHome();

        if (player.canGetCoin()) {
            checkAndGivePlayerHisCoin(player);
        }

        return true;
    }

    public int getCoinCount() {
        return coins.size();
    }

    public Set<Coin> getCoins() {
        return coins;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void reset() {
        SINGLETON = new GameGrid();
    }
}
