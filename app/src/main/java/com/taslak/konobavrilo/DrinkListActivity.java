package com.taslak.konobavrilo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class DrinkListActivity extends Activity implements DrinkListFragment.DrinkListListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_drink);
    }


    @Override
    public void itemClicked(int id) {
        View flContainer = findViewById(R.id.flDrink);
        if (flContainer!=null){
            ContentDrinkFragment contentDrinkFragment= new ContentDrinkFragment();
            FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
            contentDrinkFragment.setId(id);
            fragmentTransaction.replace(R.id.flDrink,contentDrinkFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else {
            Intent intent = new Intent(getApplicationContext(), ContentDrinkActivity.class);
            intent.putExtra(ContentDrinkActivity.PRODUCT_KEY, id);
            startActivity(intent);
        }
    }
}
