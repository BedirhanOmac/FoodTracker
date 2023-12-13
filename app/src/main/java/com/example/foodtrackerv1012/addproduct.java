package com.example.foodtrackerv1012;

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
import java.sql.Date;
import java.util.ArrayList;

public class addproduct extends AppCompatActivity{
    private ProductRepository r1= new ProductRepository();
    private static String name;
    private static Date expirationDate;
    private static String photo;
    private static Date purchaseDate;
    private static ArrayList<String> ingredients;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproduct);

        View rectangle_ = findViewById(R.id.rectangle_);
        View rectangle_2 = findViewById(R.id.rectangle_2);
        View rectangle_3 = findViewById(R.id.rectangle_2);
        View back = findViewById(R.id.imageView2);

        rectangle_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                r1.insertOrUpdateProductData(new Product(name,expirationDate,photo,purchaseDate,ingredients));
            }
        });

        rectangle_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addproduct.this, OCRactivity.class);
                startActivity(intent);
            }
        });

        rectangle_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addproduct.this, OCRactivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addproduct.this, MyProductsActivity.class);
                startActivity(intent);

            }
        });
    }
}
