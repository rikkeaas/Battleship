package rikke.game.Player;

import rikke.game.Board.Board;
import rikke.game.Board.Field;
import rikke.game.Board.PlayerBoard;
import rikke.game.Util.Direction;
import rikke.game.Util.Tuple2Int;

import java.util.Random;
import java.util.Scanner;

public abstract class AbstractPlayer implements IPlayer {

    protected Board board;
    protected Boat[] boats;
    protected int[] boatSizes;


    public AbstractPlayer(int nbOfBoats, int[] boatSizes) {
        boats = new Boat[nbOfBoats];
        this.boatSizes = boatSizes;
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


    protected boolean registerValidBoat(Tuple2Int startCoord, Direction dir, int idx) {
        Boat boat = new Boat(boatSizes[idx], startCoord, dir);
        System.out.println();
        if (isValid(boat)) {
            boats[idx] = boat;
            board.registerBoat(boat.getFields());
            return true;
        }
        return false;
    }


    protected boolean isValid(Boat boat) {
        Tuple2Int[] coords = boat.getFields();
        int l = boat.size - 1;
        if (coords[l].x >= 0 && coords[l].x < board.getSize() && coords[l].y >= 0 && coords[l].y < board.getSize()) {
            for (Tuple2Int coord : coords) {
                if (board.getField(coord) == Field.BOAT) { // Not valid if there is already a boat here
                    return false;
                }
                System.out.println(coord);
            }
            return true;
        }
        return false;
    }

    @Override
    public String visualizeBoard() {
        return board.toString();
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public boolean handleShot(Tuple2Int coord) {
        if (board.registerHit(coord)) {
            sunkenBoat();
            return true;
        } return false;
    }

    private void sunkenBoat() {
        // todo fix!
//        for (Boat boat : boats) {
//            for (Tuple2Int coord : boat.getFields()) {
//                if (board.getField(coord) == Field.BOAT) {
//                    System.out.println("Hit, but no boats have sunk (yet)");
//                    break;
//                }
//            }
//            //System.out.println("You have sunken boat of size " + boat.size);
//            //return;
//        }

    }


    public Boat[] getBoats() {
        return boats;
    }

}
