package rikke.game.Player;

import rikke.game.Board.Board;

public interface IPlayer {

    /**
     * Boat generation. Will work differently for human player and AI
     */
    public void generateBoats();

    public String visualizeBoard();

    public Board getBoard();

    /**
     * @param x x-coordinate
     * @param y y-coordinate
     * @return true if shot hits boat, false otherwise
     */
    public boolean handleShot(int x, int y);

}
