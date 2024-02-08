package com.ah.towerfight.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AndroidConnectivity implements IConnectivity {
    private Context context;

    public AndroidConnectivity(Context context) {
        this.context = context;
    }

    @Override
    public boolean isInternetAvailable() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
