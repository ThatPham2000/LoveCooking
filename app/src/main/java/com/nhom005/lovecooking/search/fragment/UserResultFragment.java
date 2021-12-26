package com.nhom005.lovecooking.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.search.adapter.ResultSearchAdapter;
import com.nhom005.lovecooking.utils.Constants;

import java.util.ArrayList;

public class UserResultFragment extends Fragment {

    private static UserResultFragment instance = null;
    public  ResultSearchAdapter adapter;

    public static UserResultFragment newInstance() {
        if(instance==null){
            instance = new UserResultFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_result, container, false);
        RecyclerView lvResult = view.findViewById(R.id.lvResult);
        adapter = new ResultSearchAdapter(Constants.userResult);
        lvResult.setAdapter(adapter);
        return view;
    }
}