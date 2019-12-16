package com.kyochu.musicapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class MarkImageView extends ImageView {
    public MarkImageView(Context context) {
        this(context,null);
    }

    public MarkImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MarkImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint paint;
    public void init(){
        paint=new Paint();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w=getWidth();
        int h=getHeight();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(0x88333333);
//        Path path=new Path();
//
//        path.moveTo(0,0);
//        path.lineTo(0,h);
//        path.lineTo(w,h);
//        path.lineTo(w,0);
//        path.lineTo(0,0);
//        path.moveTo(100,100);
//        path.lineTo(100,200);
//        path.lineTo(200,200);
//        path.lineTo(200,100);
//        path.lineTo(100,100);
//        canvas.drawPath(path,paint);

        canvas.drawRect(0,0,w,h,paint);
        paint.setColor(0x00ffffff);
        canvas.drawRect(100,100,200,200,paint);
    }
}
