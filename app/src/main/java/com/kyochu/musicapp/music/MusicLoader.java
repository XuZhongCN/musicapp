package com.kyochu.musicapp.music;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import com.kyochu.musicapp.R;

import static com.kyochu.musicapp.view.MusicScoreView.mSoundId;
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

            mSoundId[0][0] = mSoundPool.load(context, R.raw.r1_1, 1);
            mSoundId[0][1] = mSoundPool.load(context, R.raw.r1_2, 1);
            mSoundId[0][2] = mSoundPool.load(context, R.raw.r1_3, 1);
            mSoundId[0][3] = mSoundPool.load(context, R.raw.r1_4, 1);
            mSoundId[0][4] = mSoundPool.load(context, R.raw.r1_5, 1);
            mSoundId[0][5] = mSoundPool.load(context, R.raw.r1_6, 1);
            mSoundId[0][6] = mSoundPool.load(context, R.raw.r1_7, 1);
            mSoundId[0][7] = mSoundPool.load(context, R.raw.r1_1_5, 1);
            mSoundId[0][8] = mSoundPool.load(context, R.raw.r1_2_5, 1);
            mSoundId[0][9] = mSoundPool.load(context, R.raw.r1_4_5, 1);
            mSoundId[0][10] = mSoundPool.load(context, R.raw.r1_5_5, 1);
            mSoundId[0][11] = mSoundPool.load(context, R.raw.r1_6_5, 1);

            mSoundId[1][0] = mSoundPool.load(context, R.raw.r2_1, 1);
            mSoundId[1][1] = mSoundPool.load(context, R.raw.r2_2, 1);
            mSoundId[1][2] = mSoundPool.load(context, R.raw.r2_3, 1);
            mSoundId[1][3] = mSoundPool.load(context, R.raw.r2_4, 1);
            mSoundId[1][4] = mSoundPool.load(context, R.raw.r2_5, 1);
            mSoundId[1][5] = mSoundPool.load(context, R.raw.r2_6, 1);
            mSoundId[1][6] = mSoundPool.load(context, R.raw.r2_7, 1);
            mSoundId[1][7] = mSoundPool.load(context, R.raw.r2_1_5, 1);
            mSoundId[1][8] = mSoundPool.load(context, R.raw.r2_2_5, 1);
            mSoundId[1][9] = mSoundPool.load(context, R.raw.r2_4_5, 1);
            mSoundId[1][10] = mSoundPool.load(context, R.raw.r2_5_5, 1);
            mSoundId[1][11] = mSoundPool.load(context, R.raw.r2_6_5, 1);

            mSoundId[2][0] = mSoundPool.load(context, R.raw.r3_1, 1);
            mSoundId[2][1] = mSoundPool.load(context, R.raw.r3_2, 1);
            mSoundId[2][2] = mSoundPool.load(context, R.raw.r3_3, 1);
            mSoundId[2][3] = mSoundPool.load(context, R.raw.r3_4, 1);
            mSoundId[2][4] = mSoundPool.load(context, R.raw.r3_5, 1);
            mSoundId[2][5] = mSoundPool.load(context, R.raw.r3_6, 1);
            mSoundId[2][6] = mSoundPool.load(context, R.raw.r3_7, 1);
            mSoundId[2][7] = mSoundPool.load(context, R.raw.r3_1_5, 1);
            mSoundId[2][8] = mSoundPool.load(context, R.raw.r3_2_5, 1);
            mSoundId[2][9] = mSoundPool.load(context, R.raw.r3_4_5, 1);
            mSoundId[2][10] = mSoundPool.load(context, R.raw.r3_5_5, 1);
            mSoundId[2][11] = mSoundPool.load(context, R.raw.r3_6_5, 1);
        }
    }

}
