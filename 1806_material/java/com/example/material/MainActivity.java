package com.example.material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextInputEditText name,email,phone,password,repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(TextInputEditText)findViewById(R.id.name);
        email=(TextInputEditText)findViewById(R.id.email);
        phone=(TextInputEditText)findViewById(R.id.phone);
        password=(TextInputEditText)findViewById(R.id.password);
        repassword=(TextInputEditText)findViewById(R.id.repassword);


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    name.setHint("Name");
                }
                else{
                    name.setHint("");
                }
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    email.setHint("Email");
                }
                else{
                    email.setHint("");
                }
            }
        });
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    phone.setHint("Phone");
                }
                else{
                    phone.setHint("");
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    password.setHint("Password");
                }
                else{
                    password.setHint("");
                }
            }
        });
        repassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    repassword.setHint("Re-Enter Password");
                }
                else{
                    repassword.setHint("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.ok:
                Intent intent= new Intent(this, form2.class);
                String personName= name.getText().toString();
                intent.putExtra("sendMessage",personName);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}