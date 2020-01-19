package com.kyochu.musicapp.music;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import com.kyochu.musicapp.R;

import static com.kyochu.musicapp.view.MusicScoreView.mSoundIdA;
import static com.kyochu.musicapp.view.MusicScoreView.mSoundIdB;

import static com.kyochu.musicapp.view.MusicScoreView.mSoundIdC;
import static com.kyochu.musicapp.view.MusicScoreView.mSoundPool;

public class MusicLoader{
    public static void createSoundPoolIfNeeded(Context context) {
        if (mSoundPool == null) {
            // 5.0 及 之后
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                AudioAttributes audioAttributes = null;
                audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();
                mSoundPool = new SoundPool.Builder()
                        .setMaxStreams(16)
                        .setAudioAttributes(audioAttributes)
                        .build();
            } else { // 5.0 以前
                mSoundPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 5);  // 创建SoundPool
            }
            //mSoundPool.setOnLoadCompleteListener(this);  // 设置加载完成监听

            mSoundIdA[0][0] = mSoundPool.load(context, R.raw.r1_1, 1);
            mSoundIdA[0][1] = mSoundPool.load(context, R.raw.r1_2, 1);
            mSoundIdA[0][2] = mSoundPool.load(context, R.raw.r1_3, 1);
            mSoundIdA[0][3] = mSoundPool.load(context, R.raw.r1_4, 1);
            mSoundIdA[0][4] = mSoundPool.load(context, R.raw.r1_5, 1);
            mSoundIdA[0][5] = mSoundPool.load(context, R.raw.r1_6, 1);
            mSoundIdA[0][6] = mSoundPool.load(context, R.raw.r1_7, 1);
            mSoundIdA[0][7] = mSoundPool.load(context, R.raw.r1_6_5, 1);
            mSoundIdA[0][8] = mSoundPool.load(context, R.raw.r1_5_5, 1);
            mSoundIdA[0][9] = mSoundPool.load(context, R.raw.r1_4_5, 1);
            mSoundIdA[0][10] = mSoundPool.load(context, R.raw.r1_2_5, 1);
            mSoundIdA[0][11] = mSoundPool.load(context, R.raw.r1_1_5, 1);

            mSoundIdA[1][0] = mSoundPool.load(context, R.raw.r2_1, 1);
            mSoundIdA[1][1] = mSoundPool.load(context, R.raw.r2_2, 1);
            mSoundIdA[1][2] = mSoundPool.load(context, R.raw.r2_3, 1);
            mSoundIdA[1][3] = mSoundPool.load(context, R.raw.r2_4, 1);
            mSoundIdA[1][4] = mSoundPool.load(context, R.raw.r2_5, 1);
            mSoundIdA[1][5] = mSoundPool.load(context, R.raw.r2_6, 1);
            mSoundIdA[1][6] = mSoundPool.load(context, R.raw.r2_7, 1);
            mSoundIdA[1][7] = mSoundPool.load(context, R.raw.r2_6_5, 1);
            mSoundIdA[1][8] = mSoundPool.load(context, R.raw.r2_5_5, 1);
            mSoundIdA[1][9] = mSoundPool.load(context, R.raw.r2_4_5, 1);
            mSoundIdA[1][10] = mSoundPool.load(context, R.raw.r2_2_5, 1);
            mSoundIdA[1][11] = mSoundPool.load(context, R.raw.r2_1_5, 1);

            mSoundIdA[2][0] = mSoundPool.load(context, R.raw.r3_1, 1);
            mSoundIdA[2][1] = mSoundPool.load(context, R.raw.r3_2, 1);
            mSoundIdA[2][2] = mSoundPool.load(context, R.raw.r3_3, 1);
            mSoundIdA[2][3] = mSoundPool.load(context, R.raw.r3_4, 1);
            mSoundIdA[2][4] = mSoundPool.load(context, R.raw.r3_5, 1);
            mSoundIdA[2][5] = mSoundPool.load(context, R.raw.r3_6, 1);
            mSoundIdA[2][6] = mSoundPool.load(context, R.raw.r3_7, 1);
            mSoundIdA[2][7] = mSoundPool.load(context, R.raw.r3_6_5, 1);
            mSoundIdA[2][8] = mSoundPool.load(context, R.raw.r3_5_5, 1);
            mSoundIdA[2][9] = mSoundPool.load(context, R.raw.r3_4_5, 1);
            mSoundIdA[2][10] = mSoundPool.load(context, R.raw.r3_2_5, 1);
            mSoundIdA[2][11] = mSoundPool.load(context, R.raw.r3_1_5, 1);

            mSoundIdB[0][0] = mSoundPool.load(context, R.raw.g1_1, 1);
            mSoundIdB[0][1] = mSoundPool.load(context, R.raw.g1_2, 1);
            mSoundIdB[0][2] = mSoundPool.load(context, R.raw.g1_3, 1);
            mSoundIdB[0][3] = mSoundPool.load(context, R.raw.g1_4, 1);
            mSoundIdB[0][4] = mSoundPool.load(context, R.raw.g1_5, 1);
            mSoundIdB[0][5] = mSoundPool.load(context, R.raw.g1_6, 1);
            mSoundIdB[0][6] = mSoundPool.load(context, R.raw.g1_7, 1);
            mSoundIdB[0][7] = mSoundPool.load(context, R.raw.g1_6_5, 1);
            mSoundIdB[0][8] = mSoundPool.load(context, R.raw.g1_5_5, 1);
            mSoundIdB[0][9] = mSoundPool.load(context, R.raw.g1_4_5, 1);
            mSoundIdB[0][10] = mSoundPool.load(context, R.raw.g1_2_5, 1);
            mSoundIdB[0][11] = mSoundPool.load(context, R.raw.g1_1_5, 1);

            mSoundIdB[1][0] = mSoundPool.load(context, R.raw.g2_1, 1);
            mSoundIdB[1][1] = mSoundPool.load(context, R.raw.g2_2, 1);
            mSoundIdB[1][2] = mSoundPool.load(context, R.raw.g2_3, 1);
            mSoundIdB[1][3] = mSoundPool.load(context, R.raw.g2_4, 1);
            mSoundIdB[1][4] = mSoundPool.load(context, R.raw.g2_5, 1);
            mSoundIdB[1][5] = mSoundPool.load(context, R.raw.g2_6, 1);
            mSoundIdB[1][6] = mSoundPool.load(context, R.raw.g2_7, 1);
            mSoundIdB[1][7] = mSoundPool.load(context, R.raw.g2_6_5, 1);
            mSoundIdB[1][8] = mSoundPool.load(context, R.raw.g2_5_5, 1);
            mSoundIdB[1][9] = mSoundPool.load(context, R.raw.g2_4_5, 1);
            mSoundIdB[1][10] = mSoundPool.load(context, R.raw.g2_2_5, 1);
            mSoundIdB[1][11] = mSoundPool.load(context, R.raw.g2_1_5, 1);

            mSoundIdB[2][0] = mSoundPool.load(context, R.raw.g3_1, 1);
            mSoundIdB[2][1] = mSoundPool.load(context, R.raw.g3_2, 1);
            mSoundIdB[2][2] = mSoundPool.load(context, R.raw.g3_3, 1);
            mSoundIdB[2][3] = mSoundPool.load(context, R.raw.g3_4, 1);
            mSoundIdB[2][4] = mSoundPool.load(context, R.raw.g3_5, 1);
            mSoundIdB[2][5] = mSoundPool.load(context, R.raw.g3_6, 1);
            mSoundIdB[2][6] = mSoundPool.load(context, R.raw.g3_7, 1);
            mSoundIdB[2][7] = mSoundPool.load(context, R.raw.g3_6_5, 1);
            mSoundIdB[2][8] = mSoundPool.load(context, R.raw.g3_5_5, 1);
            mSoundIdB[2][9] = mSoundPool.load(context, R.raw.g3_4_5, 1);
            mSoundIdB[2][10] = mSoundPool.load(context, R.raw.g3_2_5, 1);
            mSoundIdB[2][11] = mSoundPool.load(context, R.raw.g3_1_5, 1);



            mSoundIdC[0][0] = mSoundPool.load(context, R.raw.d1_1, 1);
            mSoundIdC[0][1] = mSoundPool.load(context, R.raw.d1_2, 1);
            mSoundIdC[0][2] = mSoundPool.load(context, R.raw.d1_3, 1);
            mSoundIdC[0][3] = mSoundPool.load(context, R.raw.d1_4, 1);
            mSoundIdC[0][4] = mSoundPool.load(context, R.raw.d1_5, 1);
            mSoundIdC[0][5] = mSoundPool.load(context, R.raw.d1_6, 1);
            mSoundIdC[0][6] = mSoundPool.load(context, R.raw.d1_7, 1);
            mSoundIdC[0][7] = mSoundPool.load(context, R.raw.d1_6_5, 1);
            mSoundIdC[0][8] = mSoundPool.load(context, R.raw.d1_5_5, 1);
            mSoundIdC[0][9] = mSoundPool.load(context, R.raw.d1_4_5, 1);
            mSoundIdC[0][10] = mSoundPool.load(context, R.raw.d1_2_5, 1);
            mSoundIdC[0][11] = mSoundPool.load(context, R.raw.d1_1_5, 1);

            mSoundIdC[1][0] = mSoundPool.load(context, R.raw.d2_1, 1);
            mSoundIdC[1][1] = mSoundPool.load(context, R.raw.d2_2, 1);
            mSoundIdC[1][2] = mSoundPool.load(context, R.raw.d2_3, 1);
            mSoundIdC[1][3] = mSoundPool.load(context, R.raw.d2_4, 1);
            mSoundIdC[1][4] = mSoundPool.load(context, R.raw.d2_5, 1);
            mSoundIdC[1][5] = mSoundPool.load(context, R.raw.d2_6, 1);
            mSoundIdC[1][6] = mSoundPool.load(context, R.raw.d2_7, 1);
            mSoundIdC[1][7] = mSoundPool.load(context, R.raw.d2_6_5, 1);
            mSoundIdC[1][8] = mSoundPool.load(context, R.raw.d2_5_5, 1);
            mSoundIdC[1][9] = mSoundPool.load(context, R.raw.d2_4_5, 1);
            mSoundIdC[1][10] = mSoundPool.load(context, R.raw.d2_2_5, 1);
            mSoundIdC[1][11] = mSoundPool.load(context, R.raw.d2_1_5, 1);
        }
    }

}
