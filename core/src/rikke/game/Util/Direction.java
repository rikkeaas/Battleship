package rikke.game.Util;

public enum Direction {

    NORTH("N", 0, 1),
    EAST("E", 1, 0),
    SOUTH("S", 0, -1),
    WEST("W", -1, 0),
    ;

    private final String name;
    private final int dx;
    private final int dy;


    Direction(String name, int dx, int dy) {
        this.name = name;
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }



    public static Direction fromName(String name) {
        if (name.equals("N")) {
            return Direction.NORTH;
        } else if (name.equals("E")) {
            return Direction.EAST;
        } else if (name.equals("S")) {
            return Direction.SOUTH;
        } else if (name.equals("W")) {
            return Direction.WEST;
        } else {
            throw new IllegalArgumentException("Not a valid direction name");
        }
    }


}
