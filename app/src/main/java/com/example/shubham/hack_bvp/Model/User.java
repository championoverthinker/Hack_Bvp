package com.example.shubham.hack_bvp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shubham on 2/2/17.
 */

public class User {
    @SerializedName("uname")
    String uname;
    @SerializedName("pass")
    String pass;
    @SerializedName("roll")
    int roll;
    @SerializedName("name")
    String name;

    public User(String uname, String pass, int roll, String name) {
        this.name = name;
        this.pass = pass;
        this.roll = roll;

        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
