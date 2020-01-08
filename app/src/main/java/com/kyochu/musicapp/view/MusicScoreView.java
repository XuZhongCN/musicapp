package com.kyochu.musicapp.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.kyochu.musicapp.MainActivity;
import com.kyochu.musicapp.R;
import com.kyochu.musicapp.db.DMLHelper;
import com.kyochu.musicapp.pojo.MusicScore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicScoreView extends View implements SoundPool.OnLoadCompleteListener {
    public MusicScoreView(Context context) {
        this(context,null);
    }

    public MusicScoreView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MusicScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private View musicDNAView=null;
    private int initMusicId=1;
    private DoublePointHorizontalScrollView doublePointHorizontalScrollView=null;

    private int modeFlag=0;

    public int getModeFlag() {
        return modeFlag;
    }

    public void setModeFlag(int modeFlag){
        this.modeFlag=modeFlag;
        if(modeFlag==0){
            //musicScoreStatic->musicScores
            for (int i = 0; i < musicScoreStatic.size(); i++) {
                for (int j = 0; j < musicScoreStatic.get(i).size(); j++) {
                    musicScore.get(i).set(j,musicScoreStatic.get(i).get(j));
                }
            }
        }else if(modeFlag==1){
            //changed musicScore
            Random random=new Random();
            int randomI1=random.nextInt(musicScore.size());
            int randomJ1=random.nextInt(musicScore.get(randomI1).size());

            int randomI2=0;
            int randomI3=0;
            int randomJ2=0;
            int randomJ3=0;
            for(;;){
                randomI2=random.nextInt(musicScore.size());
                randomJ2=random.nextInt(musicScore.get(randomI2).size());
                if(!(randomI1==randomI2&&randomJ1==randomJ2)){
                    break;
                }
            }
            for (;;){
                randomI3=random.nextInt(musicScore.size());
                randomJ3=random.nextInt(musicScore.get(randomI3).size());
                if((!(randomI1==randomI3&&randomJ1==randomJ3))&&(!(randomI3==randomI2&&randomJ3==randomJ2))){
                    break;
                }
            }
            //change 3 values.
            for (;;) {
                int newScore=random.nextInt(8)+1;
                if (newScore!=musicScore.get(randomI1).get(randomJ1)){
                    musicScore.get(randomI1).set(randomJ1,newScore);
                    break;
                }
            }
            for (;;) {
                int newScore=random.nextInt(8)+1;
                if (newScore!=musicScore.get(randomI2).get(randomJ2)){
                    musicScore.get(randomI2).set(randomJ2,newScore);
                    break;
                }
            }
            for (;;) {
                int newScore=random.nextInt(8)+1;
                if (newScore!=musicScore.get(randomI3).get(randomJ3)){
                    musicScore.get(randomI3).set(randomJ3,newScore);
                    break;
                }
            }
        }
        postInvalidate();
    }

    public DoublePointHorizontalScrollView getDoublePointHorizontalScrollView() {
        return doublePointHorizontalScrollView;
    }

    public void setDoublePointHorizontalScrollView(DoublePointHorizontalScrollView doublePointHorizontalScrollView) {
        this.doublePointHorizontalScrollView = doublePointHorizontalScrollView;
    }


    public void setMusicDNAView(View musicDNAView) {
        this.musicDNAView = musicDNAView;
    }

    private Paint paint;
    private List<List<Integer>> musicScore;
    private List<List<Integer>> musicScoreStatic;
    private List<List<Integer>> rawIndexInOne;
    private List<View> topViews=null;
    private List<View> bottomViews=null;
    private int [] loops={1,1,1,1,1,1,1,1,1,1,1,1};
    private int [] imageMarkerFlags={1,0,1,0,1,0,1,1,1,1,1,1};

    public void setImageMarkerFlags(int[] imageMarkerFlags) {
        this.imageMarkerFlags = imageMarkerFlags;
        postInvalidate();
    }

    public void setLoop(int index, int loop){
        loops[index-1]=loop;
    }
    public List<List<Integer>> getMusicScore() {
        return musicScore;
    }

    private int chapterSize=3;

    public void setChapterSize(int chapterSize){
        this.chapterSize=chapterSize;
        init();
        setData(initMusicId);
        postInvalidate();
    }

    public void setData(int initMusicId){
        this.initMusicId=initMusicId;
        List<MusicScore> musicScores=new DMLHelper(this.getContext()).findMusicScoreByMusicId(initMusicId);
        musicScore=new ArrayList<>();
        musicScoreStatic=new ArrayList<>();
        rawIndexInOne=new ArrayList<>();
        int initSum=0;
        for(int i=0;i<12;i++){
            ArrayList temp=new ArrayList<Integer>();
            ArrayList tempForStatic=new ArrayList<Integer>();
            ArrayList tempForIndex=new ArrayList<Integer>();
            for(int j=0;j<chapterSize;j++){
                temp.add(musicScores.get(initSum).getScore());
                tempForStatic.add(musicScores.get(initSum).getScore());
                tempForIndex.add(1);
                initSum++;
            }
            rawIndexInOne.add(tempForIndex);
            musicScore.add(temp);
            musicScoreStatic.add(tempForStatic);
        }
        invalidate();
    }
    //public void setMusicScore(List<List<Integer>> musicScore) {
    //    this.musicScore = musicScore;
    //}

    public List<View> getTopViews() {
        return topViews;
    }

    public void setTopViews(List<View> topViews) {
        this.topViews = topViews;
    }

    public List<View> getBottomViews() {
        return bottomViews;
    }

    public void setBottomViews(List<View> bottomViews) {
        this.bottomViews = bottomViews;
    }

    private void init(){
        paint=new Paint();
        paint.setColor(0xff229b77);
        paint.setStrokeWidth(1);

        musicScore=new ArrayList<>();
        for(int i=0;i<12;i++){
            ArrayList temp=new ArrayList<Integer>();
            for(int j=0;j<chapterSize;j++){
                temp.add(8);
            }
            musicScore.add(temp);
        }
        //createSoundPoolIfNeeded();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=this.getWidth();
        int height=this.getHeight();
        int rectWidth=(height/7);
        int horizontalWidth=rectWidth;
        if(chapterSize==3){
            //horizontalWidth=rectWidth*4/3;
        }
        //paint.setColor(0xff229b77);
        paint.setColor(0xff888888);
        paint.setStrokeWidth(1);
        for(int i=0;i<9;i++){
            canvas.drawLine(0,i*(rectWidth)-rectWidth/2,width,i*(rectWidth)-rectWidth/2,paint);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xFFF44336);
        int sum=0;
        for(int i=0;i<musicScore.size();i++){
            for(int j=0;j<musicScore.get(i).size();j++) {
                //canvas.drawRect(sum*rectWidth,((8-musicScore.get(i).get(j))-1)*rectWidth,(sum+1)*rectWidth,((8-musicScore.get(i).get(j)))*rectWidth,paint);

                float verticalParam=((8-musicScore.get(i).get(j))-1);
                int musicScoreIndex=musicScore.get(i).get(j);
                if(musicScoreIndex>8){
                    if(musicScoreIndex==9){
                        verticalParam=0.5f;
                    }
                    if(musicScoreIndex==10){
                        verticalParam=1.5f;
                    }
                    if(musicScoreIndex==11){
                        verticalParam=2.5f;
                    }
                    if(musicScoreIndex==12){
                        verticalParam=4.5f;
                    }
                    if(musicScoreIndex==13){
                        verticalParam=5.5f;
                    }
                }
                if(verticalParam<=7){
                    musicScore.get(i).get(j);
                }
                if(sum*rectWidth+10<verticalLine&&verticalLine<(sum+1)*rectWidth+10){
                    if(imageMarkerFlags[i]==0){
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.quaver2),sum*horizontalWidth+10,verticalParam*rectWidth+10,paint);
                    }else{
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.quaver4),sum*horizontalWidth+10,verticalParam*rectWidth+10,paint);

                    }
                }else{
                    if(imageMarkerFlags[i]==0){
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.quaver),sum*horizontalWidth+10,verticalParam*rectWidth+10,paint);
                    }else{
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.quaver3),sum*horizontalWidth+10,verticalParam*rectWidth+10,paint);

                    }
                }
                sum++;
            }
        }


        paint.setColor(0xff229b77);
        sum=0;
        for(int i=0;i<musicScore.size();i++){
            paint.setStrokeWidth(1);
            for(int j=0;j<musicScore.get(i).size();j++){
                //canvas.drawLine(sum*(rectWidth),0,sum*(rectWidth),height,paint);
                sum++;
            }
            paint.setStrokeWidth(3);
            canvas.drawLine(sum*(rectWidth),0,sum*(rectWidth),height,paint);
        }


        if(topViews!=null){
            for(int i=0;i<musicScore.size();i++) {
                LinearLayout.LayoutParams linearParams=new LinearLayout.LayoutParams(musicScore.get(i).size()*rectWidth,topViews.get(i).getHeight());
                topViews.get(i).setLayoutParams(linearParams);
            }
        }

        if(bottomViews!=null){
            for(int i=0;i<musicScore.size();i++) {
                LinearLayout.LayoutParams linearParams=new LinearLayout.LayoutParams(musicScore.get(i).size()*rectWidth,bottomViews.get(i).getHeight());
                bottomViews.get(i).setLayoutParams(linearParams);
            }
        }


        paint.setColor(0xff00BCD4);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(sum*rectWidth,0,width,height,paint);
        paint.setColor(0xfffafafa);
        canvas.drawRect(0,rectWidth*7,width,height,paint);

        //paint.setColor(0xFF3F51B5);
        paint.setColor(0xff000000);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(verticalLine,0,verticalLine,height,paint);

    }

    private int actionDownIndex;
    private int actionDownHisNumber;
    private int hisNumberIndex=-1;
    private int actionMoveHisNumber;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getY()>=this.getHeight()){
            return true;
        }
        int pointerCount=event.getPointerCount();
        if(pointerCount==1){
            if(event.getAction()==MotionEvent.ACTION_DOWN||event.getAction()==MotionEvent.ACTION_MOVE){
                int x= (int) event.getX();
                int y= (int) event.getY();
                int height=this.getHeight();
                int rectWidth=(height/7);
                int col=x/rectWidth;
                int row=y/rectWidth;
                float rowF=1.0f*y/rectWidth;
                int sum=0;
                for (int i = 0; i < musicScore.size(); i++) {
                    for (int j = 0; j < musicScore.get(i).size(); j++) {
                        if(sum==col){
                            if(event.getAction()==MotionEvent.ACTION_DOWN){
                                actionDownIndex=i;
                                actionDownHisNumber= musicScore.get(i).get(j);
                            }else if(event.getAction()==MotionEvent.ACTION_MOVE){
                                actionMoveHisNumber= musicScore.get(i).get(j);
                            }
                            //startMusic?
                            //reStart Music ???
                            if(rowF>0.66&&rowF<1.33){
                                musicPlay(1,12);
                            }else if(rowF>1.66&&rowF<2.33){
                                musicPlay(1,11);
                            }else if(rowF>2.66&&rowF<3.33){
                                musicPlay(1,10);
                            }else if(rowF>4.66&&rowF<5.33){
                                musicPlay(1,9);
                            }else if(rowF>5.66&&rowF<6.33){
                                musicPlay(1,8);
                            }else{
                                musicPlay(1,7-row);
                            }
                          /*  if(!(((7-row)==actionDownHisNumber||(7-row)==actionMoveHisNumber)&&hisNumberIndex==(sum))){
                                if(actionDownHisNumber!=(7-row)){
                                    if(rowF>0.66&&rowF<1.33){
                                        musicPlay(13);
                                    }else if(rowF>1.66&&rowF<2.33){
                                        musicPlay(12);
                                    }else if(rowF>2.66&&rowF<3.33){
                                        musicPlay(11);
                                    }else if(rowF>4.66&&rowF<5.33){
                                        musicPlay(10);
                                    }else if(rowF>5.66&&rowF<6.33){
                                        musicPlay(9);
                                    }else{
                                        musicPlay(7-row);
                                    }
                                    hisNumberIndex=sum;
                                }
                            }else{
                                if(actionDownHisNumber==8&&hisNumberIndex!=sum){
                                    if(rowF>0.66&&rowF<1.33){
                                        musicPlay(13);
                                    }else if(rowF>1.66&&rowF<2.33){
                                        musicPlay(12);
                                    }else if(rowF>2.66&&rowF<3.33){
                                        musicPlay(11);
                                    }else if(rowF>4.66&&rowF<5.33){
                                        musicPlay(10);
                                    }else if(rowF>5.66&&rowF<6.33){
                                        musicPlay(9);
                                    }else{
                                        musicPlay(7-row);
                                    }
                                    hisNumberIndex=sum;
                                }
                            }*/



                            if(rowF>0.66&&rowF<1.33){
                                musicScore.get(i).set(j,9);
                            }else if(rowF>1.66&&rowF<2.33){
                                musicScore.get(i).set(j,10);
                            }else if(rowF>2.66&&rowF<3.33){
                                musicScore.get(i).set(j,11);
                            }else if(rowF>4.66&&rowF<5.33){
                                musicScore.get(i).set(j,12);
                            }else if(rowF>5.66&&rowF<6.33){
                                musicScore.get(i).set(j,13);
                            }else{
                                musicScore.get(i).set(j,7-row);
                            }


                            //musicScore.get(i).set(j,11);
                        }
                        sum++;
                    }
                }
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                int x= (int) event.getX();
                int y= (int) event.getY();
                int height=this.getHeight();
                int rectWidth=(height/7);
                int col=x/rectWidth;
                int row=y/rectWidth;
                int sum=0;
                for (int i = 0; i < musicScore.size(); i++) {
                    for (int j = 0; j < musicScore.get(i).size(); j++) {
                        if(sum==col){
                            if(actionDownIndex==i) {
                                if(musicScore.get(i).get(j)==actionDownHisNumber){
                                    musicScore.get(i).set(j, 8);
                                    actionMoveHisNumber=8;
                                }
                            }
                        }
                        sum++;
                    }
                }
            }
            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 创建SoundPool ，注意 api 等级
     */
    public static SoundPool mSoundPool;
    public static int [][] mSoundId={{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};


    @Override
    public void onLoadComplete(SoundPool soundPool, int i, int i1) {

    }

    private Handler scrollHandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what==9){
                MainActivity.startAnimation(msg.arg1);
            }else if(msg.what==10){
                if(msg.arg1==1){
                    //success
                    MainActivity.showPlayResult(1);
                }else if(msg.arg1==2){
                    //error
                    MainActivity.showPlayResult(2);
                }
            }else if(msg.what==99){
                MainActivity.playDone();
            }else{
                //super.handleMessage(msg);
                doublePointHorizontalScrollView.smoothScrollTo(verticalLine-100,0);
            }

        }
    };

    public int verticalLine=-5;
    private int speed=20;
    private int [] copyLoops={1,1,1,1,1,1,1,1,1,1,1,1};
    private boolean isPlaing=false;
    public class PlayMusic implements  Runnable{
        @Override
        public void run() {
            sleep(300);
            isPlaing=true;
            for (int i = 0; i < loops.length; i++) {
                copyLoops[i]=loops[i];
            }

            int historyNum=-999;
            for (verticalLine = -5>verticalLineHis?-5:verticalLineHis; verticalLine < getWidth()+10; verticalLine+=5) {
                scrollHandler.sendEmptyMessage(1);
                if(!isPlaing){
                    return;
                }
//                if(verticalLine%15==0){
//                musicDNAView.postInvalidate();
//                }
                postInvalidate();
                if(verticalLine/(getHeight()/7)!=historyNum){
                    historyNum=verticalLine/(getHeight()/7);
                    outerFor:for (int i = 0; i < musicScore.size(); i++) {
                        for (int j = 0; j < musicScore.get(i).size(); j++) {
                            if(historyNum==0){
                                if(j==musicScore.get(i).size()-1){

                                    if(copyLoops[i]>1){
                                        //show number  6-copyLoops[i]


                                        Message message=Message.obtain();
                                        message.what=9;
                                        message.arg1= loops[i]-copyLoops[i]+1;
                                        scrollHandler.sendMessage(message);

                                        copyLoops[i]--;
                                        int playNum=getPlayNumber(historyNum);
                                        int indexOne=getIndexOne(historyNum);
                                        if(playNum!=-1&&playNum!=8) {
                                            musicPlay(indexOne,playNum);
                                            //musicDNAView.setAmplitudeMultiple(6,150);
                                        }
                                        for (int k = 0; k < getHeight()/7; k+=5) {
                                            scrollHandler.sendEmptyMessage(1);
                                            verticalLine=verticalLine+5;
//                                    if(verticalLine%15==0){
//                                        musicDNAView.postInvalidate();
//                                    }
                                            invalidate();
                                            sleep(speed);
                                        }
                                        verticalLine-=musicScore.get(i).size()*(getHeight()/7);
                                    }else{
                                        if(loops[i]>1) {
                                            Message message = Message.obtain();
                                            message.what = 9;
                                            message.arg1 = loops[i];
                                            scrollHandler.sendMessage(message);
                                        }
                                    }
                                }
                                break outerFor;
                            }
                            historyNum--;
                        }
                    }
                    historyNum=verticalLine/(getHeight()/7);
                    int playNum=getPlayNumber(historyNum);
                    int indexOne=getIndexOne(historyNum);
                    if(playNum!=-1&&playNum!=8) {
                        if(playNum<8){
                            musicPlay(indexOne,playNum);
                        }else{
                            musicPlay(indexOne,21-playNum);
                        }
                        //musicDNAView.setAmplitudeMultiple(6,150);
                    }
                }
                sleep(speed);
            }
            musicDNAView.setAlpha(0);
            verticalLineHis=-10;
            verticalLine=-5;
            startClickNumber=1;
            if(modeFlag==1){


                boolean successFlag=true;
                for (int i = 0; i < musicScore.size(); i++) {
                    for (int j = 0; j < musicScore.get(i).size(); j++) {
                        if(musicScore.get(i).get(j)!=musicScoreStatic.get(i).get(j)){
                            successFlag=false;
                        }
                    }
                }
                Message msg=Message.obtain();
                msg.what=10;
                if(successFlag){
                    msg.arg1=1;
                }else{
                    msg.arg1=2;
                }
                scrollHandler.sendMessage(msg);
            }


            scrollHandler.sendEmptyMessage(99);
        }
    }

    public int startClickNumber=1;
    public int verticalLineHis=-10;
    public void start(){
        if(startClickNumber%2==1){
            musicDNAView.setAlpha(0.5f);
            isPlaing=false;
            invalidate();
            if(verticalLineHis==-10){
                doublePointHorizontalScrollView.smoothScrollTo(0,0);
            }
            new Thread(new PlayMusic()).start();
        }else{
            //pause
            verticalLineHis=verticalLine;
            isPlaing=false;
        }
        startClickNumber++;
    }


    private void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPlayNumber(int index){
        int sum=0;
        for (int i=0;i<musicScore.size();i++){
            for (int j=0;j<musicScore.get(i).size();j++){
                if(index==sum){
                    return musicScore.get(i).get(j);
                }
                sum++;

            }
        }
        return -1;
    }
    public int getIndexOne(int index){
        int sum=0;
        for (int i=0;i<rawIndexInOne.size();i++){
            for (int j=0;j<rawIndexInOne.get(i).size();j++){
                if(index==sum){
                    return rawIndexInOne.get(i).get(j);
                }
                sum++;
            }
        }
        return 0;
    }


    public void stop(){
        isPlaing=false;
    }

    public void  musicPlay(int indexOne,int num){
        num=num-1;
        if(num>=0&&num<mSoundId[indexOne].length){
            mSoundPool.play(mSoundId[indexOne][num], 0.5f, 0.5f, 0, 0, 1.0f);
        }
    }

}
