package rikke.game.Board;

public enum Field {
    BOAT("#"),
    WATER("-");

    private String representation;

    Field(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}

