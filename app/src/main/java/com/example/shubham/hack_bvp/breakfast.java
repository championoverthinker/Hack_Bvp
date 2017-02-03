package com.example.shubham.hack_bvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class breakfast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        ArrayList<item> breakf=new ArrayList<>();
        breakf.add(new item(1,"grilled sandwich",1,50,R.drawable.grilled));
        breakf.add(new item(2,"juice",2,90,R.drawable.juice));
        breakf.add(new item(3,"toast bread",3,30,R.drawable.milk));
        breakf.add(new item(4,"fresh juice",4,40,R.drawable.toast));



        itemadapter flavorAdapter = new itemadapter(this,breakf);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_item);
        listView.setAdapter(flavorAdapter);


    }
}
