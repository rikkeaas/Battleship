package rikke.game;

import rikke.game.Board.Board;
import rikke.game.Player.AI;
import rikke.game.Player.AbstractPlayer;
import rikke.game.Player.Player;

public class MainGame {

    private final int NB_OF_BOATS = 5;
    private final int[] BOAT_SIZES = new int[]{5, 4, 3, 3, 2};

    public AbstractPlayer player, ai;


    public MainGame() {
        player = new Player(NB_OF_BOATS, BOAT_SIZES);
        ai = new AI(NB_OF_BOATS, BOAT_SIZES);

    }

    public Board[] getBoards(){
        return new Board[]{player.getBoard(), ai.getBoard()};
    }


}
