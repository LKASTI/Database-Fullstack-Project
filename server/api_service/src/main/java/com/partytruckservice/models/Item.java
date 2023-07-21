package com.partytruckservice.models;

import org.springframework.data.annotation.*;

public class Item {
    @Id
    private int itemID;
    private String name;
    private String manufacturer;
    private float price;
    private int stock;

    public Item(String name, String manufacturer, float price, int stock){
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }

    public Item(int itemID, String name, String manufacturer, float price, int stock){
        this.itemID = itemID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }

    public String toString(){
        return "Item [" + itemID + ", " + name + ", " + manufacturer + ", " + stock + ", " + price + "]";
    }

    public void setItemID(int itemID){
        this.itemID = itemID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getItemID(){
        return itemID;
    }

    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public int getStock(){
        return stock;
    }

    public float getPrice(){
        return price;
    }
}

