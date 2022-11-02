package jp.ac.kawahara.t_sasaki.asyncsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "AsyncSample";
    private static final String WEATHERINFO_URL
            ="http://api.openweathermap.org/data/2.5/weather?lang=ja";
    private static final String APP_ID = "45e1a251abcf21306d5e1497fd4c3457";

    private List<Map<String, String>> _list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _list = createList();

        SimpleAdapter adapter = new SimpleAdapter(this, _list,
                android.R.layout.simple_list_item_1,
                new String[] {"name"},
                new int[] {android.R.id.text1});

        ((ListView)findViewById(R.id.lvCityList))
                .setAdapter(adapter);
        ((ListView)findViewById(R.id.lvCityList))
                .setOnItemClickListener(new ListItemClickiListener());

    }//onCreate

    private void receiveWeatherInfo(final String urlFull){

    }


    private class ListItemClickiListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Map<String,String> item = _list.get(position);
            final String q = item.get("q");
            final String urlFull = WEATHERINFO_URL + "?q=" + q + "&APP_ID=" + APP_ID;
            Log.d(DEBUG_TAG, urlFull);
            receiveWeatherInfo(urlFull);
        }
    }




    private List<Map<String, String>> createList() {

        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("name", "大阪");
        map.put("q", "Osaka");
        list.add(map);

        map = new HashMap<>();
        map.put("name", "東京");
        map.put("q", "Tokyo");
        list.add(map);

        map = new HashMap<>();
        map.put("name", "松山");
        map.put("q", "Matsuyama");
        list.add(map);

        return list;
    }








}//MainActivity
