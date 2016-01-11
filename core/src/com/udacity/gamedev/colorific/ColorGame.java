package com.udacity.gamedev.colorific;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class ColorGame extends Game {
	@Override
	public void create() {
		// Gdx.app.log("ColorGame", "create called");
		showColorScreen();
	}

	public void showColorScreen() {
		setScreen(new ColorInputScreen(this));
	}
}
