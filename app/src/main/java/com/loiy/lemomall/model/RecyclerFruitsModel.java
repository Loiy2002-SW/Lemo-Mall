package com.loiy.lemomall.model;

public class RecyclerFruitsModel {

    int fruitImage, numberOfAdditions;
    String fruitName, fruitPrice;

    String orderId;



    public RecyclerFruitsModel(String fruitPrice, String orderId) {
        this.fruitPrice = fruitPrice;
        this.orderId = orderId;
    }

    public RecyclerFruitsModel(int fruitImage, String fruitName, String fruitPrice, int numberOfAdditions) {
        this.fruitImage = fruitImage;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.numberOfAdditions = numberOfAdditions;
    }

    public int getFruitImage() {
        return fruitImage;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getFruitPrice() {
        return fruitPrice;
    }

    public int getNumberOfAdditions() {
        return numberOfAdditions;
    }

    public void setNumberOfAdditions(int numberOfAdditions) {
        this.numberOfAdditions = numberOfAdditions;
    }
    public String getOrderId() {
        return orderId;
    }
}
