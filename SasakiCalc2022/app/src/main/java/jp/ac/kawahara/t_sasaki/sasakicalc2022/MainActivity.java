package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener numberButClickListener = new NumberButtonClickListener();
        findViewById(R.id.bt0).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt1).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt2).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt3).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt4).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt5).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt6).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt7).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt8).setOnClickListener(numberButClickListener);
        findViewById(R.id.bt9).setOnClickListener(numberButClickListener);

    }

    class NumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            final Button b = (Button)v;
            final String s = b.getText().toString();

            final TextView tvArg1 = (TextView)findViewById(R.id.tvArg1);
            final String arg1 = tvArg1.getText().toString();

            tvArg1.setText(arg1 + s);
        }
    }
}