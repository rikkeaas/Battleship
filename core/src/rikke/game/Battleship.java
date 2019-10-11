package rikke.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import rikke.game.Screen.GameScreen;
import rikke.game.Screen.MenuScreen;
import rikke.game.Util.myClass;

public class Battleship extends Game {
	public SpriteBatch batch;
	public MainGame mainGame;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mainGame = new MainGame();
		setScreen(new MenuScreen(this));
		myClass myClass = new myClass(1,2);
	}

	public void resetGame() {
		mainGame = new MainGame();
	}

	@Override
	public void render () {
		super.render();
	}

}
