package com.example.dell.intents;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageButton;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by DELL on 6/27/2016.
 */
public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyViewHolder> {
    private Context context;
    private List<Timetable> timetableList;
    private MultipleSelectAdapterCallback mMultipleSelectAdapterCallback;
    private static final String LOG_TAG = "TimeTableAdapter";

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

        public TextView course, type, faculty, venue, fromtime, totime;
        public CardView cardView;
        public ImageButton mExpandButton;


        public MyViewHolder(View itemView) {
            super(itemView);
            course = (TextView) itemView.findViewById(R.id.course);
            type = (TextView) itemView.findViewById(R.id.type);
            faculty = (TextView) itemView.findViewById(R.id.faculty);
            venue = (TextView) itemView.findViewById(R.id.venue);
            fromtime = (TextView) itemView.findViewById(R.id.fromtime);
            totime = (TextView) itemView.findViewById(R.id.totime);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            Log.d(LOG_TAG, "Clicked");
            if (mMultipleSelectAdapterCallback != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                int clickedPosition = getAdapterPosition();
                Timetable clickedItem = timetableList.get(clickedPosition);
                if (clickedItem.isChecked()) {
                    clickedItem.setChecked(false);
                } else {
                    clickedItem.setChecked(true);
                }
                notifyItemChanged(clickedPosition);
                timetableList.get(clickedPosition).setPosition(clickedPosition);
                SelectedItem selectedItem = getSelectedItem();
                Log.d(LOG_TAG, "count selected item: " + selectedItem.getCount() + " selected item ID list: " + selectedItem.getSelectedItemIds());
                mMultipleSelectAdapterCallback.itemClicked(selectedItem.getCount(), selectedItem.getSelectedItemIds());
            }
            return true;
        }
    }

    private SelectedItem getSelectedItem() {
        SelectedItem selectedItem = new SelectedItem();
        int counter = 0;
        if (timetableList != null) {
            for (Timetable item : timetableList) {
                if (item.isChecked()) {
                    counter++;
                    selectedItem.addItemIds(item.getPosition());
                }
            }
        }
        selectedItem.setCount(counter);

        return selectedItem;
    }

    public interface MultipleSelectAdapterCallback {
        public void itemClicked(int count, List<Integer> selectedItemId);
    }

    public MultipleSelectAdapterCallback getMultipleSelectAdapterCallback() {
        return mMultipleSelectAdapterCallback;
    }

    public void setMultipleSelectAdapterCallback(MultipleSelectAdapterCallback multipleSelectAdapterCallback) {
        mMultipleSelectAdapterCallback = multipleSelectAdapterCallback;
    }


    public TimeTableAdapter(Context context, List<Timetable> timetableList) {
        this.timetableList = timetableList;
        this.context = context;
    }


    @Override
    public TimeTableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(LOG_TAG, "ON create view holder " + viewType);

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.timetable_list_row, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TimeTableAdapter.MyViewHolder holder, int position) {
        Timetable timetable = timetableList.get(position);
        holder.course.setText(timetable.getCourse());
        holder.type.setText(timetable.getType());
        holder.faculty.setText(timetable.getFaculty());
        holder.venue.setText(timetable.getVenue());
        holder.fromtime.setText(timetable.getFromtime());
        holder.totime.setText(timetable.getTotime());


        //int toTime =Integer.parseInt(timetable.getFromtime().substring(0,1));
        DateTimeFormatter parseFormat = new DateTimeFormatterBuilder().appendPattern("h a").toFormatter();
        LocalTime localTime = LocalTime.parse(timetable.getFromtime(), parseFormat);
        DateTimeFormatter outputFormat = new DateTimeFormatterBuilder().appendPattern("H").toFormatter();
        int toTime = Integer.parseInt(localTime.toString(outputFormat));

        Log.d("Time", timetable.getFromtime() + " int" + String.valueOf(toTime));
        if (timetable.isChecked()) {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.mediumpurple));
        } else {
            holder.cardView.setCardBackgroundColor(getColorAccTime(toTime));
        }

    }

    @Override
    public int getItemCount() {
        return timetableList.size();
    }

    public int getColorAccTime(int time) {
        int color = 0;
        if (time <= 12) {
            color = context.getResources().getColor(R.color.snuff);
        } else if (time > 12 && time < 17) {
            color = context.getResources().getColor(R.color.mediumpurple);
        } else if (time > 17) {
            color = context.getResources().getColor(R.color.spray);
        }

        return color;
    }

    private class SelectedItem {

        private int mCount;
        private List<Integer> mSelectedItemIds = new ArrayList<>();

        private void addItemIds(int id) {
            mSelectedItemIds.add(id);
        }

        public int getCount() {
            return mCount;
        }

        public void setCount(int count) {
            mCount = count;
        }

        public List<Integer> getSelectedItemIds() {
            return mSelectedItemIds;
        }
    }


}