package com.example.todo_list.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.todo_list.R;

class MyListAdapter extends BaseAdapter {
    Context context;
    String[] data;
    private static LayoutInflater inflater = null;
    public MyListAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Object getItem(int position){
        return data[position];
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        EditText text = (EditText) vi.findViewById(R.id.editText);
        text.setText(data[position]);
        return vi;
    }
}
