package com.example.todo_list.data_types;

import java.util.ArrayList;
import java.util.List;

public class Main_Data {
    String type = "---";
    int id = -1;
    String task = "---";
    List<Integer> deadline = new ArrayList<>();
    List<Integer> creationtime = new ArrayList<>();
    boolean today = false;
    boolean checked = false;

    public Main_Data(String type, int id, String task, List<Integer> deadline, List<Integer> creationtime, boolean today, boolean checked) {
        this.type = type;
        this.id = id;
        this.task = task;
        this.deadline = deadline;
        this.creationtime = creationtime;
        this.today = today;
        this.checked = checked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public List<Integer> getDeadline() {
        return deadline;
    }

    public void setDeadline(List<Integer> deadline) {
        this.deadline = deadline;
    }

    public List<Integer> getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(List<Integer> creationtime) {
        this.creationtime = creationtime;
    }

    public boolean isToday() {
        return today;
    }

    public void setToday(boolean today) {
        this.today = today;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}