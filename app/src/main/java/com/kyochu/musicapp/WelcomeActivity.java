package com.kyochu.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;

import com.kyochu.musicapp.db.InitDataToDB;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window _window;
        _window = getWindow();
        WindowManager.LayoutParams params = _window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;;
        _window.setAttributes(params);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title bar  即隐藏标题栏

        getSupportActionBar().hide();// 隐藏ActionBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏

//        getWindow().
//         welcome_anim = TransitionInflater.from(this).inflateTransition(R.anim.welcome_anim);
//        //退出时使用
//        getWindow().setExitTransition(welcome_anim);
//        //第一次进入时使用
//        getWindow().setEnterTransition(welcome_anim);
//        //再次进入时使用
//        getWindow().setReenterTransition(welcome_anim);
        setContentView(R.layout.activity_welcome);

    }

    public void onClick(View view){
        Intent intent=new Intent();
        intent.setClass(this, MenuActivity.class);
        // ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        startActivity(intent);
        this.finish();
    }
}
