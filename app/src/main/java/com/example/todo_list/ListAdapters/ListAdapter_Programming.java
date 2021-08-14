package com.example.todo_list.ListAdapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todo_list.R;
import com.example.todo_list.data_types.Data_Programming;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter_Programming extends ArrayAdapter<Data_Programming>  {
    private Context rcontext;
    private int rresouce;

    public ListAdapter_Programming(@NonNull Context context, int resource, @NonNull List<Data_Programming> objects) {
        super(context, resource, (List<Data_Programming>) objects);
        this.rcontext = context;
        this.rresouce = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(rcontext);
        convertView = layoutInflater.inflate(rresouce, parent, false);

        LinearLayout background = (LinearLayout) convertView.findViewById(R.id.background);
        TextView task = (TextView) convertView.findViewById(R.id.task);
        TextView projekt_title = (TextView) convertView.findViewById(R.id.project_title);
        EditText deadline_date = (EditText) convertView.findViewById(R.id.deadline_date);
        EditText deadline_time = (EditText) convertView.findViewById(R.id.deadline_time);
        Switch today = (Switch) convertView.findViewById(R.id.today);


        projekt_title.setText(getItem(position).getProjectname());
        task.setText(getItem(position).getTask());
        deadline_date.setText(getItem(position).getDeadline().get(0)+":"+ getItem(position).getDeadline().get(1));
        //Log.println(Log.ERROR,"data",Integer.toString(getItem(position).getDeadline().get(1))+Integer.toString(getItem(position).getDeadline().get(2)));

        List<Integer> day = getItem(position).getDeadline();
        deadline_time.setText(day.get(2)+"."+day.get(3)+"."+day.get(4));
        today.setChecked(getItem(position).isToday());


        return convertView;
    }
}
