package com.example.todo_list;

import android.content.Context;

import com.example.todo_list.data_types.Data_Programming;
import com.example.todo_list.data_types.Main_Data;

import java.util.List;


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
    Test from the Tablet
    


        Get objects of Fragments als Function parameter
        give Task to new Class SQL
        give Task to Specific Fragment
         */

    public void add_task(String type,int id, String task, List<Integer> deadline, String project_name){
        //Main_Data main_data = new Main_Data(type,id,task,deadline,new_task.getCreationtime(),new_task.isToday(),new_task.isChecked());

    }
}
