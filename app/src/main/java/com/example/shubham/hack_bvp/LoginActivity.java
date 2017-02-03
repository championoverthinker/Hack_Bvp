package com.example.shubham.hack_bvp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button submit=(Button)findViewById(R.id.submit);
        final EditText name=(EditText)findViewById(R.id.name);
        s=name.getText().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getApplication().getSharedPreferences("uname",MODE_PRIVATE);
                sharedPreferences.edit().putString("uname",name.getText().toString()).apply();
                Intent i = new Intent(LoginActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
