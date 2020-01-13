package com.kyochu.musicapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.kyochu.musicapp.R;

import org.w3c.dom.Text;

import androidx.annotation.Nullable;

public class ShowTheNumberLeftView extends View {
    public ShowTheNumberLeftView(Context context) {
        this(context,null);
    }

    public ShowTheNumberLeftView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShowTheNumberLeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private Paint paint;
    private TextPaint textPaint;
    private void init(){
        paint=new Paint();
        paint.setColor(0xff000000);
        paint.setStrokeWidth(1);

        textPaint=new TextPaint();
        textPaint.setColor(0xff000000);
        textPaint.setTextSize(20);
        textPaint.setAntiAlias(true);
    }

    private int rectHeight=16;
    private String [] texts={"ド","レ","ミ","ファ","ソ","ラ","シ","シ","シ","シ","シ"};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=this.getWidth();
        int height=this.getHeight();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        for (int i=0;i<8;i++){
            canvas.drawLine(0,height/7*i,width,height/7*i,paint);
//            canvas.rotate(-90,width/10*7,height/7*i-height/14+5);
            if(7-i>=0) {
                canvas.drawText(texts[7 - i], width / 10 * 7, height / 7 * i - height / 14 + 5, textPaint);
            }
//            canvas.rotate(90,width/10*7,height/7*i-height/14+5);
        }
        for (int i=0;i<8;i++){
            if(i!=0&&i!=0&&i!=4&&i!=7) {
                canvas.drawRect(0, height / 7 * i - rectHeight, width / 5 * 2, height / 7 * i + rectHeight, paint);
            }
        }


        //draw rect
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(width-1, 0,width-1,height-5, paint);
    }
}
