package com.example.tops.sharedpf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Logout extends AppCompatActivity {
TextView textView;
    Button button;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        textView=(TextView)findViewById(R.id.text1212);
        button=(Button)findViewById(R.id.logout);
        sharedPreferences=getSharedPreferences("ok",1);

        textView.setText("edtuname="+sharedPreferences.getString("username","null")+"\nedtpass="+sharedPreferences.getString("password","null"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("islogin",false);
                editor.commit();
                startActivity(new Intent(Logout.this,MainActivity.class));
                finish();
            }
        });

    }
}
