package rikke.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import rikke.game.Battleship;
import rikke.game.Board.AIBoard;
import rikke.game.Board.Board;
import rikke.game.Board.PlayerBoard;
import rikke.game.Player.AI;
import rikke.game.Player.Player;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Battleship";
		config.width = 1000;
		//config.fullscreen = true;
		new LwjglApplication(new Battleship(), config);
	}
}
