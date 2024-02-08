package com.ah.towerfight.connectivity;

import com.ah.towerfight.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ConnectivityMonitor {
    private final IConnectivity connectivityChecker;
    private final App gameApp;
    private boolean isConnected;
    private Stage stage; // Ajouter une instance de Stage pour afficher la boîte de dialogue

    public ConnectivityMonitor(IConnectivity connectivityChecker, App gameApp) {
        this.connectivityChecker = connectivityChecker;
        this.gameApp = gameApp;
        this.isConnected = true;
        this.stage = new Stage(); // Initialiser le Stage
        Gdx.input.setInputProcessor(stage); // Définir le processeur d'entrée
        startMonitoring();
    }

    private void startMonitoring() {
        new Thread(() -> {
            while (true) {
                boolean currentStatus = connectivityChecker.isInternetAvailable();
                if (currentStatus != isConnected) {
                    isConnected = currentStatus;
                    if (!isConnected) {
                        Gdx.app.postRunnable(this::showNoInternetDialog);
                    } else {
                        // Gérer la reconnexion si nécessaire
                    }
                }
                try {
                    Thread.sleep(5000); // Vérifiez toutes les 5 secondes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showNoInternetDialog() {
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        Dialog dialog = new Dialog("Erreur de connexion", skin, "dialog");
        dialog.text("Une connexion Internet est nécessaire pour jouer à ce jeu.");
        dialog.button("OK");
        dialog.show(stage);
    }

    // Méthode pour rendre le stage accessible si nécessaire
    public Stage getStage() {
        return stage;
    }
}
