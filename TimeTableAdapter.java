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

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.List;


/**
 * Created by DELL on 6/27/2016.
 */
public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyViewHolder>
{
    private  Context context;
    private List<Timetable> timetableList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView course, type, faculty, venue, fromtime,totime;
        public CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);
            course= (TextView) itemView.findViewById(R.id.course);
            type= (TextView) itemView.findViewById(R.id.type);
            faculty= (TextView) itemView.findViewById(R.id.faculty);
            venue= (TextView) itemView.findViewById(R.id.venue);
            fromtime= (TextView) itemView.findViewById(R.id.fromtime);
            totime=(TextView) itemView.findViewById(R.id.totime);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
        }
    }
    public TimeTableAdapter(Context context, List<Timetable> timetableList)
    {
        this.timetableList= timetableList;
        this.context = context;
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
        holder.fromtime.setText(timetable.getFromtime());
        holder.totime.setText(timetable.getTotime());

        //int toTime =Integer.parseInt(timetable.getFromtime().substring(0,1));
        DateTimeFormatter parseFormat = new DateTimeFormatterBuilder().appendPattern("h a").toFormatter();
        LocalTime localTime = LocalTime.parse(timetable.getFromtime(), parseFormat);
        DateTimeFormatter outputFormat = new DateTimeFormatterBuilder().appendPattern("H").toFormatter();
        int toTime = Integer.parseInt(localTime.toString(outputFormat));

        Log.d("Time", timetable.getFromtime() + " int" + String.valueOf(toTime));

        holder.cardView.setCardBackgroundColor(getColorAccTime(toTime));
    }

    @Override
    public int getItemCount() {
        return timetableList.size();
    }

    public int getColorAccTime(int time)
    {
        int color = 0;
        if(time<=12)
        {
            color=  context.getResources().getColor(R.color.snuff);
        }
        else if(time>12&&time<17) {
            color=  context.getResources().getColor(R.color.mediumpurple);
        }
        else if(time>17)
        {
            color=  context.getResources().getColor(R.color.spray);
        }

    return color;
    }
}