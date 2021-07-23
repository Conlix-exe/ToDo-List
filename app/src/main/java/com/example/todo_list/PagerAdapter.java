package com.example.todo_list;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.todo_list.fragments.Home;
import com.example.todo_list.fragments.Main;
import com.example.todo_list.fragments.Programming;
import com.example.todo_list.fragments.School;
import com.example.todo_list.fragments.Shopping;


public class PagerAdapter extends FragmentPagerAdapter {
    Context mcontext;
    int curent_position = -1;
    public PagerAdapter(FragmentManager fm, Context mcontext){
        super(fm);
        this.mcontext = mcontext;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Programming(mcontext);
            case 1:
                return new Home();
            case 2:
                return new Main(mcontext);
            case 3:
                return new School();
            case 4:
                return new Shopping();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}