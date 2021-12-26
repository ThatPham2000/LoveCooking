package com.nhom005.lovecooking.search.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;

import com.nhom005.lovecooking.R;

public class PostResultHolder extends ResultViewHolder {
    ImageView avtUser;
    ImageView imageView;
    ImageView loveBtn;
    ImageView commentBtn;
    ImageView shareBtn;
    ImageView ratingBtn;

    TextView userName;
    TextView timeUpload;
    TextView titleStatus;
    TextView materialFood;
    TextView pagingImage;
    TextView numberLove;
    TextView numberComment;
    TextView numberRating;

    ImageButton moreBtn;
    VideoView videoView;
    ImageView nextImageBtn;
    ImageView prevImageBtn;
    FrameLayout videoLayout;

    Button followBtn, unfollowBtn;
    LinearLayout postLayout;

    public PostResultHolder(@NonNull View itemView) {
        super(itemView);
        avtUser = itemView.findViewById(R.id.avtUser);
        imageView = itemView.findViewById(R.id.imageView);
        loveBtn = itemView.findViewById(R.id.loveBtn);
        commentBtn = itemView.findViewById(R.id.commentBtn);
        shareBtn = itemView.findViewById(R.id.shareBtn);
        ratingBtn = itemView.findViewById(R.id.ratingBtn);
        videoLayout = itemView.findViewById(R.id.videoLayout);

        userName = itemView.findViewById(R.id.userName);
        timeUpload = itemView.findViewById(R.id.timeUpload);
        titleStatus = itemView.findViewById(R.id.titleStatus);
        materialFood = itemView.findViewById(R.id.materialFood);
        pagingImage = itemView.findViewById(R.id.pagingImage);
        numberLove = itemView.findViewById(R.id.numberLove);
        numberComment = itemView.findViewById(R.id.numberComment);
        numberRating = itemView.findViewById(R.id.numberRating);

        moreBtn = itemView.findViewById(R.id.moreBtn);
        videoView = itemView.findViewById(R.id.videoView);
        nextImageBtn = itemView.findViewById(R.id.nextImageBtn);
        prevImageBtn = itemView.findViewById(R.id.prevImageBtn);

        followBtn = itemView.findViewById(R.id.followBtn);
        unfollowBtn = itemView.findViewById(R.id.unfollowBtn);
        postLayout = itemView.findViewById(R.id.postLayout);
    }
}
