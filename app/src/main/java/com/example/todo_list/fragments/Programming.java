package com.example.todo_list.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.todo_list.ListAdapters.ListAdapter_Programming;
import com.example.todo_list.R;
import com.example.todo_list.data_types.Data_Programming;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.round;

/**
 * A simple {@link Fragment} subclass.
 */
public class Programming extends Fragment {

    private ListView lv;
    Context mcontext;
    //ArrayList<String> mylist = new ArrayList<>();
    ArrayList<Data_Programming> arrayList = new ArrayList<>();
    List<Integer> test = new ArrayList<>();
    ListAdapter_Programming adapter;

    public Programming(Context mcontext) {
        // Sets Context to MainActivity.this
        //mylist.add("Test");
        test.add(123);
        test.add(123);
        test.add(123);
        arrayList.add(new Data_Programming("test",1,"Task",test,test,false,false,"Project"));
        this.mcontext = mcontext;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // Inflate the layout for this fragment

        super.onCreate(savedInstanceState);
        lv = view.findViewById(R.id.list);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mcontext, android.R.layout.simple_list_item_1, mylist);
        //lv.setAdapter(arrayAdapter);
        adapter = new ListAdapter_Programming(mcontext, R.layout.row_programming,arrayList);
        lv.setAdapter(adapter);

        return view;
    }


    public void addtask(int id, String task, List<Integer> deadline, String project_name){

        String type = "programming";
        boolean today = false;
        boolean checked = false;

        Date date = new Date();

        List<Integer> creationtime = new ArrayList<>();
        //List<Integer> creationday = new ArrayList<>();
        creationtime.add(date.getDay());
        creationtime.add(round(date.getTime()));
        Data_Programming newtask = new Data_Programming(type,id,task,deadline,creationtime,today,checked,project_name);
        arrayList.add(newtask);


        Toast.makeText(mcontext,date.getDate()+"", Toast.LENGTH_LONG).show();
        //arrayList.add(new Data_Programming("test",1,"Task",test,test,false,false,"Project"));
    }
}