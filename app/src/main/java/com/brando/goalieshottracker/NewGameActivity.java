package com.brando.goalieshottracker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity to start a new game
 *
 * @author mgovender
 */

public class NewGameActivity extends AppCompatActivity {

    DrawableImageView goalie;
    Bitmap bitmap;
    Bitmap bmOverlay;

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
    }
}



