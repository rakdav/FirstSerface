package com.lesson.firstserface;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class DrawThread extends Thread
{
    boolean runFlag=false;
    SurfaceHolder surfaceHolder;
    Bitmap picture;
    int x=0;
    int width;
    private int xSpeed=10;
    private int curY=10;
    public DrawThread(SurfaceHolder surfaceHolder, Resources resources, int width)
    {
        this.surfaceHolder = surfaceHolder;
        this.width = width;
        picture=BitmapFactory.decodeResource(resources,R.drawable.ping);
    }

    public void setY(int y,int _x)
    {
        curY=y;
        x=_x;
    }
    @Override
    public void run() {
        super.run();
        Canvas canvas;
        while (runFlag) {
            if (x >= width - picture.getWidth())
                xSpeed = -10;
            if (x == 0) xSpeed = 10;
            x += xSpeed;
            canvas=null;
            try
            {
                canvas=surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder)
                {
                    canvas.drawColor(Color.YELLOW);
                    canvas.drawBitmap(picture,x,curY,null);
                }
            }
            finally {
                if(canvas!=null)
                {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
