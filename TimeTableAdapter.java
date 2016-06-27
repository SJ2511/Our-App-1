package com.example.dell.intents;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by DELL on 6/27/2016.
 */
public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyViewHolder>
{
    private List<Timetable> timetableList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView course, type, faculty, venue, time;


        public MyViewHolder(View itemView) {
            super(itemView);
            course= (TextView) itemView.findViewById(R.id.course);
            type= (TextView) itemView.findViewById(R.id.type);
            faculty= (TextView) itemView.findViewById(R.id.faculty);
            venue= (TextView) itemView.findViewById(R.id.venue);
            time= (TextView) itemView.findViewById(R.id.time);
        }
    }
    public TimeTableAdapter(List<Timetable> timetableList)
    {
        this.timetableList= timetableList;
    }

    @Override
    public TimeTableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.timetable_list_row, parent,false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TimeTableAdapter.MyViewHolder holder, int position)
    {
        Timetable timetable=timetableList.get(position);
        holder.course.setText(timetable.getCourse());
        holder.type.setText(timetable.getType());
        holder.faculty.setText(timetable.getFaculty());
        holder.venue.setText(timetable.getVenue());
        holder.time.setText(timetable.getTime());
    }

    @Override
    public int getItemCount() {
        return timetableList.size();
    }
}