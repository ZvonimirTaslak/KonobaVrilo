package com.taslak.konobavrilo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvFoodManu;
    private TextView tvDrinkManu;
    private TextView tvLocation;
    private TextView tvContact;
    private TextView tvAbout;
    ExitDialog exitDialog = new ExitDialog();
    private boolean firstTime = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome();
        initWidges();
        setupListener();
    }

    private void welcome() {
        if (firstTime) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            if (preferences.contains("nickname")) {
                String nickname = preferences.getString("nickname", null);
                Toast.makeText(MainActivity.this, "Welcome "+nickname+"!! :D", Toast.LENGTH_SHORT).show();
            }
            firstTime = false;
        }
    }

    private void initWidges() {
        tvAbout = (TextView) findViewById(R.id.tvAbout);
        tvContact = (TextView) findViewById(R.id.tvContact);
        tvDrinkManu = (TextView) findViewById(R.id.tvDrinkMenu);
        tvFoodManu = (TextView) findViewById(R.id.tvFoodMenu);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
    }

    private void setupListener() {
        tvFoodManu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodListActivity.class);
                startActivity(intent);

            }
        });
        tvDrinkManu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DrinkListActivity.class);
                startActivity(intent);

            }
        });
        tvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed() {
        exitDialog.show(getFragmentManager(), "Exit Dialog");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.options) {
            Intent intent = new Intent(getApplicationContext(), CustomPreferenceActivity.class);
            startActivity(intent);

        }
        return true;
    }
}
