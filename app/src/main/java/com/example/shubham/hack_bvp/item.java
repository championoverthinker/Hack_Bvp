package com.example.shubham.hack_bvp;

/**
 * Created by navendu on 02-02-2017.
 */
public class item {
    public int id;
    public String name;
    public int qty;
    public int price;
    public int mImageResourceId;
    public item(int id,String name,int qty,int price,int mImageResourceId)
    {

        this.id=id;
        this.name=name;
        this.qty=qty;
        this.price=price;
        this.mImageResourceId=mImageResourceId;

    }
    public int getImageResourceId() {
        return mImageResourceId;
    }





}
