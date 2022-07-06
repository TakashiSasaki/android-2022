package jp.ac.kawahara.t_sasaki.menusample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView _lvMenu;
    private List<Map<String, Object>> _menuList;
    private static final String[] FROM = {"name", "price"};
    private static final int[] TO = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _lvMenu = findViewById(R.id.lvMenu);
        _menuList = createTeishokuList();

        SimpleAdapter adapter = new SimpleAdapter(this, _menuList, R.layout.row, FROM, TO);
        _lvMenu.setAdapter(adapter);
        _lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    private List<Map<String, Object>> createTeishokuList(){
        List<Map<String, Object>> menuList = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "豚の生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;
    }//createTeishokuList

    private class ListItemClickListener
            implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
            //noinspection unchecked
            final Map<String, Object> item =
                    (Map<String, Object>)
                            parent.getItemAtPosition(position);
            final String menuName = (String)item.get("name");
            final Integer menuPrice = (Integer)item.get("price");

            Intent intent = new Intent(MainActivity.this,
                    MenuThanksActivity.class);
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice + "円");
            startActivity(intent);
        }//onItemClick
    }//OnItemClickListener




}