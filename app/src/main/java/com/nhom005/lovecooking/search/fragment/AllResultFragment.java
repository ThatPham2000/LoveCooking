package com.nhom005.lovecooking.search.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.search.adapter.ResultSearchAdapter;
import com.nhom005.lovecooking.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class AllResultFragment extends Fragment {

    private static AllResultFragment instance = null;
    private ArrayList result = new ArrayList();

    private AllResultFragment() {
        // Required empty public constructor
    }

    public ArrayList getResult() {
        return result;
    }

    public void setResult(ArrayList result) {
        this.result = result;
    }

    public static AllResultFragment newInstance() {
        if(instance==null){
            instance = new AllResultFragment();
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
        ResultSearchAdapter adapter = new ResultSearchAdapter(Constants.allResult);
        lvResult.setAdapter(adapter);
        return view;
    }
}