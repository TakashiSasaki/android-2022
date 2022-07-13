package jp.ac.kawahara.t_sasaki.menusample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);

        final Intent intent = getIntent();
        final String menuName = intent.getStringExtra("menuName");
        final String menuPrice = intent.getStringExtra("menuPrice");
        final TextView tvMenuName = findViewById(R.id.tvMenuName);
        tvMenuName.setText(menuName);
        final TextView tvMenuPrice = findViewById(R.id.tvMenuPrice);
        tvMenuPrice.setText(menuPrice);

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onBackButtonClick(View view) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}