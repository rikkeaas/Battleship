package rikke.game.Screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import rikke.game.Battleship;

public class LooseScreen extends EndScreen {

    Sound loose = Gdx.audio.newSound(new FileHandle("loose.wav"));

    public LooseScreen(Battleship game) {
        this.game = game;
    }


    public void show() {
        super.show();
        loose.play();
        img = new Texture("looser.jpg");
        tw = img.getWidth();
        th = img.getHeight();
    }


}
