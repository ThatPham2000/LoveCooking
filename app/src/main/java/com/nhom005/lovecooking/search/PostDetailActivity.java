package com.nhom005.lovecooking.search;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.nhom005.lovecooking.MainActivity;
import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.add.PostPreview;
import com.nhom005.lovecooking.comment.CommentActivity;
import com.nhom005.lovecooking.models.FeedNews;
import com.nhom005.lovecooking.utils.Constants;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class PostDetailActivity extends AppCompatActivity {
    ImageView imageView, commentBtn;
    TextView pagingImage;
    VideoView videoView;
    ImageView nextImageBtn;
    ImageView prevImageBtn;
    ImageView avtUser;
    FrameLayout videoLayout;

    ImageButton btnBackToContent;
    Button btnPost;

    TextView foodNameTxt, nguyenLieuTxt, buoc1Txt, buoc2Txt, buoc3Txt, buoc4Txt, kinhNghiemTxt, title, userName, timeUpload;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        FeedNews feedNews = (FeedNews) getIntent().getSerializableExtra(Constants.KEY_FEED_NEWS);

        title = findViewById(R.id.title);
        avtUser = findViewById(R.id.avtUser);
        userName = findViewById(R.id.userName);
        timeUpload = findViewById(R.id.timeUpload);
        commentBtn = findViewById(R.id.commentBtn);

        commentBtn.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.default_status);
        });
        title.setText(feedNews.user.name);
        userName.setText(feedNews.user.name);
        timeUpload.setText(feedNews.timeUpload + " Phút trước");
        avtUser.setImageResource(feedNews.user.avatar);

        foodNameTxt = (TextView) findViewById(R.id.food_name_txt);
        foodNameTxt.setText(feedNews.title.toUpperCase(Locale.ROOT));

        nguyenLieuTxt = (TextView) findViewById(R.id.nguyenlieu_txt);
        nguyenLieuTxt.setText(feedNews.material);

        buoc1Txt = (TextView) findViewById(R.id.buoc1_txt);
        buoc1Txt.setText(feedNews.howToDoIt.get(0));

        buoc2Txt = (TextView) findViewById(R.id.buoc2_txt);
        buoc2Txt.setText(feedNews.howToDoIt.get(1));

        buoc3Txt = (TextView) findViewById(R.id.buoc3_txt);
        buoc3Txt.setText(feedNews.howToDoIt.get(2));

        buoc4Txt = (TextView) findViewById(R.id.buoc4_txt);
        buoc4Txt.setText(feedNews.howToDoIt.get(3));

        kinhNghiemTxt = (TextView) findViewById(R.id.kinhnghiem_txt);
        kinhNghiemTxt.setText(feedNews.experience);

        imageView = findViewById(R.id.imageView);
        videoLayout = findViewById(R.id.videoLayout);

        pagingImage = findViewById(R.id.pagingImage);

        videoView = findViewById(R.id.videoView);
        nextImageBtn = findViewById(R.id.nextImageBtn);
        prevImageBtn = findViewById(R.id.prevImageBtn);

        btnBackToContent = (ImageButton) findViewById(R.id.btn_back_to_content);
        btnBackToContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                PostDetailActivity.this.overridePendingTransition(R.anim.default_status, R.anim.slide_out_right);
            }
        });

        AtomicInteger indexImage = new AtomicInteger();
        indexImage.set(0);
        AtomicInteger index = new AtomicInteger();
        index.set(1);

        pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));


        imageView.setImageResource(feedNews.images.get(0));
        Uri uri = Uri.parse("android.resource://" + PostDetailActivity.this.getPackageName() + "/" + R.raw.mon_an);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        MediaController mediaController = new MediaController(PostDetailActivity.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(mp -> {
            videoView.start();
            mp.setOnVideoSizeChangedListener((mp1, width, height) -> mediaController.setAnchorView(videoView));
        });

        videoView.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
            } else {
                videoView.resume();
            }
        });

        nextImageBtn.setOnClickListener(v -> {
            prevImageBtn.setVisibility(View.VISIBLE);

            if (index.get() > 1) {
                index.set(index.get() + 1);

                indexImage.set(indexImage.get() + 1);
                imageView.setImageResource(feedNews.images.get(indexImage.get()));
                pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
            } else {
                index.set(index.get() + 1);

                videoView.setVisibility(View.GONE);
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                imageView.setVisibility(View.VISIBLE);
                pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
            }
            if (indexImage.get() == feedNews.images.size() - 1) {
                nextImageBtn.setVisibility(View.GONE);
            }
        });

        prevImageBtn.setOnClickListener(v -> {

            nextImageBtn.setVisibility(View.VISIBLE);
            if (index.get() == 2) {
                index.set(index.get() - 1);

                prevImageBtn.setVisibility(View.GONE);
                videoLayout.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
            } else if (index.get() > 1) {
                index.set(index.get() - 1);
                indexImage.set(indexImage.get() - 1);

                imageView.setImageResource(feedNews.images.get(indexImage.get()));
                pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
            }

        });
    }
}