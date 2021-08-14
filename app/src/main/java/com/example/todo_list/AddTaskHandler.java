package com.example.todo_list;

import android.content.Context;

import com.example.todo_list.data_types.Data_Programming;
import com.example.todo_list.data_types.Main_Data;


public class AddTaskHandler {
    Context main_context;
    public AddTaskHandler(Context context) {
        main_context = context;
    }

    /*Get Add_task von MainActivity || AddTaskPopup
    Get objects of Fragments als Function parameter
    give Task to new Class SQL
    give Task to Specific Fragment
    Test the edit


        Get objects of Fragments als Function parameter
        give Task to new Class SQL
        give Task to Specific Fragment
         */

    public void add_task(Data_Programming new_task){
        Main_Data main_data = new Main_Data(new_task.getType(),new_task.getId(),new_task.getTask(),new_task.getDeadline(),new_task.getCreationtime(),new_task.isToday(),new_task.isChecked());

    }
}
