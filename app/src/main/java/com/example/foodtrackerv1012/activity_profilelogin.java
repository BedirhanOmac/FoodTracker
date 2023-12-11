package com.example.foodtrackerv1012;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_profilelogin extends AppCompatActivity {
    private static String currentname;
    private static String currentsurName;
    private static int currentage;
    private static double currentweight;
    private static double currentheight;
    private static String currentallergens;
    private static String currentunwantedIngredients;
    private static String currentgender;
    private static String currentdailyActivityLevel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilelogin);

        TextView pinfo = findViewById(R.id.btnPersonalInformation);
        @SuppressLint("WrongViewCast") Button cont = findViewById(R.id.linearRowcontinue);


        pinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_profilelogin.this, activity_profiledietinfo.class);
                startActivity(intent);
            }
        });

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User u1 = new User(currentname,currentsurName,currentage,currentweight,currentheight,currentgender,currentdailyActivityLevel,currentallergens,currentunwantedIngredients);

                Intent intent = new Intent(activity_profilelogin.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public static double getCurrentheight() {
        return currentheight;
    }

    public static double getCurrentweight() {
        return currentweight;
    }

    public static int getCurrentage() {
        return currentage;
    }

    public static String getCurrentallergens() {
        return currentallergens;
    }

    public static String getCurrentdailyActivityLevel() {
        return currentdailyActivityLevel;
    }

    public static String getCurrentgender() {
        return currentgender;
    }

    public static String getCurrentname() {
        return currentname;
    }

    public static String getCurrentsurName() {
        return currentsurName;
    }

    public static String getCurrentunwantedIngredients() {
        return currentunwantedIngredients;
    }

    public static void setCurrentage(int currentage) {
        activity_profilelogin.currentage = currentage;
    }

    public static void setCurrentallergens(String currentallergens) {
        activity_profilelogin.currentallergens = currentallergens;
    }

    public static void setCurrentdailyActivityLevel(String currentdailyActivityLevel) {
        activity_profilelogin.currentdailyActivityLevel = currentdailyActivityLevel;
    }

    public static void setCurrentgender(String currentgender) {
        activity_profilelogin.currentgender = currentgender;
    }

    public static void setCurrentheight(double currentheight) {
        activity_profilelogin.currentheight = currentheight;
    }

    public static void setCurrentname(String currentname) {
        activity_profilelogin.currentname = currentname;
    }

    public static void setCurrentsurName(String currentsurName) {
        activity_profilelogin.currentsurName = currentsurName;
    }

    public static void setCurrentunwantedIngredients(String currentunwantedIngredients) {
        activity_profilelogin.currentunwantedIngredients = currentunwantedIngredients;
    }

    public static void setCurrentweight(double currentweight) {
        activity_profilelogin.currentweight = currentweight;
    }
}
