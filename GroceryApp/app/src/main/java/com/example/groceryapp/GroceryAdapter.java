package com.example.groceryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.ViewHolder>  {

    private static final String TAG = "GroceryAdapter";

    private ArrayList<String> mItemNames = new ArrayList<>();
    private ArrayList<String>mItemPrices = new ArrayList<>();
    private Context mContext;

    public GroceryAdapter(ArrayList<String>itemName, ArrayList<String> itemPrices, Context context){
        mItemNames =itemName;
        mItemPrices = itemPrices;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_grocery_item,parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");
        holder.itemName.setText(mItemNames.get(position));
        holder.itemPrice.setText(mItemPrices.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + mItemNames.get(position) + mItemPrices.get(position));
                Toast.makeText(mContext, mItemNames.get(position), LENGTH_SHORT).show();
                Toast.makeText(mContext, mItemPrices.get(position), LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, SecondActivity
                .class);
                intent.putExtra("name", mItemNames.get(position));
                intent.putExtra("price", mItemPrices.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        TextView itemPrice;
        CardView cardView;

        public ViewHolder( View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.txtItem);
            itemPrice = itemView.findViewById(R.id.edPrice);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
