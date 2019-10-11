package rikke.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import rikke.game.Battleship;

import java.util.ArrayList;

public class MenuScreen implements Screen {


    Battleship game;
    private OrthographicCamera camera;

    private Texture plain = new Texture("plain_menu.png");
    private Texture start = new Texture("start.png");
    private Texture quit = new Texture("quit.png");



    public MenuScreen(Battleship game) {
        this.game = game;
    }


    @Override
    public void show() {
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(w, h);
        camera.position.set(w / 2, h / 2, 0);
        camera.update();

    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.getX() >= 640 && Gdx.input.getX() <= 715 && Gdx.input.getY() >= 400 && Gdx.input.getY() <= 425) {
            setImage(start);
            if (Gdx.input.justTouched()) {
                game.resetGame();
                game.setScreen(new GameScreen(game));
            }
        }

        else if (Gdx.input.getX() >= 640 && Gdx.input.getX() <= 715 && Gdx.input.getY() >= 470 && Gdx.input.getY() <= 490) {
            setImage(quit);
            if (Gdx.input.justTouched()) {
                System.exit(0);
            }
        } else {
            setImage(plain);
        }

    }

    private void setImage(Texture img) {
        game.batch.begin();
        game.batch.draw(img, camera.position.x - (img.getWidth() / 2), camera.position.y - (img.getHeight() / 2));
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
