package rikke.game.Board;

import rikke.game.Util.Tuple2Int;

public class AIBoard extends Board{

    boolean[][] playerHasBombed;

    public AIBoard() {
        super();
        playerHasBombed = new boolean[10][10];
    }

    public boolean registerHit(Tuple2Int coords) {
        boolean result = super.registerHit(coords);
        playerHasBombed[coords.y][coords.x] = true;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                if (playerHasBombed[y][x]) {
                    builder.append(getField(x, y).toString()).append(" ");
                } else {
                    builder.append("#").append(" ");
                }
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
