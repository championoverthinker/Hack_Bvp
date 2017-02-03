package com.example.shubham.hack_bvp.Model;

import java.util.ArrayList;

/**
 * Created by shubham on 2/2/17.
 */

public class OrderPost {
    String uname;
    ArrayList<Order> orders;

    public OrderPost(String uname, ArrayList<Order> orders) {
        this.uname = uname;
        this.orders = orders;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
