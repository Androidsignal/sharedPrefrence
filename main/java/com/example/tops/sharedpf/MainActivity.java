package com.example.tops.sharedpf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtuname,edtpass;
    Button btnlogin;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtuname=(EditText)findViewById(R.id.uname);
        edtpass=(EditText)findViewById(R.id.password);
        sharedPreferences=getSharedPreferences("ok",1);

        btnlogin=(Button)findViewById(R.id.login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtuname.getText().toString().equals("Ravi") && edtpass.getText().toString().equals("121212")){
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("username",edtuname.getText().toString());
                    editor.putString("password",edtpass.getText().toString());
                    editor.putBoolean("islogin",true);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this,Logout.class));
                    finish();

                }else {
                    Toast.makeText(MainActivity.this, "invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(sharedPreferences.getBoolean("islogin",false)){
            startActivity(new Intent(MainActivity.this,Logout.class));
            finish();
        }
    }

}
