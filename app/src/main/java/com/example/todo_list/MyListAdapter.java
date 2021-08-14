package com.example.todo_list;

import android.content.Context;
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

import com.example.todo_list.data_types.Main_Data;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Main_Data> {
    private Context rcontext;
    private int rresouce;

    public MyListAdapter(@NonNull Context context, int resource, @NonNull List<Main_Data> objects) {
        super(context, resource,(List<Main_Data>) objects);
        this.rcontext = context;
        this.rresouce = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(rcontext);
        convertView = layoutInflater.inflate(rresouce, parent, false);

        LinearLayout background = (LinearLayout) convertView.findViewById(R.id.background);
        TextView task = (TextView) convertView.findViewById(R.id.task);
        EditText deadline_date = (EditText) convertView.findViewById(R.id.deadline_date);
        EditText deadline_time = (EditText) convertView.findViewById(R.id.deadline_time);
        Switch today = (Switch) convertView.findViewById(R.id.today);

        task.setText(getItem(position).getTask());
        deadline_date.setText(Integer.toString(getItem(position).getCreationtime().get(0)));
        deadline_time.setText(Integer.toString(getItem(position).getCreationtime().get(1)));

        //deadline_time.setText(1234+"");
        today.setChecked(getItem(position).isToday());


        return convertView;
    }
}
