package com.utils;

public class Product {
    private String name;
    private float price;
    private int qty;
    public Product() {
    }
    public Product(String name, float price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
}
