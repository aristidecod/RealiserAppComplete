package com.ah.towerfight;

import android.os.Bundle;
import com.ah.towerfight.connectivity.AndroidConnectivity;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ah.towerfight.App;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new App(new AndroidConnectivity(this)), config);
	}
}
