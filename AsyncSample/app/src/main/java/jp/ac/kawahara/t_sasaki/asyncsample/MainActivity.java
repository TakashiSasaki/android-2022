package jp.ac.kawahara.t_sasaki.asyncsample;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "AsyncSample";
    private static final String WEATHERINFO_URL
            = "http://api.openweathermap.org/data/2.5/weather?lang=ja";
    private static final String APP_ID = "45e1a251abcf21306d5e1497fd4c3457";

    private List<Map<String, String>> _list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _list = createList();

        SimpleAdapter adapter = new SimpleAdapter(this, _list,
                android.R.layout.simple_list_item_1,
                new String[]{"name"},
                new int[]{android.R.id.text1});

        ((ListView) findViewById(R.id.lvCityList))
                .setAdapter(adapter);
        ((ListView) findViewById(R.id.lvCityList))
                .setOnItemClickListener(new ListItemClickListener());

    }//onCreate

    @UiThread
    private void receiveWeatherInfo(final String urlFull) {
        //メインスレッドでハンドラを生成する。
        Looper looper = Looper.getMainLooper();
        Handler handler = HandlerCompat.createAsync(looper);

        //以下はサブスレッドの生成処理
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Log.d(DEBUG_TAG, "before ExecutorService#submit");

        //古典的なJavaではメソッドを引数として渡せないのでRunnableオブジェクトに包んで渡す。
        executorService.submit(new WeatherInfoBackgroundReceiver(handler, urlFull));

        //Runnableオブジェクトの代わりにラムダ式を渡すこともできる。
        //executorService.submit( ()->{Log.d(DEBUG_TAG, "WeatherInfoBackgroundReceiver#run");});

        Log.d(DEBUG_TAG, "after ExecutorService#submit");
    }

    private class WeatherInfoBackgroundReceiver implements Runnable {
        private final Handler _handler;
        private final String _urlFull;

        //コンストラクタ
        WeatherInfoBackgroundReceiver(Handler handler, String urlFull) {
            this._handler = handler;
            this._urlFull = urlFull;
        }

        @WorkerThread
        @Override
        public void run() {
            //この run はサブスレッドで実行される
            Log.d(DEBUG_TAG, "WeatherInfoBackgroundReceiver#run");
            WeatherInfoPostExecutor postExecutor = new WeatherInfoPostExecutor();
            this._handler.post(postExecutor);
        }//run

        class WeatherInfoPostExecutor implements Runnable {

            @UiThread
            @Override
            public void run() {
                //ここにUIスレッドで行う処理コードを記述
            }//run
        }//WeatherInfoPostExecutor

    }//WeatherInfoBackgroundReceiver

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Map<String, String> item = _list.get(position);
            final String q = item.get("q");
            final String urlFull = WEATHERINFO_URL + "?q=" + q + "&APP_ID=" + APP_ID;
            Log.d(DEBUG_TAG, urlFull);
            receiveWeatherInfo(urlFull);
            Log.d(DEBUG_TAG, "receiveWeatherInfo has finished.");
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


    //以下のコードは教科書で書かれている以外のマルチスレッドの扱い方法について説明するためのボタンに対応するイベントハンドラです。
    public void threadClassTest1(View v) {
        Toast.makeText(this, "threadClassTest1", Toast.LENGTH_SHORT).show();

        //メインスレッド側でハンドラを用意する
        //このハンドラはUIにアクセスできる
        Looper looper = Looper.getMainLooper();
        Handler handler = HandlerCompat.createAsync(looper);

        //他のスレッドで実行させたい処理をrunメソッドに実装したRunnableインターフェイスを持つクラスを作る
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //メインスレッド側で用意されたハンドラにRunnableのインスタンスをpostする。
                //このRunnableのrunメソッドはメインスレッドで実行されるのでUIにアクセスできる。
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        Button button = findViewById(R.id.threadClassTest1Button);
                        button.setBackgroundColor(Color.YELLOW);
                    }
                });
            }//run method to be run in the sub-thread
        }
        ;

        //スレッドクラスのインスタンスを生成
        final Thread thread = new Thread(new MyRunnable());
        //OSが新しくスレッドを生成しMyRunnableのrunメソッドを実行する
        thread.start();
    }//threadClassTest1

    public void threadClassTest2(View v) {
        Toast.makeText(this, "threadClassTest2", Toast.LENGTH_SHORT).show();
        Looper looper = Looper.getMainLooper();
        Handler handler = HandlerCompat.createAsync(looper);

        class MyThread extends Thread {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        Button button = findViewById(R.id.threadClassTest2Button);
                        button.setBackgroundColor(Color.GREEN);
                    }//run to be posted to the handler
                });
            }//run to be run in the sub-thread
        }//Thread

        MyThread mythead = new MyThread();
        mythead.start();
    }//threadClassTest2

    public void asyncTaskTest(View v) {
        Toast.makeText(this, "asyncTaskTest", Toast.LENGTH_SHORT).show();
        class MyAsyncTask extends AsyncTask {

            Handler handler;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                final Looper looper = getMainLooper();
                this.handler = HandlerCompat.createAsync(looper);
            }

            @Override
            protected Object doInBackground(Object[] objects) {
                //doInBackground is executed in the sub-sthred.
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                final Button b = findViewById(R.id.asyncTaskTestButton);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundColor(Color.MAGENTA);
                    }//run
                });
            }//onPostExecute
        }//MyAsyncTask

        final MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }//asyncTaskTest
}//MainActivity
