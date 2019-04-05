package rikke.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import rikke.game.Battleship;
import rikke.game.Board.AIBoard;
import rikke.game.Board.Board;
import rikke.game.Board.PlayerBoard;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Battleship";
		new LwjglApplication(new Battleship(), config);

		Board pBoard = new PlayerBoard();
		Board aBoard = new AIBoard();
		System.out.println(aBoard.toString());
		System.out.println(pBoard.toString());

		((PlayerBoard) pBoard).registerHit(5,5);
		((AIBoard) aBoard).registerHit(5,5);

		System.out.println(aBoard.toString());
		System.out.println(pBoard.toString());
	}
}
