package rikke.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import rikke.game.Battleship;

public abstract class EndScreen implements Screen {

    Battleship game;
    OrthographicCamera camera;
    Texture img;
    int tw, th;
    float w, h;


    @Override
    public void show() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(w, h);
        camera.position.set(w / 2, h / 2, 0); // Change the height --> h
        camera.update();

    }

    @Override
    public void render(float v) {

        if (Gdx.input.justTouched()) {
            game.setScreen(new MenuScreen(game));
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(img, camera.position.x - (tw / 2), camera.position.y - (th / 2));
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
