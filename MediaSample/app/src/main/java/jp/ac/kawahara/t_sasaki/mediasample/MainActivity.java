package jp.ac.kawahara.t_sasaki.mediasample;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer _player;
    SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri mediaFileUri = Uri.parse(
                "android.resource://" + getPackageName()
                        + "/" + R.raw.movie
        );//parse

        _player = new MediaPlayer();
        try {
            _player.setDataSource(MainActivity.this, mediaFileUri);
            _player.setOnPreparedListener(new PlayerPreparedListener());
            _player.setOnCompletionListener(new PlayerCompletionListener());
            _player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("MediaSample", "しっぱいした", e);
        }

        ((SwitchMaterial) findViewById(R.id.swLoop))
                .setOnCheckedChangeListener(
                        (buttonView, isChecked)
                                -> _player.setLooping(isChecked)
                );

        SurfaceView surfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                _player.setDisplay(holder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

    }//onCreate method

    @Override
    protected void onDestroy() {
        if (_player.isPlaying()) {
            _player.stop();
        }//if
        _player.release();
        _player = null;
        super.onDestroy();
    }//onDestroy

    private class PlayerPreparedListener
            implements MediaPlayer.OnPreparedListener {

        @Override
        public void onPrepared(MediaPlayer mp) {
            findViewById(R.id.btBack).setEnabled(true);
            findViewById(R.id.btForward).setEnabled(true);
            findViewById(R.id.btPlay).setEnabled(true);
        }//onPrepared method
    }//PlayerPreparedListener class

    private class PlayerCompletionListener
            implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            ((Button) findViewById(R.id.btPlay))
                    .setText(R.string.bt_play_play);
        }//onCompletion method
    }//PlayerCompletionListener class

    public void onPlayButtonClick(View view) {
        Button btPlay = findViewById(R.id.btPlay);
        if (_player.isPlaying()) {
            _player.pause();
            btPlay.setText(R.string.bt_play_play);
        } else {
            _player.start();
            btPlay.setText(R.string.bt_play_pause);
        }//if
    }//onPlayButtonClick method

    public void onForwardButtonClick(View view) {
        int duration = _player.getDuration();
        _player.seekTo(duration);
        if (!_player.isPlaying()) {
            _player.start();
        }//if
    }//onForwardButtonClick method

    public void onBackButtonClick(View view) {
        _player.seekTo(0);
    }//onBackButtonClick method

}//MainActivity class