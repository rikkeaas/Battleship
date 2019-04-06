package rikke.game.Screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import rikke.game.Battleship;
import rikke.game.Board.Board;
import rikke.game.Player.AbstractPlayer;
import rikke.game.Player.Boat;
import rikke.game.Util.Tuple2Int;

public class GameScreen implements Screen {

    Battleship game;
    public Texture img;
    private float x, y;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private OrthographicCamera camera;
    private TiledMap map;

    public GameScreen(Battleship game) {
        this.game = game;
    }


    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(w, h);
        camera.setToOrtho(false,23,11);
        camera.update();

        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("battleship_map.tmx");
        float unitScale = 1 / 32f; // Since I have 32x32 tiles
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);
        addBoats(game.mainGame.ai, 12);
        addBoats(game.mainGame.player, 0);
        TiledMapTileLayer fogLayer = (TiledMapTileLayer) map.getLayers().get("fog");
        fogLayer.setOpacity((float) 0.6);
    }


    private void addBoats(AbstractPlayer player, int offSet) {
        TiledMapTileLayer boatLayer = (TiledMapTileLayer) map.getLayers().get("boat");

        for (Boat boat : player.getBoats()) {
            int rotation = findRotation(boat);
            for (int i = 0; i < boat.getSize(); i++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                if (i == 0) {
                    cell.setTile(map.getTileSets().getTile(3));
                }
                else if (i == boat.getSize() - 1) {
                    cell.setTile(map.getTileSets().getTile(6));
                }
                else {
                    cell.setTile(map.getTileSets().getTile(4));
                }
                cell.setRotation(rotation);
                boatLayer.setCell(boat.getFields()[i].x + 1 + offSet, boat.getFields()[i].y, cell);
            }

        }

    }

    private int findRotation(Boat boat) {
        Tuple2Int[] coords = boat.getFields();
        int xDiff = coords[1].x - coords[0].x;
        int yDiff = coords[1].y - coords[0].y;

        if (yDiff > 0) return 1;
        if (yDiff < 0) return 3;
        if (xDiff > 0) return 0;
        if (xDiff < 0) return 2;
        else throw new IllegalArgumentException("Invalid boat");


    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        tiledMapRenderer.setView(camera);

        tiledMapRenderer.render();


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
