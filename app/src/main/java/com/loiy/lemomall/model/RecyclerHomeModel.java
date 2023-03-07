package com.loiy.lemomall.model;

public class RecyclerHomeModel {


    String fruitName;
    int fruitImage;

    public RecyclerHomeModel(String fruitName) {

        this.fruitName = fruitName;
    }

    public RecyclerHomeModel(String fruitName, int fruitImage) {

        this.fruitName = fruitName;
        this.fruitImage = fruitImage;
    }


    public int getFruitImage() {
        return fruitImage;
    }


    public String getFruitName() {
        return fruitName;
    }


}
