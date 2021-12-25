package com.nhom005.lovecooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.nhom005.lovecooking.add.AddImageAndVideo;
import com.nhom005.lovecooking.adapter.StoryAdapter;
import com.nhom005.lovecooking.fragment_menu.MyFragmentAdapter;
import com.nhom005.lovecooking.models.Story;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager2 viewPager2;

    FloatingActionButton btnAdd;
    ImageView iconSearch, iconNotification;
    RecyclerView lvStory;
    StoryAdapter adapter;
    ArrayList<Story> stories = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();

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
                MainActivity.this.overridePendingTransition(R.anim.slide_in_bottom, R.anim.default_status);
            }
        });
    }

    private void setComponents() {
        iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(v -> {
            // TODO click
        });
        lvStory = findViewById(R.id.lvStory);
        lvStory.setPaddingRelative(5,0,5,0);
        adapter = new StoryAdapter(stories);
        lvStory.setAdapter(adapter);

        getDataStory();
        adapter.notifyDataSetChanged();
    }

    private void getDataStory(){
        stories.add(new Story(R.drawable.user1, R.drawable.mon1));
        stories.add(new Story(R.drawable.user2, R.drawable.mon2));
        stories.add(new Story(R.drawable.user3, R.drawable.mon3));
        stories.add(new Story(R.drawable.user4, R.drawable.mon4));
        stories.add(new Story(R.drawable.user5, R.drawable.mon5));
        stories.add(new Story(R.drawable.user6, R.drawable.mon6));
        stories.add(new Story(R.drawable.user7, R.drawable.mon7));
        stories.add(new Story(R.drawable.user8, R.drawable.mon8));
        stories.add(new Story(R.drawable.user9, R.drawable.mon9));
        stories.add(new Story(R.drawable.user10, R.drawable.mon10));
        stories.add(new Story(R.drawable.user11, R.drawable.mon11));
        stories.add(new Story(R.drawable.user1, R.drawable.mon12));
        stories.add(new Story(R.drawable.user2, R.drawable.mon13));
        stories.add(new Story(R.drawable.user3, R.drawable.mon29));
        stories.add(new Story(R.drawable.user4, R.drawable.mon14));
        stories.add(new Story(R.drawable.user5, R.drawable.mon15));
        stories.add(new Story(R.drawable.user6, R.drawable.mon16));
        stories.add(new Story(R.drawable.user7, R.drawable.mon17));
        stories.add(new Story(R.drawable.user8, R.drawable.mon24));
        stories.add(new Story(R.drawable.user9, R.drawable.mon25));
        stories.add(new Story(R.drawable.user10, R.drawable.mon23));
        stories.add(new Story(R.drawable.user11, R.drawable.mon27));
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