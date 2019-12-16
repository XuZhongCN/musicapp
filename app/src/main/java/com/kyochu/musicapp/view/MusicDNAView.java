package com.kyochu.musicapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Random;


public class MusicDNAView extends View {


    public MusicDNAView(Context context) {
        this(context,null);
    }

    public MusicDNAView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MusicDNAView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }
    private void init(){
        shaderPaint=new Paint();
        shaderPaint.setColor(0xff000000);
        shaderPaint.setStyle(Paint.Style.STROKE);
        shaderPaint.setAntiAlias(true);
        shaderPaint.setStrokeWidth(1);

    }
    private Paint shaderPaint;


    private Random random= new Random();
    private int randomColor(){
        return 0xff000000+random.nextInt(0xffffff);
    }
    private int randowValue(){
        return random.nextInt(300)-150;
    }
    private int random100(){return random.nextInt(200)-100;}

    private class DNABean{
        public int amplitude;
        public int period;
        public int startPosition;
    }

    private void drawDNABean(Canvas canvas,DNABean dnaBean,Paint paint){
        Path path=new Path();
        path.moveTo(dnaBean.startPosition-dnaBean.period/5,getHeight()/2);
        path.cubicTo(dnaBean.startPosition,getHeight()/2+dnaBean.amplitude,dnaBean.startPosition+dnaBean.period/5,getHeight()/2+dnaBean.amplitude,dnaBean.startPosition+dnaBean.period/5*2,getHeight()/2);
        path.cubicTo(dnaBean.startPosition+dnaBean.period/5*3,getHeight()/2-dnaBean.amplitude,dnaBean.startPosition+dnaBean.period/5*4,getHeight()/2-dnaBean.amplitude,dnaBean.startPosition+dnaBean.period,getHeight()/2);
//        path.lineTo(dnaBean.startPosition,getHeight()/2);
//        path.lineTo(dnaBean.startPosition+ dnaBean.period/4,getHeight()/2+dnaBean.amplitude);
//        path.lineTo(dnaBean.startPosition+ 3*dnaBean.period/4,getHeight()/2-dnaBean.amplitude);
//        path.lineTo(dnaBean.startPosition+ dnaBean.period,getHeight()/2);
//        path.lineTo(getWidth(),getHeight()/2);
        canvas.drawPath(path,paint);


    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            amplitudeMultiple=1;
        }
    };
    private int amplitudeMultiple=1;
    public void setAmplitudeMultiple(int amplitudeMultiple,final int keepTime){
        this.amplitudeMultiple=amplitudeMultiple;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(keepTime);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();

        shaderPaint.setStrokeWidth(3);
        canvas.drawLine(450,height/2,width-440,height/2,shaderPaint);
        for (int i = 0; i < 20; i++) {
            DNABean dnaBean= new DNABean();
            dnaBean.amplitude=(random.nextInt(40)-20);
            dnaBean.period=random.nextInt(100)+100;
            dnaBean.startPosition=random.nextInt(600)+500;
            drawDNABean(canvas,dnaBean,shaderPaint);
        }

        if(amplitudeMultiple!=1){
            for (int i = 0; i < 20; i++) {
                DNABean dnaBean= new DNABean();
                dnaBean.amplitude=(random.nextInt(40)-20)*amplitudeMultiple;
                dnaBean.period=random.nextInt(100)+100;
                dnaBean.startPosition=random.nextInt(600)+500;
                drawDNABean(canvas,dnaBean,shaderPaint);
            }
        }

//        for (int i = 0; i < 50; i++) {
//            Path path = new Path();
//            path.moveTo(width/10+random100(),height/2+random100());
//            path.quadTo(width/2+randowValue(),height*2/3+randowValue(),width*9/10+random100(),height/2+random100());
//            LinearGradient linearGradient=new LinearGradient(200, 200, 500, 500,
//                    new int[] { randomColor(), randomColor(), randomColor(), randomColor(), randomColor() },
//                    new float[] { 0, 0.1F, 0.5F, 0.7F, 0.8F }, Shader.TileMode.MIRROR );
//            shaderPaint.setShader(linearGradient);
//            canvas.drawPath(path,shaderPaint);
//        }
//        for (int i = 0; i < 50; i++) {
//            Path path = new Path();
//            path.moveTo(width/10+random100(),height/2+random100());
//            path.quadTo(width/2+randowValue(),height/3+randowValue(),width*9/10+random100(),height/2+random100());
//            LinearGradient linearGradient=new LinearGradient(200, 200, 500, 500,
//                    new int[] { randomColor(), randomColor(), randomColor(), randomColor(), randomColor() },
//                    new float[] { 0, 0.1F, 0.5F, 0.7F, 0.8F }, Shader.TileMode.MIRROR );
//            shaderPaint.setShader(linearGradient);
//            canvas.drawPath(path,shaderPaint);
//        }
//        for (int i = 0; i < 50; i++) {
//            Path path = new Path();
//            path.moveTo(width/9+random100(),height/2+random100());
//            path.quadTo(width/2+randowValue(),height+randowValue(),width*9/10+random100(),height/2+random100());
//            LinearGradient linearGradient=new LinearGradient(200, 200, 500, 500,
//                    new int[] { randomColor(), randomColor(), randomColor(), randomColor(), randomColor() },
//                    new float[] { 0, 0.1F, 0.5F, 0.7F, 0.8F }, Shader.TileMode.MIRROR );
//            shaderPaint.setShader(linearGradient);
//            canvas.drawPath(path,shaderPaint);
//        }
//        for (int i = 0; i < 50; i++) {
//            Path path = new Path();
//            path.moveTo(width/9+random100(),height/2+random100());
//            path.quadTo(width/2+randowValue(),0+randowValue(),width*9/10+random100(),height/2+random100());
//            LinearGradient linearGradient=new LinearGradient(200, 200, 500, 500,
//                    new int[] { randomColor(), randomColor(), randomColor(), randomColor(), randomColor() },
//                    new float[] { 0, 0.1F, 0.5F, 0.7F, 0.8F }, Shader.TileMode.MIRROR );
//            shaderPaint.setShader(linearGradient);
//            canvas.drawPath(path,shaderPaint);
//        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
