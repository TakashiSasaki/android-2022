package jp.ac.kawahara.t_sasaki.lifecyclesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("LifeCycleSample", "MainActivity#onCreate called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.i("LifeCycleSample", "MainActivity#onStart called.");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("LifeCycleSample", "MainActivity#onRestart called");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("LifeCycleSample", "MainActivity#onResume called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("LifeCycleSample", "MainActivity#onPause called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("LifeCycleSample", "MainActivity#onStop called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("LifeCycleSample", "MainActivity#onDestroy called");
        super.onDestroy();
    }

    public void onButtonClick(View view) {
        final Intent i =
                new Intent(MainActivity.this, SubActivity.class);
        startActivity(i);
    }

}