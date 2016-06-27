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




public class Fragment2 extends Fragment {
    private List<Timetable> timetableList= new ArrayList<>();
    private RecyclerView recyclerView;
    private TimeTableAdapter tadapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        recyclerView= (RecyclerView) rootView.findViewById(R.id.recycler_view);
        tadapter = new TimeTableAdapter(timetableList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tadapter);

        prepareTimeTableData();
        return rootView;

    }

    private void prepareTimeTableData()
    {
        Timetable event = new Timetable("MTL100", "lecture", "MR. Ritumoni", "LH108", "8 am to 9 am");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "MR. Msa", "LH111","9 am to 10 am");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "2r5", "yyyy", "11 am to 12noon");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "e15", "yyyy","12pm tp 1 pm");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "e15", "yyyy", "2 pm to 3 pm");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "2w", "yyyy","3pm to 4 pm");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "q5", "yyyy","4 pm to 5 pm");
        timetableList.add(event);

        event = new Timetable("Mad Max: Fury Road", "Action & Adventure", "v5", "yyyy", "7 pm to 8 pm");
        timetableList.add(event);

        tadapter.notifyDataSetChanged();
    }

}

