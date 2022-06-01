package jp.ac.kawahara.t_sasaki.hellosample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.btClick);

        //HelloListener l = new HelloListener();

        //無名クラスを使った書き方
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.YELLOW);
                //v.setVisibility(View.INVISIBLE);
                EditText input = findViewById(R.id.etName);
                TextView output = findViewById(R.id.tvOutput);
                String inputStr = input.getText().toString();
                output.setText(inputStr + "さん、こんにちは");
            }
        });
    }//onCreate

    /*
    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText input = findViewById(R.id.etName);
            TextView output = findViewById(R.id.tvOutput);
            String inputStr = input.getText().toString();
            output.setText(inputStr + "さん、こんにちは");
        }//onClick
    }//View.OnClickListener
    */
}