package com.test.util;

public class ItemsList {

    private String name;
    private String description;
    private int quantity;
    private float price;

    public ItemsList (){
        name="";
        description="";
        quantity=0;
        price=0;
    }

    public ItemsList(String nm, String descript, int quant, float amount) {
        name = nm;
        description = descript;
        quantity = quant;
        price = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}


