package com.example.shubham.hack_bvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class lunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        ArrayList<item> lunchf=new ArrayList<>();
        lunchf.add(new item(1,"chole bhatture",1,100,R.drawable.chole));
        lunchf.add(new item(2,"dosa",2,50,R.drawable.dosa));
        lunchf.add(new item(3,"thali",3,200,R.drawable.thali));
        lunchf.add(new item(4,"veg platter",4,400,R.drawable.vegplatter));



        itemadapter flavorAdapter = new itemadapter(this,lunchf);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview1_item);
        listView.setAdapter(flavorAdapter);



    }
}
