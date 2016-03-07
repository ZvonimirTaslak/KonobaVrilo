package com.taslak.konobavrilo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ContentFoodActivity extends AppCompatActivity implements FoodListFragment.FoodListListener {

    public static final String PRODUCT_KEY = "com.taslak.konobavrilo.product.key";
    int id;
    private ContentFoodFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_food);

        getIntentId();

        ContentFoodFragment foodFragment = (ContentFoodFragment) getFragmentManager().findFragmentById(R.id.fragContentFood);
        foodFragment.setId(id);



    }

    private void getIntentId() {
        Intent intent = getIntent();
        id = intent.getIntExtra(PRODUCT_KEY, 0);
    }

    @Override
    public void itemClicked(int id) {
        fragment = (ContentFoodFragment) getFragmentManager().findFragmentById(R.id.fragContentFood);
        fragment.setId(id);
        fragment.setupWidgets();
    }
}
