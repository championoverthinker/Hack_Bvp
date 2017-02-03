package com.example.shubham.hack_bvp;

import com.example.shubham.hack_bvp.Model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shubham on 2/2/17.
 */

public class ExpandableListDataPump {
    public static HashMap<String, List<Order>> getData() {
        HashMap<String, List<Order>> expandableListDetail = new HashMap<String, List<Order>>();



        List<Order> football = new ArrayList<Order>();
        football.add(new Order("Noodles",2,100));
        football.add(new Order("Fried Rice",1,150));
        football.add(new Order("Stir Fry",2,100));

        List<Order> basketball = new ArrayList<Order>();
        basketball.add(new Order("Chicken",2,200));
        basketball.add(new Order("Chole Bhature",3,300));
        basketball.add(new Order("Chicken Tikka",4,500));

        expandableListDetail.put("Order 1", football);
        expandableListDetail.put("Order 2", basketball);
        return expandableListDetail;
    }
}
