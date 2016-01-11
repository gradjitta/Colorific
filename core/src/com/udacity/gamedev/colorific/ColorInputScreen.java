package com.udacity.gamedev.colorific;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.util.Random;

/**
 * Created by Blackstorm on 14/12/2015.
 */
public class ColorInputScreen extends InputAdapter implements Screen {

    public static final String TAG = ColorInputScreen.class.getName();
    ColorGame game;
    FillViewport displayViewport;
    ShapeRenderer renderer;
    Vector2 newCirclePosition;
    InputCircles inputCircles;
    Random random = new Random();
    // TODO update score
    // TODO hud display for score and timer
    // TODO Main screen to increase the circles or difficulty


    Array<InputCircle> circleList;
    Array<Color> colors;

    public ColorInputScreen(ColorGame game) {
        this.game = game;
    }


    @Override
    public void show() {
        Gdx.app.log("ColorInputScreen", "show called");
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        displayViewport = new FillViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        inputCircles = new InputCircles(displayViewport);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        // Gdx.app.log("ColorInputScreen", "render called");
        // inputCircles.update();

        displayViewport.apply(true);

        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(displayViewport.getCamera().combined);


        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // renderer.setColor(Constants.CIRCLE_COLOR);
        inputCircles.render(renderer);


        renderer.setColor(Constants.DISPLAY_COLOR);

        renderer.rect((Constants.WORLD_SIZE) / 6, (Constants.WORLD_SIZE) / 2, (4 * Constants.WORLD_SIZE) / 6, Constants.WORLD_SIZE / 3);
        // inputCircles.render(renderer);

        renderer.end();


    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("ColorInputScreen", "resize called");
        displayViewport.update(width, height, true);
        inputCircles.update();
        // float numberCircles = inputCircles.circleList.first().position.x;
        // System.out.println(numberCircles);

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
        Gdx.app.log("ColorInputScreen", "dispose called");
        renderer.dispose();

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("ColorInputScreen", "touchDown called");

        Vector2 worldTouch = displayViewport.unproject(new Vector2(screenX, screenY));

        for (int j = 0; j<3; j++) {
            Vector2 temp_vec = inputCircles.circleList.get(j).position;
            if (worldTouch.dst(temp_vec) < 40) {
                Gdx.app.log("Circle", Integer.toString(j));
                if (inputCircles.circleList.get(j).color.equals(Constants.DISPLAY_COLOR)) {
                    game.showColorScreen();
                }
            }

        }
        return true;
    }

}
