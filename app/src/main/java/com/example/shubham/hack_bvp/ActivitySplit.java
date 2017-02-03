package com.example.shubham.hack_bvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySplit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_split);
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                split();
            }
        });
    }

    public void split(){
        final EditText e1=(EditText) findViewById(R.id.e1);
        EditText c1=(EditText) findViewById(R.id.e2);

        EditText e2=(EditText) findViewById(R.id.e3);
        EditText c2=(EditText) findViewById(R.id.e4);

        EditText e3=(EditText) findViewById(R.id.e5);
        EditText c3=(EditText) findViewById(R.id.e6);
        EditText e4=(EditText) findViewById(R.id.e7);
        EditText c4=(EditText) findViewById(R.id.e8);

        HashMap<String,Integer> hashMap = new HashMap<>();

        if(e1.getText().toString().equals(""))
        {


        }
        else
        {
            hashMap.put(e1.getText().toString()+"",Integer.parseInt(c1.getText().toString()));

        }

        if(e2.getText().toString().equals(""))
        {


        }
        else
        {
            hashMap.put(e2.getText().toString()+"",Integer.parseInt(c2.getText().toString()));

        }
        if(e3.getText().toString().equals(""))
        {


        }
        else
        {
            hashMap.put(e3.getText().toString()+"",Integer.parseInt(c3.getText().toString()));

        }
        if(e4.getText().toString().equals(""))
        {


        }
        else
        {
            hashMap.put(e4.getText().toString()+"",Integer.parseInt(c4.getText().toString()));

        }

        ApiService apiService=ApiClient.getApiService();
        Call<Void> call=apiService.splitOrder(hashMap);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Intent i=new Intent(ActivitySplit.this,Main2Activity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });



    }
}
