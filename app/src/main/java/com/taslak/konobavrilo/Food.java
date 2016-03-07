package com.taslak.konobavrilo;

public class Food {


    private String name;
    private String description;
    private int imageResourceId;

    public Food(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Food[] FOOD = {
            new Food("Gambori na buzaru", "Gambori sa ušća neretve", R.drawable.gambori_buz),
            new Food("Brujet od jegulje i žaba", "Neretvanski specijalitet", R.drawable.brujet),
            new Food("Žabe", "Mogu se spremit pohane, dinstane na luku, žar sa pršutom i na rižot", R.drawable.zabe)

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