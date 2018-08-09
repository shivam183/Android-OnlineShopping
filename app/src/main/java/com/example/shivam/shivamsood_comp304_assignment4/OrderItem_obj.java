package com.example.shivam.shivamsood_comp304_assignment4;

public class OrderItem_obj {
    //Customer Fields

    private int orderItemID, itemID, customerID, amount;
    private String status, deliveryDate;

    //Construtor

    public OrderItem_obj() {
    }

    public OrderItem_obj(int orderItemID, int itemID, int customerID, int amount, String status, String deliveryDate) {
        this.orderItemID = orderItemID;
        this.itemID = itemID;
        this.customerID = customerID;
        this.amount = amount;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }
    //setter

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //getter


    public int getOrderItemID() {
        return orderItemID;
    }

    public int getItemID() {
        return itemID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getAmount() {
        return amount;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getStatus() {
        return status;
    }
}
