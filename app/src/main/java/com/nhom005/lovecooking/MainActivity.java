package com.nhom005.lovecooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.nhom005.lovecooking.add.AddImageAndVideo;
import com.nhom005.lovecooking.fragment_menu.MyFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager2 viewPager2;

    FloatingActionButton btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        viewPager2 = (ViewPager2) findViewById(R.id.view_pager_2);
        btnAdd = (FloatingActionButton)findViewById(R.id.fab);

        // Khởi tạo Adapter
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(this);
        viewPager2.setAdapter(myFragmentAdapter);

        // Set sự kiện khi LƯỚT trên trang
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.memu_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.memu_chat).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.memu_favorite).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.memu_menu).setChecked(true);
                        break;
                }
            }
        });

        // Set sự kiện khi chọn trong thanh menu
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.memu_home:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.memu_chat:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.memu_favorite:
                        viewPager2.setCurrentItem(2);
                        break;
                    case R.id.memu_menu:
                        viewPager2.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddImageAndVideo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                // TODO
                return true;
            case R.id.action_notification:
                // TODO
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}