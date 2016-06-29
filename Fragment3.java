package com.example.dell.intents;

/**
 * Created by DELL on 6/24/2016.
 */


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment {

    private RecyclerView recyclerView;
    MealMenuAdapter mealMenuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment3, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mealMenuAdapter = new MealMenuAdapter(initialiseData(), getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mealMenuAdapter);

        return rootView;


    }

    private List<Meal> meals;

    private List<Meal> initialiseData() {
        meals = new ArrayList<>();
        meals.add(new Meal("BREAKFAST", "7 AM ", " 9 AM ", R.drawable.breakfast_icon));
        meals.add(new Meal("LUNCH", "12 AM ", "2 PM ", R.drawable.lunch));
        meals.add(new Meal("DINNER", "7 PM ", " 9 PM ", R.drawable.dinner));
        return meals;
    }

}

