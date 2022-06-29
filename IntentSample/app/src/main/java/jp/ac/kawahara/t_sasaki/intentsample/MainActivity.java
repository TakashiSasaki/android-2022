package jp.ac.kawahara.t_sasaki.intentsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, String>> menuList = new ArrayList<>();

        Map<String, String> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", "800円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", "850円");
        menuList.add(menu);

        //String[] from = {"name", "price"};
        //int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                menuList,
                //android.R.layout.simple_list_item_2,
                R.layout.myitem,
                new String[]{"name", "price"},
                //new int[]{android.R.id.text1, android.R.id.text2}
                new int[]{R.id.t1, R.id.t2}
        );

        final ListView lv = findViewById(R.id.lvMenu);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener
            implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
            final Map<String, String> item =
                    (Map<String, String>)
                            parent.getItemAtPosition(position);
            final String menuName = item.get("name");
            final String menuPrice = item.get("price");

            Intent intent = new Intent(MainActivity.this,
                    MenuThanksActivity.class);
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);
            startActivity(intent);
        }
    }
}