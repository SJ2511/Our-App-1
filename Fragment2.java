package com.example.dell.intents;

/**
 * Created by DELL on 6/24/2016.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
        import android.net.Uri;
        import android.os.Bundle;

        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import com.example.dell.intents.TimeTableAdapter;
import com.example.dell.intents.Timetable;


public class Fragment2 extends Fragment {
    private List<Timetable> timetableList= new ArrayList<>();
    private RecyclerView recyclerView;
    private TimeTableAdapter tadapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        recyclerView= (RecyclerView) rootView.findViewById(R.id.recycler_view);
        tadapter = new TimeTableAdapter(getActivity(),timetableList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tadapter);

        prepareTimeTableData();
        return rootView;

    }

    private void prepareTimeTableData()
    {
        Timetable event = new Timetable("MTL100", "lecture", "MR. Ritumoni", "LH108", "8 AM"," 9 AM");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "MR. Msa", "LH111","9 AM" , "10 AM");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "2r5", "yyyy", "11 AM", "12 PM");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "e15", "yyyy","12 PM" ," 1 PM");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "e15", "yyyy", "2 PM","3 PM");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "2w", "yyyy","3 PM"," 4 PM");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "q5", "yyyy","4 PM","5 PM");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "v5", "yyyy", "7 PM","8 PM");
        timetableList.add(event);

        tadapter.notifyDataSetChanged();
    }

}

