package com.example.shubham.hack_bvp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.shubham.hack_bvp.Model.Order;
import com.example.shubham.hack_bvp.Model.userPost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    CustomExpandableListAdapter expandableListAdapter;
    ArrayList<String> expandableListTitle;
    HashMap<String, List<Order>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListDetail = new HashMap<String, List<Order>>();
        expandableListDetail=ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);




        expandableListAdapter = new CustomExpandableListAdapter(MainActivity.this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


//        ApiService apiService=ApiClient.getApiService();
//        Call<ArrayList<ArrayList<Order>>> call=apiService.getOrders(new userPost("ss"));
//        call.enqueue(new Callback<ArrayList<ArrayList<Order>>>() {
//            @Override
//            public void onResponse(Call<ArrayList<ArrayList<Order>>> call, Response<ArrayList<ArrayList<Order>>> response) {
//                ArrayList<ArrayList<Order>> data=response.body();
//                for(int i=0;i<data.size();i++){
//                    expandableListDetail.put("order"+i,data.get(i));
//                }
//
//                expandableListAdapter.notifyDataSetChanged();
//
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<ArrayList<Order>>> call, Throwable t) {
//
//            }
//        });


    }
}
