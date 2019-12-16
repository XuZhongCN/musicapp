package com.kyochu.musicapp.db;

import android.content.Context;

import java.util.List;

import static com.kyochu.musicapp.db.DBHelper.TABLE_MUSICINFO;
import static com.kyochu.musicapp.db.DBHelper.TABLE_MUSICSCOREINFO;

public class InitDataToDB {
    public static final int version=1;
    public static final String [] insertString=new String [] {
            "insert into MUSIC(_id,name,section_size,beat) values(1,'Twinkle Twinkle Little Star',4,'4/4');",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,1,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,2,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,3,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,4,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,5,6);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,6,6);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,7,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,8,8);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,9,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,10,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,11,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,12,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,13,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,14,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,15,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,16,8);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,17,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,18,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,19,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,20,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,21,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,22,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,23,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,24,8);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,25,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,26,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,27,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,28,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,29,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,30,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,31,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(1,32,8);",
            "insert into MUSIC(_id,name,section_size,beat) values(2,'Frère Jacques',4,'4/4');",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,1,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,2,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,3,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,4,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,5,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,6,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,7,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,8,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,9,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,10,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,11,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,12,8);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,13,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,14,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,15,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,16,8);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,17,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,18,6);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,19,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,20,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,21,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,22,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,23,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,24,6);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,25,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,26,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,27,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,28,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,29,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,30,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,31,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,32,8);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,33,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,34,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,35,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(2,36,8);",
            "insert into MUSIC(_id,name,section_size,beat) values(3,'Ode an die Freude',4,'4/4');",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,1,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,2,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,3,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,4,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,5,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,6,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,7,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,8,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,9,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,10,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,11,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,12,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,13,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,14,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,15,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,16,8);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,17,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,18,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,19,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,20,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,21,5);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,22,4);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,23,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,24,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,25,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,26,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,27,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,28,3);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,29,2);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,30,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,31,1);",
            "insert into MUSIC_SCORE(music_id,order_num,score) values(3,32,8);"
    };
    public void initDB(Context context){
        DMLHelper dmlHelper=new DMLHelper(context);
        List list=dmlHelper.findMusicAll();
        if(list.size()>0){
            return;
        }
        dmlHelper.exec("DELETE FROM "+ TABLE_MUSICINFO);
        dmlHelper.exec("DELETE FROM "+ TABLE_MUSICSCOREINFO);
        for (int i = 0; i < insertString.length; i++) {
            dmlHelper.exec(insertString[i]);
        }
    }
}
