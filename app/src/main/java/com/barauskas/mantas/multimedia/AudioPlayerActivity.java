package com.barauskas.mantas.multimedia;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class AudioPlayerActivity extends Activity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        String url ="http://sv50.onlinevideoconverter.com/download?file=e4e4h7h7g6g6h7c2";
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(View view) {
        mediaPlayer.start();
    }

    public void stop(View view) {
        mediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        mediaPlayer.release();
        mediaPlayer = null;

        super.onStop();
    }
}
