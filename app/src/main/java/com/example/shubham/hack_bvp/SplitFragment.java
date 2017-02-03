package com.example.shubham.hack_bvp;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shubham.hack_bvp.Model.userPost;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplitFragment extends Fragment {

    RecyclerView splits;
    OrderAdapter adapter;
    ArrayList<String> data;

    public SplitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_split,container,false);

        ButterKnife.bind(getActivity());
        data=new ArrayList<>();
        adapter=new OrderAdapter(data,getActivity());
        splits=(RecyclerView)v.findViewById(R.id.splits);
        splits.setAdapter(adapter);
        ApiService apiService=ApiClient.getApiService();
        SharedPreferences sharedPreferences=getActivity().getApplication().getSharedPreferences("uname",MODE_PRIVATE);
        String s=sharedPreferences.getString("uname","s3");
        Call<ArrayList<String>> call=apiService.getSplits(new userPost(s));
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                ArrayList<String> splits=response.body();
                for(String s:splits){
                    data.add(s);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {

            }
        });
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        splits.setLayoutManager(layoutManager);




        return v;
    }

}
