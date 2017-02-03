package com.example.shubham.hack_bvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.shubham.hack_bvp.Model.Order;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shubham on 2/2/17.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyHolder> {

    ArrayList<String> data;
    Context mContext;


    public OrderAdapter(ArrayList<String> data, Context mContext) {
        this.data=data;
        this.mContext = mContext;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.split_layou,parent,false));

    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {



        String s=data.get(position);

            s=s.replace(".","\n");



        holder.orderName.setText(s);
//        holder.orderName.setText(mData.get(position).getOrderName());
//        holder.price.setText(mData.get(position).getPrice()+"");
//        holder.quantity.setText(mData.get(position).getQuantity()+"");


    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView orderName;


        public MyHolder(View itemView) {
            super(itemView);
            orderName=(TextView)itemView.findViewById(R.id.split);
        }
    }

//    public static class HeaderHolder extends RecyclerView.ViewHolder{
//
//        TextView textView;
//        public HeaderHolder(View itemView) {
//            super(itemView);
//            textView=(TextView)itemView.findViewById(R.id.text);
//        }
//    }


//    @Override
//    public int getItemViewType(int position) {
//        if(position/2==0){
//            return 1;
//        }else{
//            return 0;
//        }
//    }
}
