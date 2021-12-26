package com.nhom005.lovecooking.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

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

        FeedNews feedNews = new FeedNews();
        feedNews.images = new ArrayList<>();
        feedNews.images.add(R.drawable.mon1);
        feedNews.images.add(R.drawable.mon2);
        feedNews.images.add(R.drawable.mon3);
        feedNews.images.add(R.drawable.mon4);

        feedNews.title = "Món gà kho xả ớt";
        feedNews.ulrVideo = "https://flutter.github.io/assets-for-api-docs/assets/videos/bee.mp4";
        feedNews.material = "thịt gà 300g" +
                " Sả 4 nhánh" +
                " Ớt đỏ 4 trái" +
                " Bột nghệ 1/2 muỗng canh" +
                " Nước mắm 1 muỗng canh" +
                " Muối hạt 1 muỗng canh" +
                " Gia vị thông dụng 1 ít";
        feedNews.howToDoIt = new ArrayList<>();
        feedNews.howToDoIt.add("Sả rửa sạch, bỏ bẹ già và băm nhuyễn. Ớt cắt nhỏ.\n" +
                "\n" +
                "Gà mua về rửa sạch, để ráo. Chặt gà thành từng miếng vừa ăn, ướp với sả, ớt băm, 1/2 muỗng canh bột nghệ, 1 muỗng canh hạt nêm, 1 muỗng cà phê muối, 1/2 muỗng cà phê bột ngọt.\n" +
                "\n" +
                "Trộn đều và ướp trong vòng 2 tiếng cho gà thấm gia vị.");
        feedNews.howToDoIt.add("Sau 2 tiếng, cho thịt gà vào nồi rồi bắc lên bếp, xào cho thịt gà săn lại.\n" +
                "\n" +
                "Thêm khoảng 1/4 chén nước (chén cơm) rồi đậy nắp lại, để lửa vừa và kho trong vòng 15 phút.");
        feedNews.howToDoIt.add("Gà kho sả ớt đậm đà, cay thơm dùng với cơm nóng là ngon số một đấy nhé.\n" +
                "\n" +
                "Dùng khi còn nóng để cảm nhận vị cay nồng của ớt và hương thơm nức mũi của sả. Chúc bạn thành công!");

        feedNews.experience = "Kho càng lâu càng ngon";

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