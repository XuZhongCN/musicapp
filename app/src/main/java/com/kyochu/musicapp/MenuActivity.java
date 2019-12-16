package com.kyochu.musicapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kyochu.musicapp.db.DBHelper;
import com.kyochu.musicapp.db.DMLHelper;
import com.kyochu.musicapp.pojo.Music;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private List<Music> musicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title bar  即隐藏标题栏
        getSupportActionBar().hide();// 隐藏ActionBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity_menu);
        musicList=new DMLHelper(this).findMusicAll();
    }
    public void onClick(View view){
        showNoneEffect();
    }
    private   PopupWindow popupWindow;
    private View.OnClickListener onTextViewClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LinearLayout linearLayout=(LinearLayout) view.getParent();
            for(int i=0;i<linearLayout.getChildCount();i++){
                ((RadioButton)((LinearLayout)linearLayout.getChildAt(i)).getChildAt(0)).setChecked(false);
                ((LinearLayout)(linearLayout.getChildAt(i))).getChildAt(1).findViewById(R.id.icon_item).setAlpha(0f);
            }
            //Toast.makeText(MenuActivity.this, "111", Toast.LENGTH_SHORT).show();
            ((RadioButton)((LinearLayout) view).getChildAt(0)).setChecked(true);
            ((LinearLayout) view).findViewById(R.id.icon_item).setAlpha(1f);
        }
    };
    private LinearLayout linearLayout;
    //无任何效果的弹窗
    private void showNoneEffect() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vPopupWindow = inflater.inflate(R.layout.select_lesson, null, false);//引入弹窗布局
        linearLayout=vPopupWindow.findViewById(R.id.radioLinearLayout);
        for (int i = 0; i < musicList.size(); i++) {
           View view= LayoutInflater.from(this).inflate(R.layout.select_lesson_item,linearLayout,false);
           TextView textView= view.findViewById(R.id.radioButton);
            textView.setText("lesson "+(i+1)+":"+musicList.get(i).getName());
           linearLayout.addView(view);
        }
        for(int i=0;i<linearLayout.getChildCount();i++){
            //.getChildAt(0)
            (((LinearLayout)linearLayout.getChildAt(i))).setOnClickListener(onTextViewClickListener);
            (((LinearLayout)linearLayout.getChildAt(i)).getChildAt(0)).setClickable(false);
//            final int finalI = i;
//            (linearLayout.getChildAt(i)).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ((LinearLayout)view).getChildAt(finalI).performClick();
//                }
//            });
        }
        popupWindow = new PopupWindow(vPopupWindow, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        //引入依附的布局
        View parentView = LayoutInflater.from(MenuActivity.this).inflate(R.layout.select_lesson, null);
        //相对于父控件的位置（例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
        popupWindow.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
    }

    public void onOKClick(View view){
        Intent intent=new Intent();
        for(int i=0;i<linearLayout.getChildCount();i++){
            if(((RadioButton)((LinearLayout)linearLayout.getChildAt(i)).getChildAt(0)).isChecked()){
                intent.putExtra("musicIndex",i);
            }
        }
        if(intent.getIntExtra("musicIndex",-1)==-1){
            Toast.makeText(this, "Select an item please.", Toast.LENGTH_SHORT).show();
            return ;
        }
        intent.setClass(this, MainActivity.class);
        // ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        startActivity(intent);
        //popupWindow.dismiss();
    }
    public void onCancelClick(View view){
        popupWindow.dismiss();
    }
}
