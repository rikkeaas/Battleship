package rikke.game.Player;

import rikke.game.Board.Board;
import rikke.game.Util.Tuple2Int;

public interface IPlayer {

    /**
     * Boat generation. Will work differently for human player and AI
     */
    public void generateBoats(int[] boatSizes);

    public String visualizeBoard();

    public Board getBoard();

    /**
     * @param coord coordinates of field to be shot
     * @return true if shot hits boat, false otherwise
     */
    public boolean handleShot(Tuple2Int coord);

}
