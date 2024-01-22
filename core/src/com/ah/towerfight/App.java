package com.ah.towerfight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class App extends Game {
	SpriteBatch batch;
	Texture img;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		// Définissez l'écran initial ici, par exemple:
		// this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render(); // Important ! Cela déléguera le rendu à l'écran actuel.
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

	// Getters pour les ressources communes, si nécessaire
	public SpriteBatch getBatch() {
		return batch;
	}
}
