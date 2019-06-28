package com.brando.goalieshottracker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static com.brando.goalieshottracker.NewGameActivity.incrementShots;

/**
 * Creates an ImageView with onTouch listener enabled
 *
 * @author mgovender
 */

public class DrawableImageView extends android.support.v7.widget.AppCompatImageView implements View.OnTouchListener {
    float downx = 0;
    float downy = 0;
    float upx = 0;
    float upy = 0;

    Canvas canvas;
    Paint paint;
    Matrix matrix;
    int color = Color.BLACK;

    /**
     * @param context
     */
    public DrawableImageView(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    /**
     * @param context
     * @param attrs
     */
    public DrawableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DrawableImageView(Context context, AttributeSet attrs,
                             int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }

    /**
     * Add mutable image to canvas
     *
     * @param alteredBitmap
     * @param bmp
     */
    public void setNewImage(Bitmap alteredBitmap, Bitmap bmp) {
        canvas = new Canvas(alteredBitmap);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        matrix = new Matrix();
        canvas.drawBitmap(bmp, matrix, paint);

        setImageBitmap(alteredBitmap);

    }

    public void setPaintColor (String c) {
        color = (c=="red") ?  Color.RED : Color.BLACK;

    }

    /**
     * Trigger ontouch event
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downx = getPointerCoords(event)[0];//event.getX();
                downy = getPointerCoords(event)[1];//event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                upx = getPointerCoords(event)[0];//event.getX();
                upy = getPointerCoords(event)[1];//event.getY();
                paint.setColor(color);
                canvas.drawCircle(upx, upy, 55, paint);
                if (color == Color.RED) {
                    incrementShots("goal");
                } else {
                    incrementShots("shot");
                }
                invalidate();
                break;
        }
        return true;
    }

    final float[] getPointerCoords(MotionEvent e) {
        final int index = e.getActionIndex();
        final float[] coords = new float[]{e.getX(index), e.getY(index)};
        Matrix matrix = new Matrix();
        getImageMatrix().invert(matrix);
        matrix.postTranslate(getScrollX(), getScrollY());
        matrix.mapPoints(coords);
        return coords;
    }
}