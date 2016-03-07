package com.taslak.konobavrilo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ContentFoodFragment extends Fragment {

    private static final String KEY = "com.taslak.konobavrilo.key.ContentFoodFragment";
    private ImageView ivProduct;
    private TextView tvProductName;
    private TextView tvProductDescription;

    private static int id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            id = savedInstanceState.getInt(KEY);
        }
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();
        if (v != null) {
            initWidges(v);
            setupWidgets();
        }

    }

    public void setupWidgets() {
        tvProductName.setText(Food.FOOD[id].getName());
        tvProductDescription.setText(Food.FOOD[id].getDescription());
        ivProduct.setImageResource(Food.FOOD[id].getImageResourceId());
    }


    private void initWidges(View v) {
        ivProduct = (ImageView) v.findViewById(R.id.ivProduct);
        tvProductDescription = (TextView) v.findViewById(R.id.tvProductDecription);
        tvProductName = (TextView) v.findViewById(R.id.tvProductName);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY, id);
    }
}
