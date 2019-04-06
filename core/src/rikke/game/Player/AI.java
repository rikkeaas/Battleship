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



}
