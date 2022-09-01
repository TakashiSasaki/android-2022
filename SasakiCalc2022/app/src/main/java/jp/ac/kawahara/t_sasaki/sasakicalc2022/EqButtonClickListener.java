package jp.ac.kawahara.t_sasaki.sasakicalc2022;

import android.view.View;

class EqButtonClickListener implements View.OnClickListener {
    private final MainActivity mainActivity;

    public EqButtonClickListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        if (mainActivity.isEmpty(mainActivity.tvArg1)) return;
        if (mainActivity.isEmpty(mainActivity.tvOp1)) return;
        if (mainActivity.isEmpty(mainActivity.tvArg2)) return;
        if (mainActivity.tvOp1.getText().toString().equals(mainActivity.getString(R.string.opAdd))) {
            try {
                int arg1 = Integer.parseInt(mainActivity.tvArg1.getText().toString());
                int arg2 = Integer.parseInt(mainActivity.tvArg2.getText().toString());
                int result = Math.addExact(arg1, arg2);
                mainActivity.tvArg1.setText(Integer.toString(result));
                mainActivity.tvArg2.setText("");
                mainActivity.tvOp1.setText("");
                mainActivity.tvCondition.setText(R.string.conditionOk);
            } catch (ArithmeticException e) {
                mainActivity.tvCondition.setText(R.string.conditionOverflow);
            } catch (NumberFormatException e) {
                mainActivity.tvCondition.setText(R.string.conditionBadFormat);
            }
        } else if (mainActivity.tvOp1.getText().toString().equals(mainActivity.getString(R.string.opSub))) {
            try {
                int arg1 = Integer.parseInt(mainActivity.tvArg1.getText().toString());
                int arg2 = Integer.parseInt(mainActivity.tvArg2.getText().toString());
                int result = Math.subtractExact(arg1, arg2);
                mainActivity.tvArg1.setText(Integer.toString(result));
                mainActivity.tvArg2.setText("");
                mainActivity.tvOp1.setText("");
                mainActivity.tvCondition.setText(R.string.conditionOk);
            } catch (ArithmeticException e) {
                mainActivity.tvCondition.setText(R.string.conditionOverflow);
            } catch (NumberFormatException e) {
                mainActivity.tvCondition.setText(R.string.conditionBadFormat);
            }
        } else if (mainActivity.tvOp1.getText().toString().equals(mainActivity.getString(R.string.opMul))) {
            try {
                int arg1 = Integer.parseInt(mainActivity.tvArg1.getText().toString());
                int arg2 = Integer.parseInt(mainActivity.tvArg2.getText().toString());
                int result = Math.multiplyExact(arg1, arg2);
                mainActivity.tvArg1.setText(Integer.toString(result));
                mainActivity.tvArg2.setText("");
                mainActivity.tvOp1.setText("");
                mainActivity.tvCondition.setText(R.string.conditionOk);
            } catch (ArithmeticException e) {
                mainActivity.tvCondition.setText(R.string.conditionOverflow);
            } catch (NumberFormatException e) {
                mainActivity.tvCondition.setText(R.string.conditionBadFormat);
            }
        } else if (mainActivity.tvOp1.getText().toString().equals(mainActivity.getString(R.string.opDiv))) {
            try {
                int arg1 = Integer.parseInt(mainActivity.tvArg1.getText().toString());
                int arg2 = Integer.parseInt(mainActivity.tvArg2.getText().toString());
                int result = arg1 / arg2;
                mainActivity.tvArg1.setText(Integer.toString(result));
                mainActivity.tvArg2.setText("");
                mainActivity.tvOp1.setText("");
                mainActivity.tvCondition.setText(R.string.conditionOk);
            } catch (ArithmeticException e) {
                mainActivity.tvCondition.setText(R.string.conditionDiv0);
            } catch (NumberFormatException e) {
                mainActivity.tvCondition.setText(R.string.conditionBadFormat);
            }
        } else {
            return;
        }
    }
}
