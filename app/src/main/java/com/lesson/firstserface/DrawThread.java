package com.lesson.firstserface;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.SurfaceHolder;

public class DrawThread extends Thread
{
    boolean runFlag=false;
    SurfaceHolder surfaceHolder;
    Bitmap picture;
    int x=0;
    int width;
    private int xSpeed=1;

    public DrawThread(SurfaceHolder surfaceHolder, Resources resources, int width)
    {
        this.surfaceHolder = surfaceHolder;
        this.width = width;
        picture=BitmapFactory.decodeResource(resources,R.drawable.ping);
    }

    @Override
    public void run() {
        super.run();
        
    }
}
