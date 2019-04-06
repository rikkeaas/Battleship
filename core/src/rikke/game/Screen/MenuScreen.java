package rikke.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import rikke.game.Battleship;

public class MenuScreen implements Screen {


    Battleship game;
    public Texture img;
    private float x, y;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private OrthographicCamera camera;

    public MenuScreen(Battleship game) {
        this.game = game;
    }


    @Override
    public void show() {
//        float w = Gdx.graphics.getWidth();
//        float h = Gdx.graphics.getHeight();
//
//        camera = new OrthographicCamera(w, h);
//        camera.setToOrtho(false,11,11);
//        camera.update();

    }

    @Override
    public void render(float v) {

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
