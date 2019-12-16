package com.kyochu.musicapp.view;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
public class TouchBarView extends View {
    private DoublePointHorizontalScrollView horizontalScrollView;

    public DoublePointHorizontalScrollView getHorizontalScrollView() {
        return horizontalScrollView;
    }

    public void setHorizontalScrollView(DoublePointHorizontalScrollView horizontalScrollView) {
        this.horizontalScrollView = horizontalScrollView;
    }

    public TouchBarView(Context context) {
        this(context,null);
    }

    public TouchBarView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TouchBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint=new Paint();
        paint.setColor(0xff000000);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1);
        textPaint=new TextPaint();
        textPaint.setColor(0xff000000);
        textPaint.setTextSize(100);
        textPaint.setAntiAlias(true);
    }
    private Paint paint;
    private TextPaint textPaint;
    private int flag;

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        LinearGradient linearGradient=null;
        if(flag==0){
            //left
            linearGradient=new LinearGradient(0,0,getWidth(),0,0xff666666,0xffffffff, Shader.TileMode.CLAMP);

        }else{
            //right
            linearGradient=new LinearGradient(getWidth(),0,0,0,0xff666666,0xffffffff, Shader.TileMode.CLAMP);

        }
        paint.setShader(linearGradient);

        canvas.drawRect(0,0,getWidth(),getHeight(),paint);
        if(flag==0){
            //left
           canvas.drawText("< < <",30,85,textPaint);
        }else{
            //right
            canvas.drawText("> > >",getWidth()-240,85,textPaint);
        }
    }

    private static float hisX=-1f;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        if(event.getPointerCount()==1){
//            if(event.getAction()==MotionEvent.ACTION_MOVE){
//                Log.i("touchbar",event.getX()+"");
//                if(hisX>event.getX()){
//                    if(horizontalScrollView!=null){
//                        horizontalScrollView.smoothScrollBy(30,0);
//                    }
//                }else{
//                    if(horizontalScrollView!=null){
//                        horizontalScrollView.smoothScrollBy(-30,0);
//                    }
//                }
//                hisX=event.getX();
//            }
//        }
        return   horizontalScrollView.callSuperTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if(ev.getPointerCount()==1){
//            return false;
//        }
        return super.dispatchTouchEvent(ev);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
////        if(ev.getPointerCount()==1){
////            return false;
////        }
////        return super.onInterceptTouchEvent(ev);
//        return false;
//    }
}
