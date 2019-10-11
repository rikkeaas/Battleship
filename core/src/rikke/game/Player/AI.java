package rikke.game.Player;

import rikke.game.Board.AIBoard;
import rikke.game.Board.Board;
import rikke.game.Board.Field;
import rikke.game.Util.Direction;
import rikke.game.Util.Tuple2Int;

import java.util.Random;

public class AI extends AbstractPlayer {

    public AI(int nbOfBoats, int[] boatSizes) {
        super(nbOfBoats, boatSizes);
        board = new AIBoard();
        generateBoats(boatSizes);
    }

    public Tuple2Int cleverShot(Board playerBoard) {

        Tuple2Int next = null;

        for (int y = 0; y < playerBoard.getSize(); y++) {
            for (int x = 0; x < playerBoard.getSize(); x++) {
                if (playerBoard.getField(x, y) == Field.HIT) {
                    next = findNext(x, y, playerBoard);
                    if (next != null) {
                        return next;
                    }
                }
            }
        }
        return findSmartRandom(playerBoard); //smartChoise(playerBoard);
    }


    private Tuple2Int findNext(int x, int y, Board playerBoard) {

        Tuple2Int nextEast = findEnd(x, y, Direction.EAST.getDx(), Direction.EAST.getDy(), playerBoard);
        Tuple2Int nextWest = findEnd(x, y, Direction.WEST.getDx(), Direction.WEST.getDy(), playerBoard);
        Tuple2Int nextNorth = findEnd(x, y, Direction.NORTH.getDx(), Direction.NORTH.getDy(), playerBoard);
        Tuple2Int nextSouth = findEnd(x, y, Direction.SOUTH.getDx(), Direction.SOUTH.getDy(), playerBoard);



        if (distBetween(nextEast, nextWest) > distBetween(nextNorth, nextSouth)) {
            if (!playerBoard.getField(nextEast).isKnown()) {
                return nextEast;
            } else if (!playerBoard.getField(nextWest).isKnown()) {
                return nextWest;
            }
        } else {
            if (!playerBoard.getField(nextNorth).isKnown()) {
                return nextNorth;
            } else if (!playerBoard.getField(nextSouth).isKnown()) {
                return nextSouth;
            }
        }

        return null;

    }

    private int distBetween(Tuple2Int c1, Tuple2Int c2) {
        return Math.max(Math.abs(c1.x - c2.x), Math.abs(c1.y - c2.y));
    }

    private Tuple2Int findEnd(int x, int y, int dx, int dy, Board playerBoard) {
        int newX = x + dx;
        int newY = y + dy;

        while (newX < 10 && newX >= 0 && newY < 10 && newY >= 0) {
            if (playerBoard.getField(newX, newY) != Field.HIT) {
                if (playerBoard.getField(newX, newY) == Field.MISS || playerBoard.getField(newX, newY) == Field.SUNK)
                    return new Tuple2Int(newX - dx, newY - dy);
                return new Tuple2Int(newX, newY);
            }
            newX += dx;
            newY += dy;
        }
        return new Tuple2Int(newX - dx, newY - dy);
    }


    private Tuple2Int findSmartRandom(Board playerBoard) {
        Random r = new Random();
        Tuple2Int temp;
        int counter = 0;

        temp = tryToFindNNeighbours(playerBoard, 4); // Try to find place with 4 open neighbours
        if (playerBoard.registerHit(temp)) {
            return temp;
        }
        temp = tryToFindNNeighbours(playerBoard, 3); // Try to find place with 3 open neighbours
        if (playerBoard.registerHit(temp)) {
            return temp;
        }
        temp = tryToFindNNeighbours(playerBoard, 2); // Try to find place with 2 open neighbours
        if (playerBoard.registerHit(temp)) {
            return temp;
        }

        else { // Find a random place to hit
            do {
                temp = new Tuple2Int(r.nextInt(10), r.nextInt(10));
            } while (!playerBoard.registerHit(temp));
            return temp;
        }
    }


    private Tuple2Int tryToFindNNeighbours(Board playerBoard, int n) {
        Random r = new Random();
        Tuple2Int temp;
        int counter = 0;

        do {
            temp = new Tuple2Int(r.nextInt(10), r.nextInt(10));
            counter++;
        } while ((playerBoard.getField(temp).isKnown() || countUnknownNeighbours(temp.x, temp.y, playerBoard) < n) && counter < 200);

        return temp;
    }


    private int countUnknownNeighbours(int x, int y, Board playerBoard) {
        int count = 0;
        if (x - 1 >= 0) {
            if (!playerBoard.getField(x - 1, y).isKnown()) count++;
        }
        if (x + 1 < 10) {
            if (!playerBoard.getField(x + 1, y).isKnown()) count++;
        }
        if (y - 1 >= 0) {
            if (!playerBoard.getField(x , y - 1).isKnown()) count++;
        }
        if (y + 1 < 10) {
            if (!playerBoard.getField(x, y + 1).isKnown()) count++;
        }
        return count;
    }


}
