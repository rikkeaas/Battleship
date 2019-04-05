package rikke.game.Player;

import rikke.game.Board.Board;
import rikke.game.Board.Field;
import rikke.game.Board.PlayerBoard;
import rikke.game.Util.Direction;
import rikke.game.Util.Tuple2Int;

import java.util.Scanner;

public abstract class AbstractPlayer implements IPlayer {

    protected Board board;
    protected Boat[] boats;
    protected int[] boatSizes;


    public AbstractPlayer(int nbOfBoats, int[] boatSizes) {
        boats = new Boat[nbOfBoats];
        this.boatSizes = boatSizes;
        generateBoats(boatSizes);
    }

    protected boolean registerValidBoat(Tuple2Int startCoord, Direction dir, int idx) {
        Boat boat = new Boat(boatSizes[idx], startCoord, dir);
        if (isValid(boat)) {
            boats[idx] = boat;
            return true;
        }
        return false;
    }


    protected boolean isValid(Boat boat) {
        Tuple2Int[] coords = boat.getFields();
        if (coords[0].x >= 0 && coords[0].x < board.getSize() && coords[0].y >= 0 && coords[0].y < board.getSize()) {
            for (Tuple2Int coord : coords) {
                if (board.getField(coord) == Field.BOAT) { // Not valid if there is already a boat here
                    return false;
                }
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
        for (Boat boat : boats) {
            for (Tuple2Int coord : boat.getFields()) {
                if (board.getField(coord) == Field.BOAT) {
                    System.out.println("You have sunken boat of size " + boat.size);
                    return;
                }
            }
        }
        System.out.println("Hit, but no boats have sunk (yet)");
    }
}
