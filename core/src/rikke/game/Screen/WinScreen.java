package rikke.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import rikke.game.Battleship;

public class WinScreen implements Screen {

    Battleship game;
    public Texture img;
    private OrthographicCamera camera;

    public WinScreen(Battleship game) {
        this.game = game;
    }


    @Override
    public void show() {

        img = new Texture("winner.jpg");

        float imgH = img.getHeight();
        float imgW = img.getWidth();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        //camera = new OrthographicCamera(imgW, imgH);
        //camera.setToOrtho(false,11,11);
        //camera.update();


    }

    @Override
    public void render(float v) {

        if (Gdx.input.justTouched()) {
            System.exit(0);
        }

        game.batch.begin();
        game.batch.draw(img, 0, 0);
        game.batch.end();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
