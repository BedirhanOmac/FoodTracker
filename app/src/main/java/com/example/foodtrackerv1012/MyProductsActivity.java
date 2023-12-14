package com.example.foodtrackerv1012;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ArrayList;


public class MyProductsActivity extends AppCompatActivity {
    ArrayList<ProductModel> models = new ArrayList<>();

    private void setProductModels() {

        ArrayList<String> productnames = new ArrayList<>();
        ArrayList<String> productFreshness = new ArrayList<>();
        ArrayList<String> expirationDate = new ArrayList<>();

        productFreshness.add("4");productFreshness.add("5");productFreshness.add("6");
        productnames.add("p1");productnames.add("p2");productnames.add("p3");
        expirationDate.add("date1");expirationDate.add("date2");expirationDate.add("date3");





        for (int i = 0;i<productnames.size();i++) {
            models.add(new ProductModel(productnames.get(i),productFreshness.get(i),expirationDate.get(i)));
        }
    }
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        RecyclerView recView = findViewById(R.id.recyclerView);
        setProductModels();
        Recyclerviewadapter adapter = new Recyclerviewadapter(this,models);
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
        // Add space between items
        int verticalSpaceHeight = 30; // Adjust this value as needed
        recView.addItemDecoration(new SpacesItemDecoration(verticalSpaceHeight));
    }
}
