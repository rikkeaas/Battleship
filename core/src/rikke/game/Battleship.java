package rikke.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import rikke.game.Screen.GameScreen;

public class Battleship extends Game {
	public SpriteBatch batch;
	public MainGame mainGame;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mainGame = new MainGame();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

}
