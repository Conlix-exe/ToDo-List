package com.example.todo_list.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.todo_list.MyListAdapter;
import com.example.todo_list.R;
import com.example.todo_list.data_types.Main_Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment {
    private ListView lv;
    Context mcontext;
    ArrayList<Main_Data> arrayList = new ArrayList<>();
    List<Integer> test = new ArrayList<>();
    MyListAdapter adapter;

    public Main(Context mcontext) {
        // Required empty public constructor
        test.add(123);
        arrayList.add(new Main_Data("test",1,"Task",test,test,false,false));
        this.mcontext = mcontext;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        super.onCreate(savedInstanceState);
        lv = view.findViewById(R.id.list);
        adapter = new MyListAdapter(mcontext, R.layout.row_main,arrayList);
        lv.setAdapter(adapter);

        return view;
    }
}