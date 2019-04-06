package rikke.game.Board;

import rikke.game.Util.Tuple2Int;

import java.util.Random;

public abstract class Board {

    private final int STANDARD_BOARD_SIZE = 10;
    private Field[][] board;

    public Board() {
        board = new Field[STANDARD_BOARD_SIZE][STANDARD_BOARD_SIZE];
        initialize();
    }

    private void initialize() {
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                setField(x, y, Field.WATER);
            }
        }
    }


    public Field getField(Tuple2Int coords) {
        return board[coords.y][coords.x];
    }
    public Field getField(int x, int y) {
        return board[y][x];
    }

    public void setField(Tuple2Int coords, Field field) {
        board[coords.y][coords.x] = field;
    }
    public void setField(int x, int y, Field field) {
        board[y][x] = field;
    }

    public int getSize() {
        return STANDARD_BOARD_SIZE;
    }

    public void registerBoat(Tuple2Int[] coords) {
        for (Tuple2Int coord : coords) {
            setField(coord, Field.BOAT);
        }
    }

    public boolean registerHit(Tuple2Int coords) {
        if (getField(coords) == Field.BOAT) {
            System.out.println("Bord has boat");
            setField(coords, Field.HIT);
            return true;
        } else if (getField(coords) == Field.WATER){
            setField(coords, Field.MISS);
            return true;
        }
        else {
            System.out.println("Already shot here");
            return false;
        }
    }

}
