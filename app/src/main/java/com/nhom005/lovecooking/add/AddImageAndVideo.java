package com.nhom005.lovecooking.add;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.AlbumPicker;

import java.util.ArrayList;
import java.util.List;

public class AddImageAndVideo extends Activity {
    ImageButton btnBack;
    Button btnNext, btnClear;
    RecyclerView recyclerView;
    TextView albumName;

    GalleryAdapter galleryAdapter;
    List<Integer> listPhoto = new ArrayList<>();
    List<Integer> listPhotoPicker = new ArrayList<>();

    AlbumAdapter albumAdapter;
    List<AlbumPicker> listAlbum = new ArrayList<>();

    // Convert Gallery to Album
    ImageButton btnConvert;

    boolean isCheckConvert = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image_and_video);

        btnBack = (ImageButton) findViewById(R.id.btn_back_to_home);
        btnNext = (Button) findViewById(R.id.btn_go_to_content);
        btnConvert = (ImageButton) findViewById(R.id.btn_convert);
        albumName = (TextView) findViewById(R.id.album_name);
        btnClear = (Button) findViewById(R.id.btn_clear);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_gallery);
        recyclerView.setHasFixedSize(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AddImageAndVideo.this, 3);

        setListPhoto();
        galleryAdapter = new GalleryAdapter(AddImageAndVideo.this, listPhoto, (position, checked) -> {
            if (checked) {
                if (!listPhotoPicker.contains(listPhoto.get(position))) {
                    listPhotoPicker.add(listPhoto.get(position));
                }
            } else {
                if (!listPhotoPicker.contains(listPhoto.get(position))) {
                    listPhotoPicker.remove(listPhoto.get(position));
                }
            }
        });
        recyclerView.setAdapter(galleryAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        setListAlbum();
        albumAdapter = new AlbumAdapter(AddImageAndVideo.this, listAlbum, new AlbumAdapter.AlbumListener() {
            @Override
            public void onAlbumClick(String name) {
                albumName.setText(name);
                btnConvert.setImageResource(R.drawable.ic_down);
                isCheckConvert = false;
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(galleryAdapter);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddImageAndVideo.this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                AddImageAndVideo.this.overridePendingTransition(R.anim.default_status, R.anim.slide_out_right);
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isCheckConvert) {
                    btnConvert.setImageResource(R.drawable.ic_up);
                    isCheckConvert = true;
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(albumAdapter);
                } else {
                    btnConvert.setImageResource(R.drawable.ic_down);
                    isCheckConvert = false;
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(galleryAdapter);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isCheckConvert) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(galleryAdapter);
                }
                listPhotoPicker.clear();
            }
        });

        btnNext.setOnClickListener(view -> {
            if (!listPhotoPicker.isEmpty()) {
                Intent intent = new Intent(AddImageAndVideo.this, AddContent.class);
                startActivity(intent);
                AddImageAndVideo.this.overridePendingTransition(R.anim.slide_in_right, R.anim.default_status);
            } else {
                Toast.makeText(getApplicationContext(), "Bạn cần chọn hình ảnh và video cho bàn đăng.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setListAlbum() {
        listAlbum.add(new AlbumPicker("Thư viện", 100, R.drawable.mon1));
        listAlbum.add(new AlbumPicker("Camera", 200, R.drawable.mon2));
        listAlbum.add(new AlbumPicker("Facebook", 100, R.drawable.mon3));
        listAlbum.add(new AlbumPicker("Messenger", 300, R.drawable.mon4));
        listAlbum.add(new AlbumPicker("Zalo", 100, R.drawable.mon5));
        listAlbum.add(new AlbumPicker("DCIM", 100, R.drawable.mon6));
        listAlbum.add(new AlbumPicker("Telegram", 900, R.drawable.mon7));
        listAlbum.add(new AlbumPicker("Yêu thích", 120, R.drawable.mon8));
        listAlbum.add(new AlbumPicker("Download", 150, R.drawable.mon9));
        listAlbum.add(new AlbumPicker("Instagram", 100, R.drawable.mon10));
    }

    private void setListPhoto() {
        listPhoto.add(R.drawable.mon1);
        listPhoto.add(R.drawable.mon2);
        listPhoto.add(R.drawable.mon3);
        listPhoto.add(R.drawable.mon4);
        listPhoto.add(R.drawable.mon5);
        listPhoto.add(R.drawable.mon6);
        listPhoto.add(R.drawable.mon7);
        listPhoto.add(R.drawable.mon8);
        listPhoto.add(R.drawable.mon9);
        listPhoto.add(R.drawable.mon10);
        listPhoto.add(R.drawable.mon11);
        listPhoto.add(R.drawable.mon12);
        listPhoto.add(R.drawable.mon13);
        listPhoto.add(R.drawable.mon14);
        listPhoto.add(R.drawable.mon15);
        listPhoto.add(R.drawable.mon16);
        listPhoto.add(R.drawable.mon17);
        listPhoto.add(R.drawable.mon23);
        listPhoto.add(R.drawable.mon24);
        listPhoto.add(R.drawable.mon25);
        listPhoto.add(R.drawable.mon26);
        listPhoto.add(R.drawable.mon27);
        listPhoto.add(R.drawable.mon28);
        listPhoto.add(R.drawable.mon29);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AddImageAndVideo.this.overridePendingTransition(R.anim.default_status, R.anim.slide_out_bottom);
    }
}