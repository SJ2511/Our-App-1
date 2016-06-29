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


public class Fragment1 extends Fragment {
    private RecyclerView recyclerView;
    private List<Event> eventList = new ArrayList<>();
    private EventsAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        mAdapter = new EventsAdapter(getActivity(),eventList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(mAdapter);

        prepareEventData();
        return rootView;
    }



    private void prepareEventData() {
        Event event = new Event("Mad Max: Fury Road", "Action & Adventure", "2015", "yyyy");
        eventList.add(event);

        event = new Event("Mad Max: Fury Road", "Action & Adventure", "w5", "yyyy");
        eventList.add(event);

        event = new Event("Mad Max: Fury Road", "Action & Adventure", "2r5", "yyyy");
        eventList.add(event);

        event = new Event("Mad Max: Fury Road", "Action & Adventure", "e15", "yyyy");
        eventList.add(event);

        event = new Event("Mad Max: Fury Road", "Action & Adventure", "e15", "yyyy");
        eventList.add(event);

        event = new Event("Mad Max: Fury Road", "Action & Adventure", "2w", "yyyy");
        eventList.add(event);

        event = new Event("Mad Max: Fury Road", "Action & Adventure", "q5", "yyyy");
        eventList.add(event);

        event = new Event("Mad Max: Fury Road", "Action & Adventure", "v5", "yyyy");
        eventList.add(event);


        mAdapter.notifyDataSetChanged();
    }
}




