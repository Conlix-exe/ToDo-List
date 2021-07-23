package com.example.todo_list.data_types;

import java.util.List;

public class Data_Programming extends Main_Data{
    String projectname = "---";

    public Data_Programming(String type, int id, String task, List<Integer> deadline, List<Integer> creationtime, boolean today, boolean checked, String project_name) {
        super(type, id, task, deadline, creationtime, today, checked);
        this.projectname = project_name;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
}
