package jp.ac.kawahara.t_sasaki.fragmentsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v("MenuListFragment", "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("MenuListFragment", "onCreateView");
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

        SimpleAdapter adapter = new SimpleAdapter(
                //this,
                getActivity(),
                menuList,
                android.R.layout.simple_list_item_2,
                //R.layout.myitem,
                new String[]{"name", "price"},
                //new int[]{android.R.id.text1, android.R.id.text2}
                //new int[]{R.id.t1, R.id.t2}
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_menu_list, container, false);
        final ListView lv = v.findViewById(R.id.lvMenu);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new ListItemClickListener());
        return v;
    }

    private class ListItemClickListener
            implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
            final Map<String, String> item =
                    (Map<String, String>)
                            parent.getItemAtPosition(position);
            final String menuName = item.get("name");
            final String menuPrice = item.get("price");

            Intent intent = new Intent(getActivity(),
                    MenuThanksActivity.class);
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);
            startActivity(intent);
        }
    }//ListItemClickListener

}//MenuListFragment
