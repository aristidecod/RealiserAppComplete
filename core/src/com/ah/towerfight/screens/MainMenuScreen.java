package com.ah.towerfight.screens;

import com.ah.towerfight.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {

    final App game;
    private Stage stage;
    private Table table;
    private Skin skin;

    public MainMenuScreen(final App game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Créer les étiquettes pour XP, pièces, et gemmes
        Label xpLabel = new Label("XP: 100", skin);
        Label coinsLabel = new Label("Coins: 100", skin);
        Label gemsLabel = new Label("Gems: 100", skin);

        // Créer l'étiquette pour le nom de l'utilisateur
        Label usernameLabel = new Label("Username", skin);

        // Créer l'étiquette pour les trophées
        Label trophiesLabel = new Label("Trophies: 100", skin);

        // Créer les boutons
        TextButton battleButton = new TextButton("Battle", skin);
        TextButton[] chestButtons = new TextButton[4];
        for (int i = 0; i < chestButtons.length; i++) {
            chestButtons[i] = new TextButton("Chest " + (i + 1), skin);
        }
        TextButton attackButton = new TextButton("Attack", skin);
        TextButton collectionButton = new TextButton("Collection", skin);

        // Ajouter les éléments à la table
        table.top();
        table.add(xpLabel).padTop(10);
        table.row();
        table.add(coinsLabel).padTop(10);
        table.row();
        table.add(gemsLabel).padTop(10);
        table.row();
        table.add(usernameLabel).padTop(30);
        table.row();
        table.add(trophiesLabel).padTop(10);
        table.row();
        table.add(battleButton).padTop(30).padBottom(20);
        table.row();
        for (TextButton chestButton : chestButtons) {
            table.add(chestButton).padTop(10);
            table.row();
        }
        table.add(attackButton).padTop(30);
        table.row();
        table.add(collectionButton).padTop(10);

        // Ajuster la table
        table.pack();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
