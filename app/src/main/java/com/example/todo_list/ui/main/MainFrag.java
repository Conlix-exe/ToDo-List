package com.example.todo_list.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.todo_list.R;

public class MainFrag extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView listView;
    private PageViewModel pageViewModel;
    private int position;

    public static com.example.todo_list.ui.main.PlaceholderFragment newInstance(int index) {
        com.example.todo_list.ui.main.PlaceholderFragment fragment = new com.example.todo_list.ui.main.PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_frag, container, false);
        //listView = root.findViewById(R.id.listview);
        //listView.setAdapter(new MyListAdapter(getActivity(), new String[]{"Test", "Tetst2"}));
        /*
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        return root;
    }

}
