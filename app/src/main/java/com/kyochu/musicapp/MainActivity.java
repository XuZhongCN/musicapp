package com.kyochu.musicapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.kyochu.musicapp.db.DMLHelper;
import com.kyochu.musicapp.pojo.Music;
import com.kyochu.musicapp.view.DoublePointHorizontalScrollView;
import com.kyochu.musicapp.view.MusicScoreView;
import com.kyochu.musicapp.view.TouchBarView;
import com.scwang.wave.MultiWaveHeader;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private static int [] numberPngId={R.drawable.number0,R.drawable.number1,R.drawable.number2,R.drawable.number3,R.drawable.number4,R.drawable.number5};
    private MusicScoreView musicScoreView=null;
    private MultiWaveHeader musicDNAView=null;
    private DoublePointHorizontalScrollView doublePointHorizontalScrollView=null;
    private List<View> topViews=new ArrayList<>();
    private List<View> bottomViews=new ArrayList<>();
    private int musicIndex=-1;

    public static void playDone() {
        ((ImageView)startView).setImageResource(R.drawable.start);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicIndex=getIntent().getIntExtra("musicIndex",-1);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title bar  即隐藏标题栏
        getSupportActionBar().hide();// 隐藏ActionBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity_main);
        musicScoreView=findViewById(R.id.musicScoreView);
        musicDNAView=findViewById(R.id.musicDNAView);
        musicScoreView.setMusicDNAView(musicDNAView);
        showLoopNumberImageView=findViewById(R.id.showLoopNumberImageView);
        playResult=findViewById(R.id.playResult);
        doublePointHorizontalScrollView=findViewById(R.id.doublePointHorizontalScrollView);
        musicScoreView.setDoublePointHorizontalScrollView(doublePointHorizontalScrollView);
        ((TouchBarView)findViewById(R.id.leftTouchBar)).setHorizontalScrollView(doublePointHorizontalScrollView);
        ((TouchBarView)findViewById(R.id.rightTouchBar)).setHorizontalScrollView(doublePointHorizontalScrollView);
        ((TouchBarView)findViewById(R.id.leftTouchBar)).setFlag(0);
        ((TouchBarView)findViewById(R.id.rightTouchBar)).setFlag(1);
        musicDNAView.setAlpha(0);
        musicDNAView.setStartColor(0xffffffff);
        musicDNAView.setCloseColor(0xff444444);
        musicDNAView.setColorAlpha(.5f);
        musicDNAView.setWaveHeight(100);
        musicDNAView.setGradientAngle(90);
//        musicDNAView.setProgress(.2f);
        musicDNAView.setVelocity(8f);
//        musicDNAView.setScaleY(-1f);
//        musicDNAView.setWaves("PairWave");
        musicDNAView.start();
//        musicDNAView.stop();
//        musicDNAView.isRunning();


        //init TopViews
        initTopViews();


        //Init BottomViews
        initBottomViews();




        musicScoreView.postInvalidate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(1);
            }
        }).start();


        AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1f);
        ScaleAnimation scaleAnimation=new ScaleAnimation(0.5f,1.0f,0.5f,1.0f);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setDuration(1200);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                showLoopNumberImageView.setAlpha(1f);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showLoopNumberImageView.setAlpha(0f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private static ImageView showLoopNumberImageView=null;
    private static ImageView playResult=null;
    public static void startAnimation(int index){
        showLoopNumberImageView.setImageResource(numberPngId[index]);
        showLoopNumberImageView.startAnimation(animationSet);
    }
    public static void showPlayResult(int state){
        if(state==1){
            playResult.setImageResource(R.drawable.result1);
        }else if(state==2){
            playResult.setImageResource(R.drawable.result2);
        }else if(state==0){
            //playResult.setAlpha(0f);
        }
        AlphaAnimation alphaAnimation=new AlphaAnimation(0.3f,1f);
        ScaleAnimation scaleAnimation=new ScaleAnimation(0.5f,1.5f,0.5f,1.5f);
        AnimationSet animationSet=new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setDuration(1500);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                playResult.setAlpha(1f);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                playResult.setAlpha(0f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        playResult.startAnimation(animationSet);
    }


    private static AnimationSet animationSet=new AnimationSet(true);
    private void initBottomViews() {
        LinearLayout bottomLayout=findViewById(R.id.bottomViews);
        for (int i=1;i<bottomLayout.getChildCount();i++){
            LinearLayout temp= (LinearLayout) bottomLayout.getChildAt(i);
            temp.getChildAt(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  TextView textView= (TextView) ((LinearLayout) view.getParent()).getChildAt(1);
                  String str=textView.getText().toString();
                  Integer value=Integer.parseInt(str);
                  if(value>1) {
                      textView.setText((value-1) + "");
                      int setLoopIndex=((LinearLayout) view.getParent().getParent()).indexOfChild((View)(view.getParent()));
                      musicScoreView.setLoop(setLoopIndex,value-1);
                  }
                }
            });
            temp.getChildAt(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView textView= (TextView) ((LinearLayout) view.getParent()).getChildAt(1);
                    String str=textView.getText().toString();
                    Integer value=Integer.parseInt(str);
                    if(value<5){
                        textView.setText((value+1)+"");
                        int setLoopIndex=((LinearLayout) view.getParent().getParent()).indexOfChild((View)(view.getParent()));
                        musicScoreView.setLoop(setLoopIndex,value+1);
                    }
                }
            });
            bottomViews.add(bottomLayout.getChildAt(i));
        }
        musicScoreView.setBottomViews(bottomViews);
    }
    private String [] spinnerStrings=new String [] {"A","B"};
    private AdapterView.OnItemSelectedListener onItemClickListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int selectNum, long l) {
            //i==1
//            int index=topViews.indexOf(adapterView);
//            List<Integer> temp=new ArrayList<Integer>();
//            for (int k=0;k<i+3;k++){
//                temp.add(8);
//            }
//            musicScoreView.getMusicScore().set(index,temp);
//            musicScoreView.invalidate();
            int [] selectResult={0,0,0,0,0,0,0,0,0,0,0,0};
            for(int i=0;i<topViews.size();i++){
                Spinner spinner= (Spinner) topViews.get(i);
                selectResult[i]=spinner.getSelectedItemPosition();

            }
            musicScoreView.setImageMarkerFlags(selectResult);

        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    private void initTopViews() {
        LinearLayout topLayout=findViewById(R.id.topLinearLayout);
        for (int i=0;i<topLayout.getChildCount();i++){
            topViews.add(topLayout.getChildAt(i));
        }
        musicScoreView.setTopViews(topViews);
        for(int i=0;i<topViews.size();i++){
            Spinner spinner= (Spinner) topViews.get(i);
            spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.spinner_item_main,spinnerStrings));
            spinner.setOnItemSelectedListener(onItemClickListener);
            spinner.setSelection(0);
        }
        //Music music= new DMLHelper(this).findMusicById(musicIndex+1);
        Spinner beat=((Spinner)findViewById(R.id.beat));
        beat.setAdapter(new ArrayAdapter<String>(this,R.layout.spinner_item_main,new String[]{"3/3","4/4"}));
        beat.setSelection(0);
        beat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                musicScoreView.setChapterSize(position+3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    musicScoreView.setData(musicIndex+1);
                    musicDNAView.postInvalidate();
                    break;
                case 2:
                    isClick=false;
                    break;
            }
        }
    };
    @Override
    protected void onResume() {
        super.onResume();
    }
    private boolean isClick=false;
    private static View startView=null;
    public void startMusicPlay(View view){
        startView=view;


        playResult.setAlpha(0f);
        if(!isClick) {
            musicScoreView.start();
            isClick=true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        handler.sendEmptyMessage(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            if(musicScoreView.startClickNumber%2==1){
                ((ImageView)view).setImageResource(R.drawable.start);
            }else{
                ((ImageView)view).setImageResource(R.drawable.pause);
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();

        musicScoreView.stop();
    }

    public void changedMode(View view) {
        playResult.setAlpha(0f);
        for (int i = 0; i < bottomViews.size(); i++) {
            ((TextView)((LinearLayout)(bottomViews.get(i))).getChildAt(1)).setText("1");
        }
        for (int i = 1; i < 9; i++) {
            musicScoreView.setLoop(i,1);
        }


        if(musicScoreView.getModeFlag()==1){
            musicScoreView.setModeFlag(0);
            ((ImageView)view).setImageResource(R.drawable.llgray);
        }else{
            musicScoreView.setModeFlag(1);
            ((ImageView)view).setImageResource(R.drawable.ll);
        }
    }

    public void goToLeft(View view) {
        if(musicScoreView.startClickNumber%2==1) {
            musicDNAView.setAlpha(0);
            musicScoreView.verticalLineHis = -10;
            musicScoreView.verticalLine = -5;
            musicScoreView.startClickNumber = 1;
            ((ImageView) startView).setImageResource(R.drawable.start);
            musicScoreView.postInvalidate();
            doublePointHorizontalScrollView.smoothScrollTo(0,0);
        }
    }
}
