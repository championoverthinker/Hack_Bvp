package com.example.shubham.hack_bvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shubham.hack_bvp.Model.userPost;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplitActivity extends AppCompatActivity {

    @BindView(R.id.splits)RecyclerView splits;
    OrderAdapter adapter;
    ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        adapter=new OrderAdapter(data,this);
        splits.setAdapter(adapter);
        ApiService apiService=ApiClient.getApiService();
        Call<ArrayList<String>> call=apiService.getSplits(new userPost("s3"));
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
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        splits.setLayoutManager(layoutManager);

    }
}
