package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private TextView tvArg1, tvArg2, tvArg3, tvOp1, tvOp2, tvCondition;

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
        findViewById(R.id.btEq).setOnClickListener(new EqButtonClickListener());

        View.OnClickListener signButtonClickListener = new SignButtonClickListener();
        findViewById(R.id.btSign1).setOnClickListener(signButtonClickListener);
        findViewById(R.id.btSign2).setOnClickListener(signButtonClickListener);
        findViewById(R.id.btSign3).setOnClickListener(signButtonClickListener);
    }

    class NumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            final Button b = (Button) v;
            final String s = b.getText().toString();

            if (isEmpty(tvOp1)) {
                if (isZero(tvArg1)) {
                    tvArg1.setText(s);
                } else if (tvCondition.getText().toString().equals(getString(R.string.conditionOk))) {
                    tvArg1.setText(s);
                    tvCondition.setText("");
                } else {
                    appendString(tvArg1, s);
                }
            } else {
                if (isZero(tvArg2)) {
                    tvArg2.setText(s);
                } else if (tvCondition.getText().toString().equals(getString(R.string.conditionOk))) {
                    tvArg2.setText(s);
                    tvCondition.setText("");
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
            if (isEmpty(tvArg1)) {
                //
            } else if (isEmpty(tvOp1)) {
                final Button b = (Button) v;
                final TextView tvOp1 = findViewById(R.id.tvOp1);
                tvOp1.setText(b.getText().toString());
            } else if (isEmpty(tvArg2)) {
                //
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
            tvCondition.setText("");
        }
    }

    class EqButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (isEmpty(tvArg1)) return;
            if (isEmpty(tvOp1)) return;
            if (isEmpty(tvArg2)) return;
            if (tvOp1.getText().toString().equals(getString(R.string.opAdd))) {
                try {
                    int arg1 = Integer.parseInt(tvArg1.getText().toString());
                    int arg2 = Integer.parseInt(tvArg2.getText().toString());
                    int result = Math.addExact(arg1, arg2);
                    tvArg1.setText(Integer.toString(result));
                    tvArg2.setText("");
                    tvOp1.setText("");
                    tvCondition.setText(R.string.conditionOk);
                } catch (ArithmeticException e) {
                    tvCondition.setText(R.string.conditionOverflow);
                } catch (NumberFormatException e) {
                    tvCondition.setText(R.string.conditionBadFormat);
                }
            } else if (tvOp1.getText().toString().equals(getString(R.string.opSub))) {
                try {
                    int arg1 = Integer.parseInt(tvArg1.getText().toString());
                    int arg2 = Integer.parseInt(tvArg2.getText().toString());
                    int result = Math.subtractExact(arg1, arg2);
                    tvArg1.setText(Integer.toString(result));
                    tvArg2.setText("");
                    tvOp1.setText("");
                    tvCondition.setText(R.string.conditionOk);
                } catch (ArithmeticException e) {
                    tvCondition.setText(R.string.conditionOverflow);
                } catch (NumberFormatException e) {
                    tvCondition.setText(R.string.conditionBadFormat);
                }
            } else if (tvOp1.getText().toString().equals(getString(R.string.opMul))) {
                try {
                    int arg1 = Integer.parseInt(tvArg1.getText().toString());
                    int arg2 = Integer.parseInt(tvArg2.getText().toString());
                    int result = Math.multiplyExact(arg1, arg2);
                    tvArg1.setText(Integer.toString(result));
                    tvArg2.setText("");
                    tvOp1.setText("");
                    tvCondition.setText(R.string.conditionOk);
                } catch (ArithmeticException e) {
                    tvCondition.setText(R.string.conditionOverflow);
                } catch (NumberFormatException e) {
                    tvCondition.setText(R.string.conditionBadFormat);
                }
            } else if (tvOp1.getText().toString().equals(getString(R.string.opDiv))) {
                try {
                    int arg1 = Integer.parseInt(tvArg1.getText().toString());
                    int arg2 = Integer.parseInt(tvArg2.getText().toString());
                    int result = arg1 / arg2;
                    tvArg1.setText(Integer.toString(result));
                    tvArg2.setText("");
                    tvOp1.setText("");
                    tvCondition.setText(R.string.conditionOk);
                } catch (ArithmeticException e) {
                    tvCondition.setText(R.string.conditionDiv0);
                } catch (NumberFormatException e) {
                    tvCondition.setText(R.string.conditionBadFormat);
                }
            } else {
                return;
            }
        }
    }

    class SignButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView tv;
            switch (v.getId()) {
                case R.id.btSign1:
                    tv = tvArg1;
                    break;
                case R.id.btSign2:
                    tv = tvArg2;
                    break;
                case R.id.btSign3:
                    tv = tvArg3;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }//switch
            if (isEmpty(tv)) return;
            if (isZero(tv)) return;
            String s = tv.getText().toString();
            String leftmost = s.substring(0, 1);
            if (leftmost.equals("-")) {
                tv.setText(s.substring(1));
            } else {
                tv.setText("-" + s);
            }
        }
    }
}