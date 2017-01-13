package com.dev.viktorg.soundsofnature.service;

import android.content.Context;
import android.media.MediaPlayer;

import com.dev.viktorg.soundsofnature.model.Model;

public class MediaPlayerService {
    private static MediaPlayer mPlayer;

    public static void stopMusic() {
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }

    public static void playMusicOfEntity(final Context context, final Model model) {
        final int[] i = {0};
        mPlayer = MediaPlayer.create(context, model.getAudioIds().get(i[0]++));
        mPlayer.start();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (i[0] < model.getAudioIds().size()) {
                    mPlayer = MediaPlayer.create(context, model.getAudioIds().get(i[0]++));
                    mPlayer.start();
                }
            }
        });
    }

    public static void playMusicById(Context context, int id) {
        mPlayer = MediaPlayer.create(context, id);
        mPlayer.start();
    }
}
