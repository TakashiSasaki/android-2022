package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tvArg1, tvArg2, tvArg3, tvOp1, tvOp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvArg1 = findViewById(R.id.tvArg1);
        tvArg2 = findViewById(R.id.tvArg2);
        tvArg3 = findViewById(R.id.tvArg3);
        tvOp1 = findViewById(R.id.tvOp1);
        tvOp2 = findViewById(R.id.tvOp2);


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

        findViewById(R.id.btCA).setOnClickListener(new CaButtonClickListener());
    }

    class NumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            final Button b = (Button) v;
            final String s = b.getText().toString();

            if (isEmpty(tvOp1)) {
                if (isZero(tvArg1)) {
                    tvArg1.setText(s);
                } else {
                    appendString(tvArg1, s);
                }
            } else {
                if (isZero(tvArg2)) {
                    tvArg2.setText(s);
                } else {
                    appendString(tvArg2, s);
                }
            }
        }
    }//NumberButtonClickListener

    @SuppressLint("SetTextI18n")
    void appendString(TextView tv, String s) {
        tv.setText(tv.getText().toString() + s);
    }

    boolean isEmpty(TextView tv) {
        return tv.getText().toString().length() == 0;
    }

    boolean isZero(TextView tv) {
        return tv.getText().toString().equals("0");
    }

    class OperatorButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (!isEmpty(tvArg1)) {
                final Button b = (Button) v;
                final TextView tvOp1 = findViewById(R.id.tvOp1);
                tvOp1.setText(b.getText().toString());
            }
        }
    }

    class CaButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            tvArg1.setText("");
            tvArg2.setText("");
            tvArg3.setText("");
            tvOp1.setText("");
            tvOp2.setText("");
        }
    }
}