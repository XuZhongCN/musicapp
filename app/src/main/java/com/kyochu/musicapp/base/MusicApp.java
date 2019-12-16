package com.kyochu.musicapp.base;

import android.app.Application;

import com.kyochu.musicapp.db.InitDataToDB;

public class MusicApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new InitDataToDB().initDB(this);
    }
}
