package com.techelevator.view;

public abstract class Product {
    private double price;
    private int stock=5;
    private String name;
    private String slotID;

    public Product(double price, String name, String slotID) {
        this.price = price;
        this.name = name;
        this.slotID = slotID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public String getSlotID() {
        return slotID;
    }
}
