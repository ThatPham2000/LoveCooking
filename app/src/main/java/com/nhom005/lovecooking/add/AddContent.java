package com.nhom005.lovecooking.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.nhom005.lovecooking.MainActivity;
import com.nhom005.lovecooking.R;

public class AddContent extends AppCompatActivity {
    ImageButton btnBack;
    Button btnPost, btnPreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);

        btnBack = (ImageButton) findViewById(R.id.btn_back_to_add_image);
        btnPost = (Button)findViewById(R.id.btn_post);
        btnPreview = (Button)findViewById(R.id.btn_preview);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                AddContent.this.overridePendingTransition(R.anim.default_status, R.anim.slide_out_right);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddContent.this, MainActivity.class);
                startActivity(intent);
                AddContent.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddContent.this, PostPreview.class);
                startActivity(intent);
                AddContent.this.overridePendingTransition(R.anim.slide_in_right, R.anim.default_status);
            }
        });
    }
}