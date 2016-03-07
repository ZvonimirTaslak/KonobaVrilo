package com.taslak.konobavrilo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ContentDrinkFragment extends Fragment {

    private static final java.lang.String ID_KEY = "com.taslak.konobavrilo.id.key";
    private ImageView ivProduct;
    private TextView tvProductName;
    private TextView tvProductDescription;

    private int id;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       if(savedInstanceState!=null){
           id=savedInstanceState.getInt(ID_KEY);
       }

        return inflater.inflate(R.layout.fragment_content, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        View v=getView();
        if (v !=null){
            initWidges(v);
            setupWidgets();
        }

    }


    public void setupWidgets() {
        tvProductName.setText(Drink.DRINK[id].getName());
        tvProductDescription.setText(Drink.DRINK[id].getDescription());
        ivProduct.setImageResource(Drink.DRINK[id].getImageResourceId());
    }



    private void initWidges(View v) {
        ivProduct=(ImageView)v.findViewById(R.id.ivProduct);
        tvProductDescription=(TextView)v.findViewById(R.id.tvProductDecription);
        tvProductName=(TextView)v.findViewById(R.id.tvProductName);
    }

    public void setId(int id){
        this.id=id;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(ID_KEY,id);
    }
}
