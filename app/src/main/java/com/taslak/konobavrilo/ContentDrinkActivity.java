package com.taslak.konobavrilo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ContentDrinkActivity extends AppCompatActivity implements DrinkListFragment.DrinkListListener {

    public static final String PRODUCT_KEY = "com.taslak.konobavrilo.product.key";
    private int id;
    private ContentDrinkFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_drink);


        getIntentId();
        fragment = (ContentDrinkFragment) getFragmentManager().findFragmentById(R.id.fragContentDrink);
        fragment.setId(id);


    }

    private void getIntentId() {

        Intent intent = getIntent();
        id = intent.getIntExtra(PRODUCT_KEY, 0);

    }


    @Override
    public void itemClicked(int id) {
        fragment = (ContentDrinkFragment) getFragmentManager().findFragmentById(R.id.fragContentDrink);
        fragment.setId(id);
        fragment.setupWidgets();
    }

}
