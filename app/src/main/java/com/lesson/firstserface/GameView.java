package com.lesson.firstserface;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder holder;
    public GameView(Context context) {
        super(context);
        holder=getHolder();
        holder.addCallback(this);
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }
}
