package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class OperatorButtonClickListener implements View.OnClickListener {
    private final MainActivity mainActivity;

    public OperatorButtonClickListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        if (mainActivity.isEmpty(mainActivity.tvArg1)) {
            //
        } else if (mainActivity.isEmpty(mainActivity.tvOp1)) {
            final Button b = (Button) v;
            final TextView tvOp1 = mainActivity.findViewById(R.id.tvOp1);
            tvOp1.setText(b.getText().toString());
        } else if (mainActivity.isEmpty(mainActivity.tvArg2)) {
            //
        }
    }
}
