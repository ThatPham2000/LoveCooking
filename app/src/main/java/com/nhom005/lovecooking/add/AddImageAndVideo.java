package com.nhom005.lovecooking.add;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.nhom005.lovecooking.MainActivity;
import com.nhom005.lovecooking.R;

public class AddImageAndVideo extends Activity {
    ImageButton btnBack;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image_and_video);

        btnBack = (ImageButton) findViewById(R.id.btn_back_to_home);
        btnNext = (Button) findViewById(R.id.btn_go_to_content);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                AddImageAndVideo.this.overridePendingTransition(R.anim.right_to_left, R.anim.left_to_right);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AddImageAndVideo.this.overridePendingTransition(R.anim.right_to_left, R.anim.left_to_right);
    }
}