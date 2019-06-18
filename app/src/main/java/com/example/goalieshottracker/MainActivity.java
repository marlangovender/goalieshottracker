package com.example.goalieshottracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the New Game button */
    public void newGame(View view) {
        Intent intent = new Intent(this,NewGameActivity.class);
        Log.d(TAG, "newGame: " + intent);
        startActivity(intent);
    }
}
