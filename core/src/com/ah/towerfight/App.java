package com.ah.towerfight;

import com.ah.towerfight.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ah.towerfight.connectivity.IConnectivity;

public class App extends Game {
	SpriteBatch batch;
	Stage stage;
	IConnectivity connectivityChecker;

	public App(IConnectivity connectivityChecker) {
		this.connectivityChecker = connectivityChecker;
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		stage = new Stage();

		if (connectivityChecker != null) {
			if (!connectivityChecker.isInternetAvailable()) {
				Gdx.app.log("Connectivité", "Pas de connexion Internet détectée.");
				showNoInternetDialog();
			} else {
				Gdx.app.log("Connectivité", "Connexion Internet disponible.");
				this.setScreen(new MainMenuScreen(this));
			}
		} else {
			Gdx.app.log("Connectivité", "Le vérificateur de connectivité est null.");
			// Peut-être montrer un dialogue d'erreur ou procéder avec une valeur par défaut
			this.setScreen(new MainMenuScreen(this));
		}
	}

	private void showNoInternetDialog() {
		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
		Dialog dialog = new Dialog("Erreur de connexion", skin);
		dialog.text("Une connexion Internet est nécessaire pour jouer à ce jeu.");
		dialog.button("OK");
		dialog.show(stage);
	}

	@Override
	public void render() {
		super.render();
		if (stage != null) {
			stage.act();
			stage.draw();
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		if (stage != null) {
			stage.dispose();
		}
	}
}
