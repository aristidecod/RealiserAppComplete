package com.ah.towerfight.screens;

import com.ah.towerfight.App;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class MainMenuScreen implements Screen {
    final App game;
    private Stage stage;
    private ShapeRenderer shapeRenderer;
    private ImageButton boutonCombattre;
    private ImageButton boutonCollection;
    private ImageButton boutonCombat;
    private Label labelPieces;
    private Label labelGems;

    public MainMenuScreen(final App game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        shapeRenderer = new ShapeRenderer();

        initButtons();
        initUIElements();
    }

    private void initButtons() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        // Charger les images pour les boutons
        Drawable drawableCombattre = new TextureRegionDrawable(new Texture("combattre_menu.png"));
        Drawable drawableCollection = new TextureRegionDrawable(new Texture("collection_menu.png"));
        Drawable drawableCombat = new TextureRegionDrawable(new Texture("combat.png"));

        // Créer les boutons
        boutonCombattre = new ImageButton(drawableCombattre);
        boutonCollection = new ImageButton(drawableCollection);
        boutonCombat = new ImageButton(drawableCombat);

        // Définir la taille des boutons
        float boutonLargeur = screenWidth * 0.3f;
        float boutonHauteur = screenHeight * 0.2f;
        boutonCombattre.setSize(boutonLargeur, boutonHauteur);
        boutonCollection.setSize(boutonLargeur, boutonHauteur);
        boutonCombat.setSize(screenWidth * 0.5f, screenHeight * 0.2f);

        // Positionner les boutons
        float espacementHorizontal = screenWidth * 0.15f;
        float espacementVertical = 0;
        boutonCollection.setPosition(espacementHorizontal, espacementVertical);
        boutonCombattre.setPosition(screenWidth - boutonLargeur - espacementHorizontal, espacementVertical);
        boutonCombat.setPosition(screenWidth * 0.25f, screenHeight * 0.4f);

        stage.addActor(boutonCombattre);
        stage.addActor(boutonCollection);
        stage.addActor(boutonCombat);
    }

    private void initUIElements() {
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        // Créer les images de fond
        Image fondPieces = new Image(new Texture("pieces_fond.png"));
        Image fondGems = new Image(new Texture("gemmes_fond.png"));
        Image fondXP = new Image(new Texture("xp_fond.png"));

        // Redimensionner les images de fond
        float fondLargeur = screenWidth * 0.25f;
        float fondHauteur = screenHeight * 0.030f;
        fondXP.setSize(screenWidth * 0.55f, screenHeight * 0.15f);
        fondPieces.setSize(fondLargeur, fondHauteur);
        fondGems.setSize(fondLargeur, fondHauteur);

        // Positionner les images de fond
        float yPositionFond = screenHeight * 0.93f;
        float yPositionFondxp = screenHeight * 0.87f;
        fondXP.setPosition(screenWidth * 0.03f, yPositionFondxp);
        fondPieces.setPosition(screenWidth * 0.4f, yPositionFond);
        fondGems.setPosition(screenWidth * 0.7f, yPositionFond);

        // Créer les images
        Image imagePieces = new Image(new Texture("pieces.png"));
        Image imageGems = new Image(new Texture("gemmes.png"));
        Image imageUsername = new Image(new Texture("username.png"));

        // Redimensionner les images
        imagePieces.setSize(screenWidth * 0.08f, screenHeight * 0.040f);
        imageGems.setSize(screenWidth * 0.08f, screenHeight * 0.040f);
        imageUsername.setSize(screenWidth * 1.0f, screenHeight * 0.3f);

        // Positionner les images
        float yPositionimg = screenHeight * 0.93f;
        imagePieces.setPosition(screenWidth * 0.6f, yPositionimg);
        imageGems.setPosition(screenWidth * 0.9f, yPositionimg);
        imageUsername.setPosition(screenWidth * 0.03f, screenHeight * 0.55f);

        // Créer les labels
        String labelStyle,labelStyle_user,labelStyle_trophies;
        if (screenWidth < 800) {
            labelStyle = "small";
        } else if (screenWidth < 1280) {
            labelStyle = "default";
        } else {
            labelStyle = "large";
        }
        if (screenWidth < 800) {
            labelStyle_user = "userfont_small";
        } else if (screenWidth < 1280) {
            labelStyle_user = "userfont_medium";
        } else {
            labelStyle_user = "userfont_large";
        }
        if (screenWidth < 800) {
            labelStyle_trophies = "trophiesfont_small";
        } else if (screenWidth < 1280) {
            labelStyle_trophies = "trophiesfont_medium";
        } else {
            labelStyle_trophies = "trophiesfont_large";
        }
        labelPieces = new Label("1000", skin,labelStyle);
        labelGems = new Label("500", skin,labelStyle);
        Label labelXPPoints = new Label("2000/5000", skin,labelStyle);
        Label labelXPLevel = new Label("5", skin,labelStyle);
        Label labelUsername = new Label("fuclsfjkss", skin,labelStyle_user);
        Label labelTrophies = new Label("1234", skin, labelStyle_trophies);

        // Positionner les labels
        float yPositionlabel = screenHeight * 0.938f;
        labelPieces.setPosition(screenWidth * 0.45f, yPositionlabel);
        labelGems.setPosition(screenWidth * 0.75f, yPositionlabel);
        labelXPPoints.setPosition(screenWidth * 0.17f, yPositionlabel);
        labelXPLevel.setPosition(screenWidth * 0.08f, yPositionlabel);
        labelUsername.setPosition(screenWidth * 0.05f, screenHeight * 0.79f);
        labelTrophies.setPosition(screenWidth * 0.59f, screenHeight * 0.795f);

        // Ajouter les images et les labels à la scène
        stage.addActor(fondPieces);
        stage.addActor(fondGems);
        stage.addActor(fondXP);
        stage.addActor(imagePieces);
        stage.addActor(imageGems);
        stage.addActor(imageUsername);
        stage.addActor(labelPieces);
        stage.addActor(labelGems);
        stage.addActor(labelXPPoints);
        stage.addActor(labelXPLevel);
        stage.addActor(labelUsername);
        stage.addActor(labelTrophies);
    }

    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // Convertir la couleur hexadécimale #53C6DF en valeurs RGBA
        Color backgroundColor = Color.valueOf("135665");
        Gdx.gl.glClearColor(backgroundColor.r, backgroundColor.g, backgroundColor.b, backgroundColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Définir la hauteur du fond en fonction d'un pourcentage de la hauteur de l'écran
        float hauteurDuFond = Gdx.graphics.getHeight() * 0.2f; // Par exemple, 20% de la hauteur de l'écran

        // Dessiner le fond coloré pour la zone des boutons
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.valueOf("0D2B32"));
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), hauteurDuFond);
        shapeRenderer.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        // Logique pour mettre en pause, si nécessaire
    }

    @Override
    public void resume() {
        // Logique pour reprendre, si nécessaire
    }

    @Override
    public void hide() {
        // Logique pour gérer le moment où l'écran n'est plus visible
    }

    @Override
    public void dispose() {
        stage.dispose();
        shapeRenderer.dispose();
    }
}
