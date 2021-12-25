package com.nhom005.lovecooking.add;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.nhom005.lovecooking.R;

import java.util.ArrayList;
import java.util.List;

public class AddImageAndVideo extends Activity {
    ImageButton btnBack;
    Button btnNext;
    RecyclerView recyclerView;
    GalleryAdapter galleryAdapter;
    List<Integer> listPhoto = new ArrayList<>();

    // Convert Gallery to Album
    ImageButton btnConvert;
    boolean isCheckConvert = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image_and_video);

        btnBack = (ImageButton) findViewById(R.id.btn_back_to_home);
        btnNext = (Button) findViewById(R.id.btn_go_to_content);
        btnConvert = (ImageButton)findViewById(R.id.btn_convert);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_gallery);
        recyclerView.setHasFixedSize(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AddImageAndVideo.this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

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
                if (!isCheckConvert){
                    btnConvert.setImageResource(R.drawable.ic_up);
                    isCheckConvert = true;
                } else {
                    btnConvert.setImageResource(R.drawable.ic_down);
                    isCheckConvert = false;
                }
            }
        });

        setListPhoto();


        galleryAdapter = new GalleryAdapter(AddImageAndVideo.this, listPhoto);

        recyclerView.setAdapter(galleryAdapter);
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