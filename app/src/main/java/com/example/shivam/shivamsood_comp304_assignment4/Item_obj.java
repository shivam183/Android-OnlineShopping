package com.example.shivam.shivamsood_comp304_assignment4;

public class Item_obj {
    //Customer Fields

    private int itemID,price;
    private String itemName,category;

    //Construtor

    public Item_obj() {
    }

    public Item_obj(int itemID, int price, String itemName, String category) {
        this.itemID = itemID;
        this.price = price;
        this.itemName = itemName;
        this.category = category;
    }

//setter

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    //getter


    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
