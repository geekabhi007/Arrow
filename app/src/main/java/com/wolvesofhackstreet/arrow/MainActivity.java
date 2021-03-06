package com.wolvesofhackstreet.arrow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        // If no user logged in, then open the login page
        /* After using any signup or login methods, the user is cached on disk. This cache can be
             treated as a session.
         */
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            navigateToLogin();
        }
        else {
            Log.i(TAG, currentUser.getUsername());
        }
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
