package rikke.game.Player;

import rikke.game.Board.AIBoard;
import rikke.game.Util.Direction;
import rikke.game.Util.Tuple2Int;

import java.util.Random;
import java.util.Scanner;

public class AI extends AbstractPlayer {

    public AI(int nbOfBoats, int[] boatSizes) {
        super(nbOfBoats, boatSizes);
        board = new AIBoard();
        generateBoats(boatSizes);
    }

    @Override
    public void generateBoats(int[] boatSizes) {
        String[] dirs = new String[]{"N", "S", "E", "W"};
        Random r = new Random();
        int boatCount = 0;
        do {
            int x = r.nextInt(board.getSize());
            int y = r.nextInt(board.getSize());
            int d = r.nextInt(4);
            Direction dir = Direction.fromName(dirs[d]);

            if (registerValidBoat(new Tuple2Int(x,y), dir, boatCount)) {
                boatCount++;
            }

        } while (boatCount < boatSizes.length);

    }

}
