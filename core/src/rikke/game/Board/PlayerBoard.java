package rikke.game.Board;

import rikke.game.Util.Tuple2Int;

public class PlayerBoard extends Board {

    public PlayerBoard() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                builder.append(getField(x, y).toString()).append(" ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }




}
