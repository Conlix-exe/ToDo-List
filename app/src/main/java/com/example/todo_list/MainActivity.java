package com.example.todo_list;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.todo_list.fragments.Programming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int position,highestID = 0;
    TabLayout tabbar;
    FloatingActionButton addtask;
    PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabbar = findViewById(R.id.tabBar);
        TabItem programming = findViewById(R.id.programming);
        addtask = findViewById(R.id.addtask);
        //TabItems...
        final ViewPager viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(pagerAdapter);
        tabbar.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(2);
        tabbar.getTabAt(0).setIcon(R.drawable.ic_test);
        tabbar.getTabAt(1).setIcon(R.drawable.ic_home);
        tabbar.getTabAt(2).setIcon(R.drawable.ic_main);
        tabbar.getTabAt(3).setIcon(R.drawable.ic_school);
        tabbar.getTabAt(4).setIcon(R.drawable.ic_schopping);

        addtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,Integer.toString(viewPager.getCurrentItem()),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,AddTaskPopup.class);
                intent.putExtra("position",viewPager.getCurrentItem());
                startActivityForResult(intent,1);

            }
        });

    }//Implement List Adapter

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                highestID++;
                Programming programming = PagerAdapter.getProgramming();
                List<Integer> time = new ArrayList<>();
                //time.add(1233);
                //time.add(1133);
                time.add(Integer.parseInt(data.getStringExtra("time")));
                time.add(Integer.parseInt(data.getStringExtra("date")));
                Toast.makeText(this,data.getStringExtra("date"), Toast.LENGTH_LONG).show();
                programming.addtask(highestID,data.getStringExtra("task"),time,data.getStringExtra("project_name"));
            }
        }
    }
    //AddTaskHandler einbinden & Fragments übergeben
}