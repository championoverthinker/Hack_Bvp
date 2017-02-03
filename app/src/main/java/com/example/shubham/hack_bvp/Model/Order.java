package com.example.shubham.hack_bvp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shubham on 2/2/17.
 */

public class Order {
    @SerializedName("name")
    String name;
    @SerializedName("qty")
    int qty;
    int price;

    public Order(String name, int qty, int price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
