package com.nhom005.lovecooking.search;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.FeedNews;
import com.nhom005.lovecooking.models.User;
import com.nhom005.lovecooking.utils.Constants;

import java.util.Locale;

public class ResultSearchActivity extends AppCompatActivity {
    ViewPager2 viewPage2;
    TabLayout tabLayout;
    EditText searchKeyInput;
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        viewPage2 = findViewById(R.id.viewPage2);
        tabLayout = findViewById(R.id.tabLayout);
        searchKeyInput = findViewById(R.id.searchKeyInput);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(v->{
            onBackPressed();
        });

        PageSearchAdapter pageSearchAdapter = new PageSearchAdapter(this);
        viewPage2.setAdapter(pageSearchAdapter);
        new TabLayoutMediator(tabLayout, viewPage2, ((tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Tất cả");
                    break;
                case 1:
                    tab.setText("người dùng");
                    break;
                case 2:
                    tab.setText("Bài đăng");
                    break;
            }
        })).attach();

        receiverIntent();
    }

    private void receiverIntent() {
        String textSearch = getIntent().getStringExtra(Constants.KEY_TEXT_SEARCH);
        searchKeyInput.setText(textSearch);

        Constants.allResult.clear();
        Constants.userResult.clear();
        Constants.postResult.clear();

        for (User user: Constants.users) {
            if(user.name.toLowerCase(Locale.ROOT).contains(textSearch.toLowerCase(Locale.ROOT))){
                Constants.userResult.add(user);
                Constants.allResult.add(user);
            }
        }

        for (FeedNews feedNews: Constants.feedNews) {
            if(feedNews.title.toLowerCase(Locale.ROOT).contains(textSearch.toLowerCase(Locale.ROOT))){
                Constants.postResult.add(feedNews);
                Constants.allResult.add(feedNews);
            }
        }
    }
}