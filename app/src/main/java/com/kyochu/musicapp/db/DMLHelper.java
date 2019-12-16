package com.kyochu.musicapp.db;

import android.content.Context;
import android.database.Cursor;

import com.kyochu.musicapp.pojo.Music;
import com.kyochu.musicapp.pojo.MusicScore;

import java.util.ArrayList;
import java.util.List;

public class DMLHelper {
    private DBHelper dbHelper;

    public DMLHelper(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public List<Music> findMusicAll(){
        Cursor cursor=dbHelper.getReadableDatabase().rawQuery("select _id,name,section_size,beat from music order by _id;",new String []{});
        List<Music> musicList=new ArrayList<>();
        if(cursor.getCount()>0){
            for (;cursor.moveToNext();) {
                Music music=new Music();
                music.set_id(cursor.getInt(0));
                music.setName(cursor.getString(1));
                music.setSectionSize(cursor.getInt(2));
                music.setBeat(cursor.getString(3));
                musicList.add(music);
            }
        }
        return musicList;
    }

    public Music findMusicById(int id){
        Cursor cursor=dbHelper.getReadableDatabase().rawQuery("select _id,name,section_size,beat from music where _id=?",new String []{id+""});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            Music music=new Music();
            music.set_id(cursor.getInt(0));
            music.setName(cursor.getString(1));
            music.setSectionSize(cursor.getInt(2));
            music.setBeat(cursor.getString(3));
            return music;
        }
        return null;
    }

    public List<MusicScore> findMusicScoreByMusicId(int select_music_id){
        Cursor cursor=dbHelper.getReadableDatabase().rawQuery("select _id,music_id,order_num,score from music_score where music_id=? order by order_num",new String []{select_music_id+""});
        List<MusicScore> musicScores=new ArrayList<>();
        if(cursor.getCount()>0){
            for (;cursor.moveToNext();) {
                int _id=cursor.getInt(0);
                int music_id=cursor.getInt(1);
                int order_num=cursor.getInt(2);
                int score=cursor.getInt(3);
                MusicScore musicScore=new MusicScore();
                musicScore.set_id(_id);
                musicScore.setMusic_id(music_id);
                musicScore.setOrder_num(order_num);
                musicScore.setScore(score);
                musicScores.add(musicScore);
            }
        }
        return musicScores;
    }

    public void exec(String sql){
        dbHelper.getWritableDatabase().execSQL(sql);
    }
}
