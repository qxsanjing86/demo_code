package com.example.demoproject.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by abner on 10/30/14.
 */
public class Anim_ImageView extends ImageView {
    public Anim_ImageView(Context context) {
        super(context);
    }

    public Anim_ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Anim_ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setWidth(int width){
        Log.d("nqy","Anim_ImageView setWidth "+width);
        ViewGroup.LayoutParams lp =  getLayoutParams();
        lp.width = width;
        invalidate();
    }

    public void setHeight(int height){
        Log.d("nqy","Anim_ImageView setHeight "+height);
        ViewGroup.LayoutParams lp =  getLayoutParams();
        lp.height = height;
        invalidate();
    }

}
