package com.nhom005.lovecooking.add;

import androidx.appcompat.app.AppCompatActivity;

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
import com.nhom005.lovecooking.models.FeedNews;
import com.nhom005.lovecooking.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PostPreview extends AppCompatActivity {
    ImageView imageView;
    TextView pagingImage;
    VideoView videoView;
    ImageView nextImageBtn;
    ImageView prevImageBtn;
    FrameLayout videoLayout;

    ImageButton btnBackToContent;
    Button btnPost;

    TextView foodNameTxt, nguyenLieuTxt, buoc1Txt, buoc2Txt, buoc3Txt, buoc4Txt, kinhNghiemTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_preview);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String foodName = bundle.getString("title");
        String nguyenLieu = bundle.getString("nguyenlieu");
        ArrayList<String> howToDoList = bundle.getStringArrayList("howtodo");
        String experience = bundle.getString("experience");

        foodNameTxt = (TextView)findViewById(R.id.food_name_txt);
        foodNameTxt.setText(foodName.toUpperCase());

        nguyenLieuTxt = (TextView)findViewById(R.id.nguyenlieu_txt);
        nguyenLieuTxt.setText(nguyenLieu);

        buoc1Txt = (TextView)findViewById(R.id.buoc1_txt);
        buoc1Txt.setText(howToDoList.get(0));

        buoc2Txt = (TextView)findViewById(R.id.buoc2_txt);
        buoc2Txt.setText(howToDoList.get(1));

        buoc3Txt = (TextView)findViewById(R.id.buoc3_txt);
        buoc3Txt.setText(howToDoList.get(2));

        buoc4Txt = (TextView)findViewById(R.id.buoc4_txt);
        buoc4Txt.setText(howToDoList.get(3));

        kinhNghiemTxt = (TextView)findViewById(R.id.kinhnghiem_txt);
        kinhNghiemTxt.setText(experience);

        imageView = findViewById(R.id.imageView);
        videoLayout = findViewById(R.id.videoLayout);

        pagingImage = findViewById(R.id.pagingImage);

        videoView = findViewById(R.id.videoView);
        nextImageBtn = findViewById(R.id.nextImageBtn);
        prevImageBtn = findViewById(R.id.prevImageBtn);

        btnBackToContent = (ImageButton)findViewById(R.id.btn_back_to_content);
        btnBackToContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                PostPreview.this.overridePendingTransition(R.anim.default_status, R.anim.slide_out_right);
            }
        });

        btnPost = (Button) findViewById(R.id.btn_post);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PostPreview.this, MainActivity.class);
                startActivity(intent1);
                PostPreview.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        FeedNews feedNews = new FeedNews();
        feedNews.images = new ArrayList<>();
        feedNews.images.add(R.drawable.mon1);
        feedNews.images.add(R.drawable.mon2);
        feedNews.images.add(R.drawable.mon3);
        feedNews.images.add(R.drawable.mon4);

        feedNews.title = "M??n g?? kho x??? ???t";
        feedNews.ulrVideo = "https://flutter.github.io/assets-for-api-docs/assets/videos/bee.mp4";
        feedNews.material = "th???t g?? 300g" +
                " S??? 4 nh??nh" +
                " ???t ????? 4 tr??i" +
                " B???t ngh??? 1/2 mu???ng canh" +
                " N?????c m???m 1 mu???ng canh" +
                " Mu???i h???t 1 mu???ng canh" +
                " Gia v??? th??ng d???ng 1 ??t";
        feedNews.howToDoIt = new ArrayList<>();
        feedNews.howToDoIt.add("S??? r???a s???ch, b??? b??? gi?? v?? b??m nhuy???n. ???t c???t nh???.\n" +
                "\n" +
                "G?? mua v??? r???a s???ch, ????? r??o. Ch???t g?? th??nh t???ng mi???ng v???a ??n, ?????p v???i s???, ???t b??m, 1/2 mu???ng canh b???t ngh???, 1 mu???ng canh h???t n??m, 1 mu???ng c?? ph?? mu???i, 1/2 mu???ng c?? ph?? b???t ng???t.\n" +
                "\n" +
                "Tr???n ?????u v?? ?????p trong v??ng 2 ti???ng cho g?? th???m gia v???.");
        feedNews.howToDoIt.add("Sau 2 ti???ng, cho th???t g?? v??o n???i r???i b???c l??n b???p, x??o cho th???t g?? s??n l???i.\n" +
                "\n" +
                "Th??m kho???ng 1/4 ch??n n?????c (ch??n c??m) r???i ?????y n???p l???i, ????? l???a v???a v?? kho trong v??ng 15 ph??t.");
        feedNews.howToDoIt.add("G?? kho s??? ???t ?????m ????, cay th??m d??ng v???i c??m n??ng l?? ngon s??? m???t ?????y nh??.\n" +
                "\n" +
                "D??ng khi c??n n??ng ????? c???m nh???n v??? cay n???ng c???a ???t v?? h????ng th??m n???c m??i c???a s???. Ch??c b???n th??nh c??ng!");

        feedNews.experience = "Kho c??ng l??u c??ng ngon";

        AtomicInteger indexImage = new AtomicInteger();
        indexImage.set(0);
        AtomicInteger index = new AtomicInteger();
        index.set(1);

        pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));


        imageView.setImageResource(feedNews.images.get(0));
        Uri uri = Uri.parse("android.resource://" + PostPreview.this.getPackageName() + "/" + R.raw.mon_an);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        MediaController mediaController = new MediaController(PostPreview.this);
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