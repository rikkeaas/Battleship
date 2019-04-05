package rikke.game.Board;

public class PlayerBoard extends Board {

    public PlayerBoard() {
        super();
    }


    public void registerHit(int x, int y) {
        if (getField(x, y) == Field.BOAT) {
            setField(x, y, Field.HIT);
        } else {
            setField(x, y, Field.MISS);
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
