package com.example.goalieshottracker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NewGameActivity extends AppCompatActivity {


    private static final String DEBUG_TAG = "Gestures";
    Canvas canvas;
    DrawableImageView goalie;
    Bitmap bitmap;
    Paint paint;
    Bitmap bmOverlay;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        goalie = findViewById(R.id.imageView);
        Log.d("Image", goalie.toString());

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.goalie_clip_art).copy(Bitmap.Config.ARGB_8888, true);
        bmOverlay = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(),
                bitmap.getConfig());
        goalie.setNewImage(bmOverlay, bitmap);

        //mDetector = new GestureDetectorCompat(this, new MyGestureListener());
    }


    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(DEBUG_TAG, "onDown: " + event.toString());
            return true;
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            Log.d(DEBUG_TAG, "onTap: " + event.toString());
            //cv.drawCircle(event.getX(), event.getY(), 20, paint);
            canvas.drawCircle(event.getX(),event.getY(),35 ,paint);
            goalie.setImageBitmap(bmOverlay);


            Log.d("Marlan", String.valueOf(event.getX()));
            return true;
        }
    }*/

}



