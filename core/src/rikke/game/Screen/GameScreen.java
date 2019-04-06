package rikke.game.Screen;


import com.badlogic.gdx.Gdx;
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
import rikke.game.Player.AI;
import rikke.game.Player.AbstractPlayer;
import rikke.game.Player.Boat;
import rikke.game.Util.Tuple2Int;

import java.util.Random;

public class GameScreen implements Screen {

    Battleship game;
    public Texture img;
    private float x, y;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private OrthographicCamera camera;
    private TiledMap map;

    private final int AI_OFFSET = 13;
    private final int PLAYER_OFFSET = 1;

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
        addBoats(game.mainGame.ai, AI_OFFSET);
        addBoats(game.mainGame.player, PLAYER_OFFSET);
//        TiledMapTileLayer fogLayer = (TiledMapTileLayer) map.getLayers().get("fog");
//        fogLayer.setOpacity((float) 0.6);
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
                boatLayer.setCell(boat.getFields()[i].x + offSet, boat.getFields()[i].y, cell);
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

        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();

        if (Gdx.input.justTouched()) {
            int xScaling = w / 23;
            int yScaling = h / 11;

            int x = -AI_OFFSET + Gdx.input.getX() / xScaling;
            int y = (h - Gdx.input.getY()) / yScaling;


            if (x >= 0 && y < 10) {
                System.out.println(x + ", " + y);
               if (game.mainGame.ai.handleShot(new Tuple2Int(x, y))) {

                   Random r = new Random();
                   int rx, ry;
                   do {
                       rx = r.nextInt(10);
                       ry = r.nextInt(10);
                   } while (!game.mainGame.player.handleShot(new Tuple2Int(rx, ry)));

                   updateBoard(rx, ry, game.mainGame.player.getBoard(), PLAYER_OFFSET, game.mainGame.player);
                   updateBoard(x, y, game.mainGame.ai.getBoard(), AI_OFFSET, game.mainGame.ai);
               }
            }
        }

        camera.update();
        tiledMapRenderer.setView(camera);

        tiledMapRenderer.render();


        if (winCondition()) {
            game.setScreen(new WinScreen(game));
        }

    }


    private boolean winCondition() {
        return game.mainGame.ai.getBoats().isEmpty();
    }


    private void updateBoard(int x, int y, Board board, int xOffset, AbstractPlayer abPlayer) {
        TiledMapTileLayer hitMissLayer = (TiledMapTileLayer) map.getLayers().get("hit_or_miss");
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

        switch (board.getField(x, y)) {
            case HIT:
                cell.setTile(map.getTileSets().getTile(7));
                break;
            case MISS:
                cell.setTile(map.getTileSets().getTile(8));
                break;
        }
        hitMissLayer.setCell(x + xOffset, y, cell);

        TiledMapTileLayer fogLayer = (TiledMapTileLayer) map.getLayers().get("fog");
        TiledMapTileLayer.Cell fogcell = new TiledMapTileLayer.Cell();
        fogcell.setTile(map.getTileSets().getTile(0));
        fogLayer.setCell(x + xOffset, y, fogcell);

        Boat sunkenBoat = abPlayer.sunkenBoat();
        if (sunkenBoat != null) {
            sinkBoat(sunkenBoat, abPlayer);
        }
    }


    private void sinkBoat(Boat sunkenBoat, AbstractPlayer abPlayer) {
        TiledMapTileLayer fogLayer = (TiledMapTileLayer) map.getLayers().get("fog");
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        Tuple2Int[] coords = sunkenBoat.getFields();

        for (Tuple2Int coord : coords) {
            cell.setTile(map.getTileSets().getTile(13));
            cell.setRotation(findRotation(sunkenBoat));
            if (abPlayer instanceof AI) {
                fogLayer.setCell(coord.x + AI_OFFSET, coord.y, cell);
            } else {
                fogLayer.setCell(coord.x + PLAYER_OFFSET, coord.y, cell);
            }
        }

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
