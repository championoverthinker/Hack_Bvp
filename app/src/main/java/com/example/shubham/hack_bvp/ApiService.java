package com.example.shubham.hack_bvp;

import com.example.shubham.hack_bvp.Model.Order;
import com.example.shubham.hack_bvp.Model.User;
import com.example.shubham.hack_bvp.Model.token;
import com.example.shubham.hack_bvp.Model.userPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by shubham on 2/2/17.
 */

public interface ApiService {
    @Headers({"Content-Type:application/json"})
    @POST("/hackcsi/register.php")
    Call<token> registerUser(@Body User user);
    @POST("/hackcsi/orderdisplay.php")
    @Headers({"Content-Type:application/json"})
    Call<ArrayList<ArrayList<Order>>> getOrders(@Body userPost post);
    @POST("/hackcsi/displaysplit.php")
    Call<ArrayList<String>> getSplits(@Body userPost post);
    @POST("/hackcsi/algo.php")
    Call<Void> splitOrder(@Body HashMap<String,Integer> hashMap);
    @POST("/hackcsi/placeholder.php")
    Call<Void> placeOrder(@Body ArrayList<item> items);
}