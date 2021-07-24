package com.example.todo_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.todo_list.data_types.Data_Programming;

import java.util.ArrayList;
import java.util.List;

public class AddTaskPopup extends Activity {
    EditText project_name_input, task_input, date_input, time_input;
    Button abort, add;
    int position;

    List<Integer> day = new ArrayList<>();
    List<Integer> time = new ArrayList<>();
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_programming);

        final Intent intent = getIntent();
        position = intent.getIntExtra("position",2);

        switch (position){
            case 0:
                project_name_input = findViewById(R.id.project_title_input);
        }

        task_input = findViewById(R.id.task_input);
        date_input = findViewById(R.id.date_input);
        time_input = findViewById(R.id.time_input);

        abort = findViewById(R.id.abort);
        add = findViewById(R.id.add);

        abort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                setResult(RESULT_CANCELED,result);
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        programming();
                    case 1:
                        home();
                    case 2:
                        main();
                    case 3:
                        school();
                    case 4:
                        shopping();
                }
            }
        });
    }
    private void programming(){

        String fulldate = date_input.getText().toString();
        int day = Integer.parseInt(fulldate.substring(0,1));
        int month = Integer.parseInt(fulldate.substring(2));
        List<Integer> date_list = new ArrayList<>();
        date_list.add(day);
        date_list.add(month);



        String fulltime = time_input.getText().toString();
        //Fix the Time splitter
        int hour = Integer.parseInt(fulltime.substring(0,1));
        int min = Integer.parseInt(fulltime.substring(2));
        time.add(hour);
        time.add(min);
        List<Integer> time_list = new ArrayList<>();
        time_list.add(hour);
        time_list.add(min);
        Data_Programming newtask = new Data_Programming("Programming",-1,task_input.getText().toString(),time_list,date_list,false,false,project_name_input.getText().toString());
        ArrayList<Data_Programming> retask = new ArrayList<>();
        retask.add(newtask);
        Intent result = new Intent();
        //result.putExtra("newtasklist",retask);
        //setResult(RESULT_CANCELED, result);

        //Return newTask
        //Idea: map the input data
        //      List of Input data
        finish();
    }
    private void home(){}
    private void main(){}
    private void school(){}
    private void shopping(){}

}
