package com.taslak.konobavrilo;

public class Drink {

    private String name;
    private String description;
    private int imageResourceId;

    public Drink( String name, String description, int imageResourceId) {

        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Drink[] DRINK = {
            new Drink( "Plavac mali Volarević", "Vrhunsko vino sa područja komarna", R.drawable.plavac),
            new Drink( "Žilavka Nuić Selekcija", "Vrhunsko bijelo suho vino", R.drawable.zilavka),
            new Drink( "Blatina Andrija ", "Vrhunsko vino, sa probranih položaja", R.drawable.plavac)
    };



    public String getName() {
        return name;
    }


    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
