package com.utils;

import java.util.ArrayList;
import java.util.List;

public class ManageProducts {
    private static List<Product> products = new ArrayList<Product>();

    public static void setProducts(List<Product> products) {
        ManageProducts.products = products;
    }
    public static List<Product> getProducts() {
        return products;
    }
    public static void addProduct(String name, float price, int qty){
        ManageProducts.products.add(new Product(name, price, qty));
    }
}

