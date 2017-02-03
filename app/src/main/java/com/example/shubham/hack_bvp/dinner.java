package com.example.shubham.hack_bvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class dinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        ArrayList<item> dinnerf=new ArrayList<>();
        dinnerf.add(new item(1,"veg pizza",1,400,R.drawable.pizza));
        dinnerf.add(new item(2,"full thali",2,500,R.drawable.thali));
        dinnerf.add(new item(3,"curry",3,200,R.drawable.curry));
        dinnerf.add(new item(4,"rice",4,100,R.drawable.rice));



        itemadapter flavorAdapter = new itemadapter(this,dinnerf);

        // Get a reference to the ListView, and attach the adapter to the listView.
//        ListView listView = (ListView) findViewById(R.id.listview2_item);
//        listView.setAdapter(flavorAdapter);

    }
}
