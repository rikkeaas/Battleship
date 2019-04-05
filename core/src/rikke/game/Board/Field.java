package rikke.game.Board;

public enum Field {
    BOAT("B"),
    WATER("-"),
    HIT("X"),
    MISS("O");

    private String representation;

    Field(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}


