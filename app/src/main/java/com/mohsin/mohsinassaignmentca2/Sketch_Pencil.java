package com.mohsin.mohsinassaignmentca2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class Sketch_Pencil extends View {
    Path path;
    Paint p;
    Bitmap bm;
    public Sketch_Pencil(Context context) {
        super(context);
        path=new Path();
        p=new Paint();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(15f);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        canvas.drawPath(path,p);
        bm= BitmapFactory.decodeResource(getResources(),R.drawable.smile1);
        canvas.drawBitmap(bm,0,0,null);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:
                int x=(int) event.getX();
                int y=(int)event.getY();
                if((x>=10 && x<=110) && (y>=10 && y<=120))
                {
                    p.reset();
                }
        }
        invalidate();
        return true;
    }

}
