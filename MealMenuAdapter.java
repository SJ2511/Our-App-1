package com.example.dell.intents;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by DELL on 6/28/2016.
 */
public class MealMenuAdapter extends RecyclerView.Adapter<MealMenuAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CardView cardView;
        public TextView fromtime, totime, mealtype;
        public ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            fromtime = (TextView) itemView.findViewById(R.id.fromtime);
            totime = (TextView) itemView.findViewById(R.id.totime);
            mealtype = (TextView) itemView.findViewById(R.id.mealheading);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(activity, Onclick_Cardview.class);
            activity.startActivity(intent);

        }


    }

    List<Meal> meals;
    static Activity activity;

    MealMenuAdapter(List<Meal> meals, Activity activity) {
        this.meals = meals;
        this.activity = activity;
    }

    @Override
    public MealMenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mealmenu_list_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MealMenuAdapter.MyViewHolder holder, int position) {
        holder.mealtype.setText(meals.get(position).getMealType());
        holder.fromtime.setText(meals.get(position).getFromtime());
        holder.totime.setText(meals.get(position).getTotime());
        holder.icon.setImageResource(meals.get(position).getIcon_id());

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
