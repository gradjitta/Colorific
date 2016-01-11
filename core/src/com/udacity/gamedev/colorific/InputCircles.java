package com.udacity.gamedev.colorific;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Color;
import java.util.Random;

/**
 * Created by Blackstorm on 14/12/2015.
 */
public class InputCircles {

    public static final String TAG = InputCircles.class.getName();
    Random random = new Random();

    Array<Color> colors;
    Array<InputCircle> circleList;
    Viewport viewport;
    Vector2 newCirclePosition;

    public InputCircles(Viewport viewport) {
        // Gdx.app.log("InputCircles", "constructor called");
        this.viewport = viewport;
        init();
    }

    public void init() {
        // Gdx.app.log("InputCircles", "Init called");
        circleList = new Array<InputCircle>(false, 3);
        colors = new Array<Color>(false, 3);
        int tempIndex = random.nextInt(3) + 1;
        int i = 0;
        for (int j = 0; j<3; j++) {
            i++;
            float tempval1 = random.nextFloat();
            float tempval2 = random.nextFloat();
            Color tempcol = new Color(0.2f + tempval1, 0.2f+tempval2, 1, 1);
            if(tempIndex == i) {
                colors.add(Color.BLUE);
            }
            colors.add(tempcol);
        }
    }

    public void update() {

        circleList = new Array<InputCircle>(false, 3);
        for (int j = 0; j<3; j++) {
            Vector2 newCirclePosition = new Vector2( (Constants.WORLD_SIZE)/4 + j*100,
                    ((Constants.WORLD_SIZE)/2 - 50)  );
            Color newColor = colors.get(j);
            InputCircle newCircle = new InputCircle(newCirclePosition, newColor);
            circleList.add(newCircle);
        }

    }

    public void render(ShapeRenderer renderer) {
        int i = 0;
        for (InputCircle circle : circleList) {
            renderer.setColor(colors.get(i));
            circle.render(renderer);
            i++;
        }
    }
}
