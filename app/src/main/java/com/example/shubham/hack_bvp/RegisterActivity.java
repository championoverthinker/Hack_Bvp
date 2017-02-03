package com.example.shubham.hack_bvp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.shubham.hack_bvp.Model.User;
import com.example.shubham.hack_bvp.Model.token;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.name)EditText name;
    @BindView(R.id.userName)EditText userName;
    @BindView(R.id.password)EditText password;
    @BindView(R.id.rollno)EditText rollno;
    @BindView(R.id.activity_register)RelativeLayout layout;
    Button button;
    String uname;
    String pass;
    int roll;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        ButterKnife.bind(this);

        button=(Button)findViewById(R.id.button);

        Button login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=userName.getText().toString();
                pass=password.getText().toString();
                Name=name.getText().toString();
                roll=Integer.parseInt(rollno.getText().toString());
                User user=new User(uname,pass,roll,Name);
                final ApiService apiService=ApiClient.getApiService();
                Call<token> call=apiService.registerUser(user);
                call.enqueue(new Callback<token>() {
                    @Override
                    public void onResponse(Call<token> call, Response<token> response) {
                        Toast.makeText(RegisterActivity.this,"Success",Toast.LENGTH_LONG).show();

                        SharedPreferences sharedPreferences=getApplication().getSharedPreferences("uname",MODE_PRIVATE);
                        sharedPreferences.edit().putString("uname",uname).apply();
                        userName.setText(null);
                        password.setText(null);
                        name.setText(null);
                        rollno.setText(null);
                        if(response.body().getToken()==0){
                            Snackbar snackbar = Snackbar
                                    .make(layout, "User Already Exists", Snackbar.LENGTH_LONG);

                            snackbar.show();
                        }else {

                            Intent i = new Intent(RegisterActivity.this, Main2Activity.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onFailure(Call<token> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this,"Failed",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}
