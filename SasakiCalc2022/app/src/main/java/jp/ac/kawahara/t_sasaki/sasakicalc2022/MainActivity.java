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

        View.OnClickListener numberButtonClickListener = new NumberButtonClickListener();
        findViewById(R.id.bt0).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt1).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt2).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt3).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt4).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt5).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt6).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt7).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt8).setOnClickListener(numberButtonClickListener);
        findViewById(R.id.bt9).setOnClickListener(numberButtonClickListener);

        View.OnClickListener operatorButtonClickListener = new OperatorButtonClickListener();
        findViewById(R.id.btAdd).setOnClickListener(operatorButtonClickListener);
        findViewById(R.id.btSub).setOnClickListener(operatorButtonClickListener);
        findViewById(R.id.btMul).setOnClickListener(operatorButtonClickListener);
        findViewById(R.id.btDiv).setOnClickListener(operatorButtonClickListener);

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
    }//NumberButtonClickListener

    class OperatorButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            final Button b = (Button)v;
            final TextView tvOp1 = findViewById(R.id.tvOp1);
            tvOp1.setText(b.getText().toString());
        }
    }


}