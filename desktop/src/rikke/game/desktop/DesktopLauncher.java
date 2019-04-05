package rikke.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import rikke.game.Battleship;
import rikke.game.Board.Board;
import rikke.game.Board.PlayerBoard;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Battleship(), config);

		Board board = new PlayerBoard();
		board.toString();
	}
}
