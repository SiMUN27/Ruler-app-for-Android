package com.example.ravnalo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class MyCustomView extends View {

    Paint paint = new Paint();
    Paint text = new Paint();
    Paint rectangle = new Paint();
    private int counter = 0;

    /* Find number of pixels per millimeter. */
    DisplayMetrics dm = getResources().getDisplayMetrics();
    private float pxPerMillimeter = (float) (1.0f * dm.xdpi / 25.4);

    /* Needed constructors */
    public MyCustomView(Context context) {
        super(context);
        init(null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    private void init(@Nullable AttributeSet set){

    }
    /* End of needed constructors */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /* Draw rectangle */
        rectangle.setColor(Color.YELLOW);
        canvas.drawRect(0,50, getWidth(), 320, rectangle);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);

        text.setColor(Color.BLACK);
        text.setStrokeWidth(5);
        text.setTextSize(40);

        /* Draw ruler borders and the middle line */
        canvas.drawLine(0,175, getWidth(),175,paint);
        canvas.drawLine(0,50,getWidth(), 50, paint);
        canvas.drawLine(0,320,getWidth(), 320, paint);

        /* Draw millimeters and numbers */
        for (int i = 0; i <= getWidth(); i+= pxPerMillimeter){
            if (counter % 10 == 0 ){
                canvas.drawLine(i, 130, i, 220, paint);
                canvas.drawText(String.valueOf(counter), i - 25,280, text);
            }
            else if (counter % 5 == 0){
                canvas.drawLine(i, 160, i,  190, paint);
            }
            else{
                canvas.drawLine(i, 170, i, 180, paint);
            }
                counter++;
        }

    }
}
