package rikke.game.Board;

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
                System.out.print(getField(x, y) + " ");
            }
            builder.append("\n");
            System.out.println();
        }

        return builder.toString();
    }




}
