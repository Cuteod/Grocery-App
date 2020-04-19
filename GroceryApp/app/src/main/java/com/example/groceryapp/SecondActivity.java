package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if (getIntent().hasExtra("name")&& getIntent().hasExtra("price")){
            Log.d(TAG, "getIncomingIntent: found intent extra.");

            String name = getIntent().getStringExtra("name");
            String price = getIntent().getStringExtra("price");

            setText(name, price);

        }
    }

    private void setText(String name, String price){
        Log.d(TAG, "setText: setting text to name and prices");
        TextView textView = findViewById(R.id.name);
        textView.setText(name);

        TextView textView1 = findViewById(R.id.TxtPrice);
        textView1.setText(price);
    }
}
