package com.kyochu.musicapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class DoublePointHorizontalScrollView extends HorizontalScrollView {

    public boolean callSuperTouchEvent(MotionEvent ev){
       return super.onTouchEvent(ev);
    }
    public DoublePointHorizontalScrollView(Context context) {
        super(context);
    }

    public DoublePointHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoublePointHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        if(ev.getPointerCount()==1){
//            return false;
//        }
//        return super.onTouchEvent(ev);
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if(ev.getPointerCount()==1){
//            return false;
//        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if(ev.getPointerCount()==1){
//            return false;
//        }
//        return super.onInterceptTouchEvent(ev);
        return false;
    }
}
