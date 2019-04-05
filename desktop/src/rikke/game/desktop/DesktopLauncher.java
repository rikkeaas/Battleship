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
		new LwjglApplication(new Battleship(), config);

		int nbOfBoats = 5;
		int[] sizes = new int[]{5,4,3,3,2};

		Player player = new Player(nbOfBoats, sizes);
		AI ai = new AI(nbOfBoats, sizes);

		System.out.println(player.visualizeBoard());
		System.out.println(ai.visualizeBoard());
	}
}
