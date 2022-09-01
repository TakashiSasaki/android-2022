package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import android.view.View;

class CaButtonClickListener implements View.OnClickListener {

    private final MainActivity mainActivity;

    public CaButtonClickListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        mainActivity.tvArg1.setText("");
        mainActivity.tvArg2.setText("");
        mainActivity.tvArg3.setText("");
        mainActivity.tvOp1.setText("");
        mainActivity.tvOp2.setText("");
        mainActivity.tvCondition.setText("");
    }
}
