package com.nhom005.lovecooking.fragment_menu;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.adapter.StoryAdapter;
import com.nhom005.lovecooking.models.Story;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView lvStory;
    StoryAdapter adapter;
    ArrayList<Story> stories = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setComponents(view);
        return view;
    }

    private void setComponents(View view) {
        lvStory = view.findViewById(R.id.lvStory);
        lvStory.setPaddingRelative(5, 0, 5, 0);
        adapter = new StoryAdapter(stories);
        lvStory.setAdapter(adapter);

        getDataStory();
        adapter.notifyDataSetChanged();
    }

    private void getDataStory() {
        stories.add(new Story(R.drawable.user1, R.drawable.mon1));
        stories.add(new Story(R.drawable.user2, R.drawable.mon2));
        stories.add(new Story(R.drawable.user3, R.drawable.mon3));
        stories.add(new Story(R.drawable.user4, R.drawable.mon4));
        stories.add(new Story(R.drawable.user5, R.drawable.mon5));
        stories.add(new Story(R.drawable.user6, R.drawable.mon6));
        stories.add(new Story(R.drawable.user7, R.drawable.mon7));
        stories.add(new Story(R.drawable.user8, R.drawable.mon8));
        stories.add(new Story(R.drawable.user9, R.drawable.mon9));
        stories.add(new Story(R.drawable.user10, R.drawable.mon10));
        stories.add(new Story(R.drawable.user11, R.drawable.mon11));
        stories.add(new Story(R.drawable.user1, R.drawable.mon12));
        stories.add(new Story(R.drawable.user2, R.drawable.mon13));
        stories.add(new Story(R.drawable.user3, R.drawable.mon29));
        stories.add(new Story(R.drawable.user4, R.drawable.mon14));
        stories.add(new Story(R.drawable.user5, R.drawable.mon15));
        stories.add(new Story(R.drawable.user6, R.drawable.mon16));
        stories.add(new Story(R.drawable.user7, R.drawable.mon17));
        stories.add(new Story(R.drawable.user8, R.drawable.mon24));
        stories.add(new Story(R.drawable.user9, R.drawable.mon25));
        stories.add(new Story(R.drawable.user10, R.drawable.mon23));
        stories.add(new Story(R.drawable.user11, R.drawable.mon27));
    }

}