package com.ah.towerfight;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.ah.towerfight.connectivity.DesktopConnectivity;

public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Jeu en reseau");

		DesktopConnectivity desktopConnectivity = new DesktopConnectivity();
		new Lwjgl3Application(new App(desktopConnectivity), config);
	}
}
