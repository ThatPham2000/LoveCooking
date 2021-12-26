package com.nhom005.lovecooking.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.adapter.HistoryFoodSearchAdapter;
import com.nhom005.lovecooking.adapter.HistoryUserAdapter;
import com.nhom005.lovecooking.models.User;
import com.nhom005.lovecooking.utils.Constants;

public class SearchActivity extends AppCompatActivity {
    LinearLayout historyLayout;
    TextView deleteAllBtn;
    RecyclerView lvUserSearch, lvFoodSearch;
    EditText searchKeyInput;
    View view;
    ImageView backBtn;

    HistoryUserAdapter historyUserAdapter;
    HistoryFoodSearchAdapter historyFoodSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setComponents();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setComponents() {
        historyLayout = findViewById(R.id.historyLayout);
        deleteAllBtn = findViewById(R.id.deleteAllBtn);
        lvUserSearch = findViewById(R.id.lvUserSearch);
        lvFoodSearch = findViewById(R.id.lvFoodSearch);
        searchKeyInput = findViewById(R.id.searchKeyInput);
        view = findViewById(R.id.view);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(v->{
            onBackPressed();
        });

        deleteAllBtn.setOnClickListener(v -> {
            Constants.historyUser.clear();
            Constants.historyTextSearch.clear();
            historyUserAdapter.notifyDataSetChanged();
            historyFoodSearchAdapter.notifyDataSetChanged();
            checkVisibleLayout();
        });

        lvUserSearch.setPadding(10, 0, 10, 0);
        historyUserAdapter = new HistoryUserAdapter(Constants.historyUser);
        lvUserSearch.setAdapter(historyUserAdapter);

        historyFoodSearchAdapter = new HistoryFoodSearchAdapter(Constants.historyTextSearch);
        lvFoodSearch.setAdapter(historyFoodSearchAdapter);

        searchKeyInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String keySearch = searchKeyInput.getText().toString();
                    Constants.historyTextSearch.add(keySearch);

                    historyFoodSearchAdapter.notifyDataSetChanged();

                    Intent intent = new Intent(getApplicationContext(), ResultSearchActivity.class);
                    intent.putExtra(Constants.KEY_TEXT_SEARCH, keySearch);
                    startActivity(intent);
                    handled = true;
                }
                return handled;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkVisibleLayout();
    }

    private void checkVisibleLayout() {
        if (Constants.historyTextSearch.isEmpty() && Constants.historyUser.isEmpty()) {
            historyLayout.setVisibility(View.GONE);
        } else {
            historyLayout.setVisibility(View.VISIBLE);
            if (Constants.historyUser.isEmpty()) {
                view.setVisibility(View.GONE);
                lvUserSearch.setVisibility(View.GONE);
            } else {
                view.setVisibility(View.VISIBLE);
                lvUserSearch.setVisibility(View.VISIBLE);
            }
        }
    }
}