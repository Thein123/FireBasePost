package com.globaldroid.app.myfirebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by User on 2/22/2018.
 */

public class InstanceIDService extends FirebaseInstanceIdService {


    private static final String Tag = "FirebaseID";

    @Override
    public void onTokenRefresh() {

        //Getting token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Show token on logcat
        Log.d(Tag, "Refreshed token: " + refreshedToken);

    }

    private void sendRegistrationToServer(String token) {
        // Write down your code here to do anything with toke like sending on server or save locally.
    }
}
