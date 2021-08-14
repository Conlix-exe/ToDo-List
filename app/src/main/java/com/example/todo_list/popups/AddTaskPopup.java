package com.example.todo_list.popups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todo_list.R;
import com.example.todo_list.data_types.Data_Programming;
import com.example.todo_list.fragments.Programming;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

public class AddTaskPopup extends Activity {
    EditText project_name_input, task_input, date_input, time_input;
    Button abort, add;

    int position;

    String creation_time;
    String creation_date;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_programming);

        final Intent intent = getIntent();
        position = intent.getIntExtra("position",2);

        switch (position){
            case 0:
                //project_name_input = findViewById(R.id.project_title_input);
        }

        project_name_input = findViewById(R.id.project_title_input);
        task_input = findViewById(R.id.task_input);
        date_input = findViewById(R.id.date_input);
        time_input = findViewById(R.id.time_input);

        abort = findViewById(R.id.abort);
        add = findViewById(R.id.add);

        //Create current time & day
        final Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH);
        final int day = cal.get(Calendar.DAY_OF_MONTH);

        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR_OF_DAY);
        final int minute = c.get(Calendar.MINUTE);

        //Create string of current date & time
        creation_date = year + "/" + month + "/" + year;
        creation_time = hour + ":" + minute;

        date_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatePickerDialog datePickerDialog = new DatePickerDialog(AddTaskPopup.this,android.R.style.Theme_Holo_Dialog_MinWidth,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                date_input.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        time_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Launch Time Picker Dialog

                TimePickerDialog timePickerDialog = new TimePickerDialog(AddTaskPopup.this,android.R.style.Theme_Holo_Dialog_MinWidth,

                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                time_input.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });

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
                        break;
                    case 1:
                        home();
                        break;
                    case 2:
                        main();
                        break;
                    case 3:
                        school();
                        break;
                    case 4:
                        shopping();
                        break;
                }
            }
        });
    }
    private void programming(){
        Intent result = new Intent();
        result.putExtra("type","Programming");

        String task = task_input.getText().toString();
        if (task.length() < 1){ task = "test"; }
        result.putExtra("task", task);

        String date = date_input.getText().toString();
        if (date.length() < 1){ date = "99/99/9999"; }
        result.putExtra("date", date);

        String time = time_input.getText().toString();
        if (time.length() < 1){ time = "99:99"; }
        result.putExtra("time", time);

        String project_name = project_name_input.getText().toString();
        if (project_name.length() < 1){ project_name = "no_name"; }
        result.putExtra("project_name", project_name);


        result.putExtra("creation_date", creation_date);
        result.putExtra("creation_time", creation_time);


        setResult(RESULT_OK, result);

        //Return newTask
        //Idea: map the input data
        //      List of Input data
        finish();


    }
    private void home(){}
    private void main(){}
    private void school(){}
    private void shopping(){}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "Works", Toast.LENGTH_LONG).show();
            }
        }
    }

}
