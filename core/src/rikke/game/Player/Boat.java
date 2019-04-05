package rikke.game.Player;

import rikke.game.Board.Field;
import rikke.game.Util.Direction;
import rikke.game.Util.Tuple2Int;

import java.util.Iterator;

public class Boat {

    private Tuple2Int[] boatFields; // List of coordinate pairs
    int size;

    public Boat(int size, Tuple2Int start, Direction dir) {
        this.size = size;
        boatFields = new Tuple2Int[size];
        generate(start, dir);
    }

    private void generate(Tuple2Int startCoords, Direction dir) {
        int dx = dir.getDx();
        int dy = dir.getDy();
        for (int i = 0; i < size; i++) {
            boatFields[i] = new Tuple2Int(startCoords.x + i*dx, startCoords.y + i*dy);
        }
    }


    public Tuple2Int[] getFields() {
        return boatFields;
    }


    public int getSize() {
        return size;
    }
}
