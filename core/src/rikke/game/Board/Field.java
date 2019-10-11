package rikke.game.Board;

public enum Field {
    BOAT(false, "B"),
    WATER(false, "-"),
    HIT(true, "X"),
    MISS(true, "O"),

    SUNK(true, "S");

    private boolean known;
    private String representation;

    Field(boolean known, String representation) {
        this.known = known;
        this.representation = representation;
    }

    public boolean isKnown() {
        return this.known;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}


