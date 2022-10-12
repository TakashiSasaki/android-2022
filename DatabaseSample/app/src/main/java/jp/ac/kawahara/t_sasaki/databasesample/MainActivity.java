package jp.ac.kawahara.t_sasaki.databasesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //ダミーの値を設定しておく
    private int _cocktailId = -1;
    private String _cocktailName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ListView)findViewById(R.id.lvCocktail))
                .setOnItemClickListener(new ListItemClickListener());


    }

    public void onSaveButtonClick(View v){
        ((EditText)findViewById(R.id.etNote)).setText("");
        ((TextView)findViewById(R.id.tvCocktailName)).setText(R.string.tv_name);
        ((Button)findViewById(R.id.btnSave)).setEnabled(false);
    }


    class ListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            _cocktailId = position;
            _cocktailName = (String) parent.getItemAtPosition(position);

            ((TextView)(findViewById(R.id.tvCocktailName))).setText(_cocktailName);
            findViewById(R.id.btnSave).setEnabled(true);
        }
    }





}