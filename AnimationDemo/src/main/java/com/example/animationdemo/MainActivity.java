package com.example.animationdemo;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.text_view);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_1);
//        tv.startAnimation(animation);
//
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
//                alphaAnimation.setDuration(1000);
//                tv.startAnimation(alphaAnimation);
//
//                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        Rotate3dAnimation anim = new Rotate3dAnimation(0,180, tv.getWidth()/2, tv.getHeight()/2, 20, false);
//                        anim.setDuration(5000);
//                        tv.startAnimation(anim);
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });

        //自定义动画
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Rotate3dAnimation anim = new Rotate3dAnimation(0,180, tv.getWidth()/2, tv.getHeight()/2, 0, false);
//                anim.setDuration(5000);
//                anim.setFillAfter(true);
//                tv.startAnimation(anim);
//            }
//        });
//        Rotate3dAnimation anim = new Rotate3dAnimation(0,180, tv.getWidth()/2, tv.getHeight()/2, 20, false);
//        anim.setDuration(5000);
//        anim.setFillAfter(true);
//        tv.startAnimation(anim);

        //帧动画
//        tv.setBackgroundResource(R.drawable.frame_animation);
//        AnimationDrawable drawable = (AnimationDrawable) tv.getBackground();
//        drawable.start();

        ListView listView = (ListView) findViewById(R.id.list_view);
        String[] strs = new String[30];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "item#" + i;
        }

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));


        ValueAnimator colorAnim = ObjectAnimator.ofInt(listView, "backgroundColor", Color.RED, Color.BLUE);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();

        //动画默认300ms， 默认帧率10ms/帧
        ObjectAnimator.ofInt(new TestObject(), "x", 1, 100).setDuration(3000).start();

//        AnimatorSet set = new AnimatorSet();
//        set.playTogether(
//                ObjectAnimator.ofFloat(tv, "rotationX", 0, 360),
//                ObjectAnimator.ofFloat(tv, "rotationY", 0, 180),
//                ObjectAnimator.ofFloat(tv, "rotation", 0, -90),
//                ObjectAnimator.ofFloat(tv, "translationX", 0, 90),
//                ObjectAnimator.ofFloat(tv, "translationY", 0, 90),
//                ObjectAnimator.ofFloat(tv, "scaleX", 1, 1.5f),
//                ObjectAnimator.ofFloat(tv, "scaleY", 1, 0.5f),
//                ObjectAnimator.ofFloat(tv, "alpha", 1, 0.25f, 1)
//        );
//        set.setDuration(5 * 1000).start();


        setContentView(R.layout.activity_main_2);

        final ImageView iv2 = (ImageView) findViewById(R.id.image_view_2);


//        AnimatorSet set2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animator_set);
//        set2.setTarget(iv2);
//        set2.start();

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //让View从当前宽度增加到500px
                //采用ViewWrapper
//                ViewWrapper vw = new ViewWrapper(iv2);
//                ObjectAnimator.ofInt(vw, "width", 500).setDuration(5000).start();

                //采用ValueAnimator
                final int startValue = iv2.getLayoutParams().width;
                ValueAnimator valueAnimator = ValueAnimator.ofInt(startValue, 500);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    private IntEvaluator mEvaluator = new IntEvaluator();
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //采用fraction，此时ofInt后的值可以任意
//                        float fraction = valueAnimator.getAnimatedFraction();
//                        //直接调用整型估值器， 通过比例计算出宽度，然后在设给View
//                        iv2.getLayoutParams().width = mEvaluator.evaluate(fraction, startValue, 500);
//                        iv2.requestLayout();

                        //采用Value，初始值在ofInt指定。
                        int currentValue = (int) valueAnimator.getAnimatedValue();
                        iv2.getLayoutParams().width = currentValue;
                        iv2.requestLayout();

                    }
                });
                valueAnimator.setDuration(5000).start();
            }
        });





    }
}
