package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import android.view.View;
import android.widget.TextView;

class SignButtonClickListener implements View.OnClickListener {
    private final MainActivity mainActivity;

    public SignButtonClickListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        TextView tv;
        switch (v.getId()) {
            case R.id.btSign1:
                tv = mainActivity.tvArg1;
                break;
            case R.id.btSign2:
                tv = mainActivity.tvArg2;
                break;
            case R.id.btSign3:
                tv = mainActivity.tvArg3;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }//switch
        if (mainActivity.isEmpty(tv)) return;
        if (mainActivity.isZero(tv)) return;
        String s = tv.getText().toString();
        String leftmost = s.substring(0, 1);
        if (leftmost.equals("-")) {
            tv.setText(s.substring(1));
        } else {
            tv.setText("-" + s);
        }
    }
}
