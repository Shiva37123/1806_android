package com.example.webclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static TextView Dataview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dataview = findViewById(R.id.dataview);

        Sortdata sortData = new Sortdata();
        sortData.execute();
    }


    public void sortdata(View view){

        Toast.makeText(this,"Data is Sorted", Toast.LENGTH_SHORT).show();
    }

    public void total(View view){
        Toast.makeText(this,"Total salary is " +Sortdata.totalsalary.toString(), Toast.LENGTH_LONG).show();
    }


}