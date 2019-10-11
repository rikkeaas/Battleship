package rikke.game.Screen;

import com.badlogic.gdx.graphics.Texture;
import rikke.game.Battleship;

public class WinScreen extends EndScreen {


    public WinScreen(Battleship game) {
        this.game = game;
    }


    public void show() {
        super.show();

        img = new Texture("winner.jpg");
        tw = img.getWidth();
        th = img.getHeight();
    }



}
