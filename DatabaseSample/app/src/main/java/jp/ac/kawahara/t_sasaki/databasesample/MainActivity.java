package jp.ac.kawahara.t_sasaki.databasesample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.Editable;
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
    private DatabaseHelper _helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ListView)findViewById(R.id.lvCocktail))
                .setOnItemClickListener(new ListItemClickListener());

        _helper = new DatabaseHelper(this);

    }

    public void onSaveButtonClick(View v){
        SQLiteDatabase db = _helper.getWritableDatabase();

        SQLiteStatement sqLiteStatement
                = db.compileStatement("DELETE FROM cocktailmemos WHERE _id = ?");
        sqLiteStatement.bindLong(1, _cocktailId);
        sqLiteStatement.executeUpdateDelete();

        String note = ((EditText) findViewById(R.id.etNote)).getText().toString();

        SQLiteStatement sqLiteStatement1
                = db.compileStatement(
                        "INSERT INTO cocktailmemos (_id, name, note) VALUES (?,?,?)");
        sqLiteStatement1.bindLong(1, _cocktailId);
        sqLiteStatement1.bindString(2, _cocktailName);
        sqLiteStatement1.bindString(3,note);
        sqLiteStatement1.executeInsert();

        ((EditText)findViewById(R.id.etNote)).setText("");
        ((TextView)findViewById(R.id.tvCocktailName)).setText(R.string.tv_name);
        ((Button)findViewById(R.id.btnSave)).setEnabled(false);
    }


    class ListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            _cocktailId = position;
            _cocktailName = (String) parent.getItemAtPosition(position);

            SQLiteDatabase writableDatabase = _helper.getWritableDatabase();
            Cursor cursor = writableDatabase.rawQuery
                    ("SELECT * FROM cocktailmemos WHERE _id = " + _cocktailId, null);

            while (cursor.moveToNext()){
              int idxNote = cursor.getColumnIndex("note");
              String s = cursor.getString(idxNote);
            }

            ((TextView)(findViewById(R.id.tvCocktailName))).setText(_cocktailName);
            findViewById(R.id.btnSave).setEnabled(true);
        }
    }

    @Override
    protected void onDestroy() {
        _helper.close();
        super.onDestroy();
    }
}