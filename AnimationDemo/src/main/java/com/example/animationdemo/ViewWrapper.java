package com.example.animationdemo;

import android.view.View;

/**
 * Created by zhangjinbo on 17-8-10.
 */

public class ViewWrapper {

    private View mTarget;

    public ViewWrapper(View target) {
        mTarget = target;
    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
        //return 0;
//        Log.d("9095", "IllegalArgumentException why don't");
//        throw new RuntimeException("IllegalArgumentException");
    }

    public void setWidth(int width) {
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }

}
