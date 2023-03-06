package com.loiy.lemomall.model;

public class RecyclerModel {


    String fruitName;
    int fruitImage;

    public RecyclerModel(String fruitName) {

        this.fruitName = fruitName;
    }

    public RecyclerModel(String fruitName, int fruitImage) {

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
