package com.example.androidu.glcamera.ar_framework.graphics3d.billboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.Matrix;

public class SizedBillboard {

    Billboard mBillboard = new Billboard();
    float mScale = 1;
    float[] mScaleMatrix = new float[16];
    float[] mMatrix = new float[16];

    public static void init(Context context){
        Billboard.init(context);
    }

    public void setScale(int scale){
        if(scale > 0)
            mScale = scale;
    }

    public void setBitmap(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Matrix.setIdentityM(mScaleMatrix, 0);
        Matrix.scaleM(mScaleMatrix, 0, width * mScale / 500, height * mScale / 500, 1);

        mBillboard.setBitmap(bitmap);
    }

    public void draw(){
        Matrix.multiplyMM(mMatrix, 0, getMatrix(), 0, mScaleMatrix, 0);
        mBillboard.draw(mMatrix);

    }

    public void draw(float[] matrix){
        Matrix.multiplyMM(mMatrix, 0, matrix, 0, mScaleMatrix, 0);
        mBillboard.draw(mMatrix);
    }

    public float[] getMatrix(){
        return mBillboard.getMatrix();
    }
}
