package com.lesson.firstserface;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder holder;
    DrawThread drawThread;
    public GameView(Context context) {
        super(context);
        holder=getHolder();
        holder.addCallback(this);
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        drawThread=new DrawThread(this.holder,getResources(),getWidth());
        drawThread.runFlag=true;
        drawThread.start();
    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        boolean retry=true;
        drawThread.runFlag=false;
        while (retry)
        {
            try {
                drawThread.join();
                retry=false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawThread.setY((int)event.getY(),(int)event.getX());
        return false;
    }
}
