package com.nhom005.lovecooking.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.nhom005.lovecooking.MainActivity;
import com.nhom005.lovecooking.R;

import java.util.ArrayList;

public class AddContent extends AppCompatActivity {
    ImageButton btnBack;
    Button btnPost;
    ImageView btnPreview;
    EditText foodName, nguyenlieu, kinhnghiem, cachthuchien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);

        btnBack = (ImageButton) findViewById(R.id.btn_back_to_add_image);
        btnPost = (Button)findViewById(R.id.btn_post);
        btnPreview = (ImageView)findViewById(R.id.btn_preview);

        foodName = (EditText)findViewById(R.id.food_name);
        nguyenlieu = (EditText)findViewById(R.id.nguyenlieu);
        kinhnghiem = (EditText)findViewById(R.id.experience);
        cachthuchien = (EditText)findViewById(R.id.howtodo);

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
                if (checkContent()) {
                    Intent intent = new Intent(AddContent.this, MainActivity.class);
                    startActivity(intent);
                    AddContent.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else {
                    Toast.makeText(getApplicationContext(), "Bạn cần điển đủ thông tin để được phép đăng bài", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkContent()){
                    Toast.makeText(getApplicationContext(), "Bạn cần điển đủ thông tin để được phép xem trước bài đăng", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AddContent.this, PostPreview.class);
                    Bundle myData = new Bundle();
                    myData.putString("title", foodName.getText().toString());
                    myData.putString("nguyenlieu", nguyenlieu.getText().toString());
                    myData.putStringArrayList("howtodo", Split(cachthuchien.getText().toString()));
                    myData.putString("experience", kinhnghiem.getText().toString());
                    intent.putExtras(myData);
                    startActivity(intent);
                    AddContent.this.overridePendingTransition(R.anim.slide_in_right, R.anim.default_status);
                }
            }
        });
    }

    private boolean checkContent() {
        if(foodName.getText().toString().isEmpty()){
            foodName.setError("Bạn cần nhập tên món ăn");
        }
        if(nguyenlieu.getText().toString().isEmpty()){
            nguyenlieu.setError("Bạn cần nhập nguyên liệu");
        }
        if(cachthuchien.getText().toString().isEmpty()){
            cachthuchien.setError("Bạn cần nhập cách thực hiện");
        }

        return !(foodName.getText().toString().isEmpty() || nguyenlieu.getText().toString().isEmpty() || cachthuchien.getText().toString().isEmpty());
    }

    private ArrayList<String> Split(String howtodo) {
        ArrayList<String> rs = new ArrayList<>();

        if (!howtodo.isEmpty()){
            String[] steps = howtodo.split("\n");

            rs.add(steps[0].substring(8));
            rs.add(steps[1].substring(8));
            rs.add(steps[2].substring(8));
            rs.add(steps[3].substring(8));
        }

        return rs;
    }
}