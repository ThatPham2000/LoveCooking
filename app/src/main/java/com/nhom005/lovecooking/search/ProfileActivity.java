package com.nhom005.lovecooking.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.User;
import com.nhom005.lovecooking.utils.Constants;

public class ProfileActivity extends AppCompatActivity {
    ImageView backBtn, avatar;
    TextView userName, workTxt, educationTxt, websiteTxt;
    Button followBtn, unfollowBtn;
    ScrollView layoutScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        backBtn = findViewById(R.id.backActivityBtn);
        avatar = findViewById(R.id.avatar);
        userName = findViewById(R.id.userName);
        workTxt = findViewById(R.id.workTxt);
        educationTxt = findViewById(R.id.educationTxt);
        websiteTxt = findViewById(R.id.websiteTxt);
        followBtn = findViewById(R.id.followBtn);
        unfollowBtn = findViewById(R.id.unfollowBtn);
        layoutScroll = findViewById(R.id.layoutScroll);

//        layoutScroll.pageScroll(View.SCROLL_INDICATOR_TOP);

        backBtn.setOnClickListener(v -> {
            onBackPressed();
        });
        followBtn.setOnClickListener(v -> {
            unfollowBtn.setVisibility(View.VISIBLE);
            followBtn.setVisibility(View.GONE);
        });
        unfollowBtn.setOnClickListener(v -> {
            unfollowBtn.setVisibility(View.GONE);
            followBtn.setVisibility(View.VISIBLE);
        });

        User user = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        avatar.setImageResource(user.avatar);
        userName.setText(user.name);
        workTxt.setText(user.work);
        educationTxt.setText(user.education);
        websiteTxt.setText(user.website);
    }
}