package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public TextView tvArg1, tvArg2, tvArg3, tvOp1, tvOp2, tvCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvArg1 = findViewById(R.id.tvArg1);
        tvArg2 = findViewById(R.id.tvArg2);
        tvArg3 = findViewById(R.id.tvArg3);
        tvOp1 = findViewById(R.id.tvOp1);
        tvOp2 = findViewById(R.id.tvOp2);
        tvCondition = findViewById(R.id.tvCondition);


        View.OnClickListener numberButtonClickListener = new NumberButtonClickListener(this);
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

        View.OnClickListener operatorButtonClickListener = new OperatorButtonClickListener(this);
        findViewById(R.id.btAdd).setOnClickListener(operatorButtonClickListener);
        findViewById(R.id.btSub).setOnClickListener(operatorButtonClickListener);
        findViewById(R.id.btMul).setOnClickListener(operatorButtonClickListener);
        findViewById(R.id.btDiv).setOnClickListener(operatorButtonClickListener);

        findViewById(R.id.btCA).setOnClickListener(new CaButtonClickListener(this));
        findViewById(R.id.btEq).setOnClickListener(new EqButtonClickListener(this));

        View.OnClickListener signButtonClickListener = new SignButtonClickListener(this);
        findViewById(R.id.btSign1).setOnClickListener(signButtonClickListener);
        findViewById(R.id.btSign2).setOnClickListener(signButtonClickListener);
        findViewById(R.id.btSign3).setOnClickListener(signButtonClickListener);
    }

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

}