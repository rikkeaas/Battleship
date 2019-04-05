package rikke.game.Board;

import rikke.game.Util.Tuple2Int;

public class PlayerBoard extends Board {

    public PlayerBoard() {
        super();
    }


    public void registerHit(Tuple2Int coords) {
        if (getField(coords) == Field.BOAT) {
            setField(coords, Field.HIT);
        } else {
            setField(coords, Field.MISS);
        }
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
