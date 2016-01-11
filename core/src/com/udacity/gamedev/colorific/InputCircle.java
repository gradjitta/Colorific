package com.udacity.gamedev.colorific;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by Blackstorm on 14/12/2015.
 */
public class InputCircle {

    public static final String TAG = InputCircle.class.getName();


    Vector2 position;
    Color color;

    public InputCircle(Vector2 position, Color color) {
        this.position = position;
        this.color = color;
    }


    public void render(ShapeRenderer renderer) {
        renderer.circle(position.x, position.y , Constants.CIRCLE_RADIUS );
    }




}
