package com.ah.towerfight.connectivity;

import com.ah.towerfight.connectivity.IConnectivity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DesktopConnectivity implements IConnectivity {
    @Override
    public boolean isInternetAvailable() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            connection.connect();
            int responseCode = connection.getResponseCode();
            return (responseCode == 200);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
