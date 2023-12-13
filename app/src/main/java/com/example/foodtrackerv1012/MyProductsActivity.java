package com.example.foodtrackerv1012;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
package com.example.foodtrackerv1012;
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
        ProductRepository repo = new ProductRepository();
        ArrayList<Product> products =repo.retrieveAllProducts();
        ArrayList<String> productnames = new ArrayList<>();
        ArrayList<String> productFreshness = new ArrayList<>();
        ArrayList<String> expirationDate = new ArrayList<>();

        for(int i= 0;i<products.size();i++) {
            productnames.set(i,products.get(i).getName());
            expirationDate.set(i, products.get(i).getExpirationDate().toString());

        }



        for (int i = 0;i<productnames.size();i++) {
            models.add(new ProductModel(productnames[i],productFreshness[i],expirationDate[i]));
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        RecyclerView ğ = findViewById(R.id.recyclerView);
        setProductModels();
        Recyclerviewadapter adapter = new Recyclerviewadapter(this,new ArrayList<>());
        ğ.setAdapter(adapter);
        ğ.setLayoutManager(new LinearLayoutManager(this));
    }
}
