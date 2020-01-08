package com.kyochu.musicapp.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //***DataBase Name
    private static  final String DATABASE_NAME = "MusicApp.db";
    //DATABASE VERSION
    private static final int DATABASE_VERSION=10;

    public static final  String TABLE_MUSICINFO="MUSIC";
    public static final String TABLE_MUSICSCOREINFO="MUSIC_SCORE";


    private static final String CREATE_MUSICINFO_SQL="CREATE TABLE "
            + TABLE_MUSICINFO
            + " (_id Integer primary key autoincrement,"
            + " name varchar(255),"
            + " section_size Integer,"
            + " beat varchar(10))"+";";

    private static final String CREATE_MUSICSCOREINFO_SQL="CREATE TABLE "
            + TABLE_MUSICSCOREINFO
            + " (_id Integer primary key autoincrement,"
            + " music_id integer,"
            + " order_num integer,"
            + " score integer);";

    public DBHelper (Context context)
    {
        this(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MUSICINFO_SQL);
        db.execSQL(CREATE_MUSICSCOREINFO_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSICINFO);
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSICSCOREINFO);
            onCreate(db);
        }
    }
}

