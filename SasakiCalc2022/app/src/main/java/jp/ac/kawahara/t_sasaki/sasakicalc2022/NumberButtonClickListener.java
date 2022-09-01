package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import android.view.View;
import android.widget.Button;

class NumberButtonClickListener implements View.OnClickListener {
    private final MainActivity mainActivity;

    public NumberButtonClickListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        final Button b = (Button) v;
        final String s = b.getText().toString();

        if (mainActivity.isEmpty(mainActivity.tvOp1)) {
            if (mainActivity.isZero(mainActivity.tvArg1)) {
                mainActivity.tvArg1.setText(s);
            } else if (mainActivity.tvCondition.getText().toString().equals(mainActivity.getString(R.string.conditionOk))) {
                mainActivity.tvArg1.setText(s);
                mainActivity.tvCondition.setText("");
            } else {
                mainActivity.appendString(mainActivity.tvArg1, s);
            }
        } else {
            if (mainActivity.isZero(mainActivity.tvArg2)) {
                mainActivity.tvArg2.setText(s);
            } else if (mainActivity.tvCondition.getText().toString().equals(mainActivity.getString(R.string.conditionOk))) {
                mainActivity.tvArg2.setText(s);
                mainActivity.tvCondition.setText("");
            } else {
                mainActivity.appendString(mainActivity.tvArg2, s);
            }
        }
    }
}//NumberButtonClickListener
