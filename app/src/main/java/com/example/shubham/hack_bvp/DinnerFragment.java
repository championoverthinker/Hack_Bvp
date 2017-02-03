package com.example.shubham.hack_bvp;


import android.content.Context;
import android.content.Intent;
import android.icu.text.MessagePattern;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DinnerFragment extends Fragment {



        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;



        public DinnerFragment() {
            // Required empty public constructor
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final ArrayList<item> dinnerf=new ArrayList<>();
            dinnerf.add(new item(9,"veg pizza",0,400,R.drawable.pizza));
            dinnerf.add(new item(10,"full thali",0,500,R.drawable.thali));
            dinnerf.add(new item(11,"curry",0,200,R.drawable.curry));
            dinnerf.add(new item(12,"rice",0,100,R.drawable.rice));




            // Get a reference to the ListView, and attach the adapter to the listView.

            // Inflate the layout for this fragment
            View rootView=  inflater.inflate(R.layout.activity_dinner, container, false);
            Button placeOrder=(Button)rootView.findViewById(R.id.placeOrder);

            placeOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getActivity(),ActivitySplit.class);
                    ApiService apiService= ApiClient.getApiService();
                    Call<Void>call=apiService.placeOrder(dinnerf);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });

                    startActivity(i);
                }
            });
            ListView listView = (ListView) rootView.findViewById(R.id.listview_item);
            itemadapter flavorAdapter = new itemadapter(getActivity(),dinnerf);
            listView.setAdapter(flavorAdapter);
            return  rootView;
        }

    }



