package rikke.game.Util;

public class Tuple2Int {

    public int x;
    public int y;

    public Tuple2Int(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }



    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tuple2Int)) {
            return false;
        }
        Tuple2Int vector2Int = (Tuple2Int) object;
        return x == vector2Int.x && y == vector2Int.y;
    }
}
