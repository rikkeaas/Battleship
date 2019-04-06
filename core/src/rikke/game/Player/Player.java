package rikke.game.Player;

import rikke.game.Board.PlayerBoard;
import rikke.game.Util.Direction;
import rikke.game.Util.Tuple2Int;

import java.util.Scanner;

public class Player extends AbstractPlayer {


    public Player(int nbOfBoats, int[] boatSizes) {
        super(nbOfBoats, boatSizes);
        board = new PlayerBoard();
        generateBoats(boatSizes);
    }

//    @Override
//    public void generateBoats(int[] boatSizes) {
//        Scanner in = new Scanner(System.in);
//        int boatCount = 0;
//        do {
//            System.out.println("Write in start coordinates and direction in format <x> <y> <N/S/E/W>");
//            int x = Integer.parseInt(in.next());
//            int y = Integer.parseInt(in.next());
//            Direction dir = Direction.fromName(in.next());
//
//            if (registerValidBoat(new Tuple2Int(x,y), dir, boatCount)) {
//                boatCount++;
//            }
//
//        } while (boatCount < boatSizes.length);
//
//    }
}
