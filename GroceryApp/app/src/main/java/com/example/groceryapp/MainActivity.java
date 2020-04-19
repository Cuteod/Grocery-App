package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText editText, editText2;
    private Button button;
    String string;
    Integer integer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.ImgGrocery);
        editText = findViewById(R.id.editText);
        editText = findViewById(R.id.editText2);
        button = findViewById(R.id.BtnImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MainActivity.this, GroceryItem.class));
               string = editText.getText().toString();
                i.putExtra("value", string);
                //editText2.setRawInputType(Configuration.KEYBOARDHIDDEN_YES);

                startActivity(i);
                finish();

                //saveDeal();
            }
        });

    }


    private void saveDeal(){
        String mNames = editText.getText().toString();
        String mPrices = editText2.getText().toString();
       // GroceryItem item = new GroceryItem();


    }
}
