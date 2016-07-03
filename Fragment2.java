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
import android.util.Log;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private static final String LOG_TAG = Fragment1.class.getSimpleName();
    private List<Timetable> timetableList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TimeTableAdapter tadapter;
    private LinearLayoutManager mLinearLayoutManager;
    private ActionMode mActionMode;
    TimeTabledao timeTabledao = new TimeTabledao();
    List<Integer> finalSelectedItemId;
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.action_delete) {
                if (!timetableList.isEmpty()) {
                    for (int position : finalSelectedItemId) {

                        timeTabledao.deleteRecords(getContext(), timetableList.get(position).getId());
                        timetableList.remove(position);
                    }

                }
            }
            tadapter.notifyDataSetChanged();
            Toast.makeText(getContext(), "Delete", Toast.LENGTH_SHORT).show();
            init();
            mode.finish();
            return false;

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };


    public static Fragment2 newInsrance() {
        Fragment2 fragment2 = new Fragment2();
        return fragment2;

    }

    public Fragment2() {

    }

    private void init() {
        timetableList = timeTabledao.retrieveRecords(getContext());
        tadapter = new TimeTableAdapter(getActivity(), timetableList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tadapter);
        tadapter.setMultipleSelectAdapterCallback(new TimeTableAdapter.MultipleSelectAdapterCallback() {
            @Override
            public void itemClicked(int count, List<Integer> selectedItemId) {
                Log.d(LOG_TAG, "Clicked");
                if (count == 0 & mActionMode != null) {
                    mActionMode.finish();
                } else {
                    finalSelectedItemId = selectedItemId;
                    mActionMode = getActivity().startActionMode(mActionModeCallback);
                    mActionMode.setTitle("Selected Item #: " + count);

                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        timeTabledao.addRecords(getContext());

        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        //prepareTimeTableData();
        //timeTabledao.retrieveRecords(getContext());
        init();
        return rootView;

    }


}



