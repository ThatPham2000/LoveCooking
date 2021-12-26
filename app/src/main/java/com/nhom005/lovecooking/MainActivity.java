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
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.nhom005.lovecooking.add.AddImageAndVideo;
import com.nhom005.lovecooking.fragment_menu.MyFragmentAdapter;
import com.nhom005.lovecooking.models.FeedNews;
import com.nhom005.lovecooking.models.User;
import com.nhom005.lovecooking.search.SearchActivity;
import com.nhom005.lovecooking.utils.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager2 viewPager2;

    FloatingActionButton btnAdd;
    ImageView iconSearch, iconNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        viewPager2 = (ViewPager2) findViewById(R.id.view_pager_2);
        btnAdd = (FloatingActionButton) findViewById(R.id.fab);

        // Khởi tạo Adapter
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(this);
        viewPager2.setAdapter(myFragmentAdapter);

        // Set sự kiện khi LƯỚT trên trang
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
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
                switch (item.getItemId()) {
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

        getDataBase();
    }

    private void setComponents() {
        iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(v -> {
            startActivity(new Intent(this, SearchActivity.class));
        });

    }

    private void getDataBase() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.avatar = R.drawable.user6;
            user.education = "Đại học Khoa Học Tự Nhiên";
            user.work = "Nhóm 05 Thiết kế giao diện";
            user.name = "Nguyen Van A" + i;
            user.numberFollower = 10000;
            user.numberStatus = 30;
            user.website = "https://www.abc.nhom05.vn";
            user.isFollowing = i % 3 == 0;
            Constants.users.add(user);

            if (i % 3 == 0)
                Constants.historyUser.add(user);
        }

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.avatar = R.drawable.user10;
            user.education = "Đại học Khoa Học Tự Nhiên";
            user.work = "Nhóm 05 Thiết kế giao diện";
            user.name = "Nguyen Van A" + i;
            user.numberFollower = 10000;
            user.numberStatus = 30;
            user.website = "https://www.abc.nhom05.vn";
            user.isFollowing = i % 3 == 0;

            FeedNews feedNews = new FeedNews();
            feedNews.images = new ArrayList<>();
            feedNews.images.add(R.drawable.mon1);
            feedNews.images.add(R.drawable.mon2);
            feedNews.images.add(R.drawable.mon3);
            feedNews.images.add(R.drawable.mon4);

            feedNews.user = user;
            feedNews.isLoving = i % 2 == 0;
            feedNews.title = "Món ngon gà kho xả ớt";
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
            feedNews.numberComment = 50;
            feedNews.numberLove = 120;
            feedNews.rating = 4.5f;
            feedNews.timeUpload = 10 + i * 5 + "";

            Constants.feedNews.add(feedNews);
        }

        Constants.historyTextSearch.add("gà kho xả ớt");
        Constants.historyTextSearch.add("Rau muốn xào tỏi");

        User user1 = new User();
        user1.avatar = R.drawable.user6;
        user1.education = "Đại học Khoa Học Tự Nhiên";
        user1.work = "Nhóm 05 Thiết kế giao diện";
        user1.name = "Pham Thanh Thanh";
        user1.numberFollower = 10000;
        user1.numberStatus = 30;
        user1.website = "https://www.abc.nhom05.vn";
        user1.isFollowing = false;

        User user2 = new User();
        user2.avatar = R.drawable.avt_user;
        user2.education = "Đại học Khoa Học Tự Nhiên";
        user2.work = "Nhóm 05 Thiết kế giao diện";
        user2.name = "Nguyen Thi B";
        user2.numberFollower = 10000;
        user2.numberStatus = 30;
        user2.website = "https://www.abc.nhom05.vn";
        user2.isFollowing = true;

        Constants.historyUser.add(user1);
        Constants.historyUser.add(user2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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