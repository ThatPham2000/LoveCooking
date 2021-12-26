package com.nhom005.lovecooking.search.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.nhom005.lovecooking.R;

public class UserResultHolder extends ResultViewHolder {
    ImageView avtUser;
    TextView userName, followNumber, postNumber;
    Button followBtn, unfollowBtn;

    public UserResultHolder(@NonNull View itemView) {
        super(itemView);
        avtUser = itemView.findViewById(R.id.avtUser);
        userName = itemView.findViewById(R.id.userName);
        followNumber = itemView.findViewById(R.id.followNumber);
        postNumber = itemView.findViewById(R.id.postNumber);
        followBtn = itemView.findViewById(R.id.followBtn);
        unfollowBtn = itemView.findViewById(R.id.unfollowBtn);
    }
}
