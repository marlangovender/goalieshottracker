package com.brando.goalieshottracker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Activity to start a new game
 *
 * @author mgovender
 */

public class NewGameActivity extends AppCompatActivity {

    DrawableImageView goalie;
    Bitmap bitmap;
    Bitmap bmOverlay;
    Button goalsButton;
    Button shotsButton;
    Paint paint;
    public static TextView shotsOnNet;
    public static TextView goals;
    public static TextView savePercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        goalie = findViewById(R.id.imageView);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.goalie_clip_art).copy(Bitmap.Config.ARGB_8888, true);
        bmOverlay = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(),
                bitmap.getConfig());
        goalie.setNewImage(bmOverlay, bitmap);
        shotsOnNet = findViewById(R.id.text_shots);
        goals = findViewById(R.id.text_goals);
        savePercentage = findViewById(R.id.text_savePercentage);
        goalsButton = findViewById(R.id.button2);
        shotsButton = findViewById(R.id.btn_shots);

    }

    public void onClick(View view) {

        if (view == goalsButton) {
            goalie.setPaintColor("red");
            goalsButton.setBackgroundColor(Color.RED);
            shotsButton.setBackgroundResource(android.R.drawable.btn_default);
        } else {
            goalie.setPaintColor("black");
            shotsButton.setBackgroundColor(Color.GRAY);
            goalsButton.setBackgroundResource(android.R.drawable.btn_default);
            ;
        }

    }

    public static float textViewToFloat (TextView val) {
        float currentVal = Float.parseFloat(val.getText().toString());
        return currentVal;
    }

    public static float round(float number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }


    public static void incrementShots(String shot) {
        float currentShots = textViewToFloat(shotsOnNet);
        float currentGoals = textViewToFloat(goals);
        if (shot == "goal") {
            currentGoals++;
        } else {
            currentShots++;
        }
        if (currentGoals <= currentShots) {
            float currentSavePercent = (currentShots - currentGoals) / currentShots;
            currentSavePercent = round(currentSavePercent, 3);
            String shotsAsString = Float.toString(currentShots);
            String savePercentAsString = Float.toString(currentSavePercent);
            String goalsAsString = Float.toString(currentGoals);
            shotsOnNet.setText(shotsAsString);
            savePercentage.setText(savePercentAsString);
            goals.setText(goalsAsString);
        }
    }
}



