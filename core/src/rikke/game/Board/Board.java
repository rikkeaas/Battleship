package rikke.game.Board;

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



    public Field getField(int x, int y) {
        return board[y][x];
    }

    public void setField(int x, int y, Field field) {
        board[y][x] = field;
    }

    public int getSize() {
        return STANDARD_BOARD_SIZE;
    }

}
