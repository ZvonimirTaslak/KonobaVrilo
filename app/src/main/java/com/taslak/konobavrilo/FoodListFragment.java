package com.taslak.konobavrilo;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FoodListFragment extends ListFragment {

    public static interface FoodListListener{
        void itemClicked(int id);
    }

    private FoodListListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setAdapter(inflater);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener=(FoodListListener)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener!=null){
            listener.itemClicked(position);
        }
    }

    private void setAdapter(LayoutInflater inflater) {
        ArrayAdapter<Food> adapter= new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                Food.FOOD
        );
        setListAdapter(adapter);
    }
}
