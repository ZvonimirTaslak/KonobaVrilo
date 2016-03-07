package com.taslak.konobavrilo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class FoodListActivity extends Activity implements FoodListFragment.FoodListListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

    }


    @Override
    public void itemClicked(int id) {
        View flContainer = findViewById(R.id.flFood);
        if (flContainer!=null){
            ContentFoodFragment contentFoodFragment= new ContentFoodFragment();
            FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
            contentFoodFragment.setId(id);
            fragmentTransaction.replace(R.id.flFood,contentFoodFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else {
            Intent intent = new Intent(getApplicationContext(), ContentFoodActivity.class);
            intent.putExtra(ContentFoodActivity.PRODUCT_KEY, id);
            startActivity(intent);
        }
    }
}
