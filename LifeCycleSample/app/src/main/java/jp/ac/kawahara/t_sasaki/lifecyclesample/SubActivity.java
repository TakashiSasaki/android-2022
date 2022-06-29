package jp.ac.kawahara.t_sasaki.lifecyclesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("LifeCycleSample", "SubActivity#onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    @Override
    protected void onStart() {
        Log.i("LifeCycleSample", "SubActivity#onStart called.");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("LifeCycleSample", "SubActivity#onRestart called");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("LifeCycleSample", "SubActivity#onResume called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("LifeCycleSample", "SubActivity#onPause called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("LifeCycleSample", "SubActivity#onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("LifeCycleSample", "SubActivity#onDestroy");
        super.onDestroy();
    }

    public void onButtonClick(View view){
        finish();
        //Intent i = new Intent(this, MainActivity.class);
        //startActivity(i);
    }


}