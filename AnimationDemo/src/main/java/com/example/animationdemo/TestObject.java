package com.example.animationdemo;

import android.util.Log;

public class TestObject {

    /**
     * 实验证明，只要有同名的setXXX方法，ObjectAnimator就能正确执行， 不需要属性，也不需要get方法。
     */
    public void setX(int x){
        Log.d("9095", "objectAnimator set x :" + x);
    }

    public int getX() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }

    public void setY(int y){
        Log.d("9095", "objectAnimator set y :" + y);
    }
}
