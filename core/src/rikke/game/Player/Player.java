package rikke.game.Player;

import rikke.game.Board.Board;
import rikke.game.Board.PlayerBoard;

import java.util.Scanner;

public class Player implements IPlayer {

    private PlayerBoard board;


    public Player() {
        board = new PlayerBoard();
        generateBoats();
    }


    @Override
    public void generateBoats() {
        Scanner in = new Scanner(System.in);
        int boatCount = 0;
        do {
            System.out.println("Write in start coordinates and direction in format <x> <y> <N/S/E/W>");
            int x = Integer.parseInt(in.next());
            int y = Integer.parseInt(in.next());
            String dir = in.next();

            boatCount++;
            
        } while (boatCount < 5);

    }

    @Override
    public String visualizeBoard() {
        return null;
    }

    @Override
    public Board getBoard() {
        return null;
    }

    @Override
    public boolean handleShot(int x, int y) {
        return false;
    }
}
