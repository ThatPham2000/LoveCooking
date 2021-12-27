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
import android.widget.TextView;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager2 viewPager2;

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


        getDataBase();
    }

    private void setComponents() {
        iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(v -> {
            startActivity(new Intent(this, SearchActivity.class));
        });

    }

    private void getDataBase() {
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
        Constants.users.add(user1);
        Constants.users.add(user2);

        Constants.users.add(new User(
                R.drawable.user2,
                "Vũ Phan Nhật Tài",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user5,
                "Phạm Minh Vương",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user1,
                "Phạm Văn Thật",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user6,
                "Nguyễn Thị Anh Thư",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user8,
                "Lưu Tường Vũ",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user9,
                "Đỗ Bảo Ngọc",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user10,
                "Nguyễn Khắc Trí",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user11,
                "Kỳ Bạch",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user6,
                "Song Nguyệt",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user3,
                "Nhung Mẫn",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user2,
                "Thiên Nam",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user5,
                "Huy Đạt",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.avt_user,
                "Thúy Hằng",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user6,
                "Đặng Thu Giang",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user3,
                "Mỹ Trâm",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user4,
                "Hưng Khải",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user2,
                "Thư San",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));
        Constants.users.add(new User(
                R.drawable.user11,
                "Danh Châu",
                "Học tại trường đại học Khoa học Tự Nhiên",
                "Làm việc tại TPHCM",
                "htttps://abc.com",
                100,
                200,
                System.currentTimeMillis() % 2 == 0
        ));

        //
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.mon1);
        images.add(R.drawable.mon2);
        images.add(R.drawable.mon3);
        images.add(R.drawable.mon4);
        ArrayList<String> howToDoIt = new ArrayList<>();
        howToDoIt.add("Sả rửa sạch, bỏ bẹ già và băm nhuyễn. Ớt cắt nhỏ.\n" +
                "\n" +
                "Gà mua về rửa sạch, để ráo. Chặt gà thành từng miếng vừa ăn, ướp với sả, ớt băm, 1/2 muỗng canh bột nghệ, 1 muỗng canh hạt nêm, 1 muỗng cà phê muối, 1/2 muỗng cà phê bột ngọt.\n" +
                "\n" +
                "Trộn đều và ướp trong vòng 2 tiếng cho gà thấm gia vị.");
        howToDoIt.add("Sau 2 tiếng, cho thịt gà vào nồi rồi bắc lên bếp, xào cho thịt gà săn lại.\n" +
                "\n" +
                "Thêm khoảng 1/4 chén nước (chén cơm) rồi đậy nắp lại, để lửa vừa và kho trong vòng 15 phút.");
        howToDoIt.add("Gà kho sả ớt đậm đà, cay thơm dùng với cơm nóng là ngon số một đấy nhé.\n"
        );
        howToDoIt.add("Dùng khi còn nóng để cảm nhận vị cay nồng của ớt và hương thơm nức mũi của sả. Chúc bạn thành công!");


        for (int i = 0; i < 20; i++) {
            Constants.feedNews.add(new FeedNews(
                    Constants.users.get(i),
                    images,
                    "",
                    "Thịt heo chiên sả ớt",
                    "thịt heo 1kg, sả 4-5 cây, tỏi 3 tép, ớt sừng 1 trái, gia vị(muối, bột ngọt, nước mắm, dầu ăn), ăn kèm(dưa leo, rau thơm)",
                    howToDoIt,
                    "Nên chọn thịt lợn ba chỉ, nấu sau khi ướp khoảng 1 tiếng và chiên khi thấy miếng thịt có chút cháy sém thì sẽ ngon hơn",
                    100,
                    50,
                    4.5f,
                    System.currentTimeMillis() % (i + 1) == 0,
                    ((System.currentTimeMillis() * i) % 60) + ""
            ));

        }
        Constants.feedNews.get(1).title = "Nem chua rán";
        Constants.feedNews.get(2).title = "Măng tây xào nấm";
        Constants.feedNews.get(3).title = "Măng tây xào nấm";
        Constants.feedNews.get(4).title = "Sandwich nướng phô mai";
        Constants.feedNews.get(5).title = "Bún mắm miền Tây";
        Constants.feedNews.get(6).title = "Súp bào ngư tổ yến";
        Constants.feedNews.get(7).title = "Bánh bao nhân thịt";
        Constants.feedNews.get(8).title = "Bún chả";
        Constants.feedNews.get(9).title = "Canh chua cá hú";
        Constants.feedNews.get(10).title = "Lòng gà xào xả ớt";
        Constants.feedNews.get(11).title = "Tàu hũ ky kho thơm chay";
        Constants.feedNews.get(12).title = "Gỏi đu đủ tôm khô";
        Constants.feedNews.get(13).title = "Ba rọi heo chiên da giòn";
        Constants.feedNews.get(14).title = "Lẩu cá kèo lá giang (gồm nước cốt lẩu)";
        Constants.feedNews.get(15).title = "Đùi gà góc tư nướng kiểu Pháp";
        Constants.feedNews.get(16).title = "Steak nạc vai bò mỹ sốt kem nấm";
        Constants.feedNews.get(17).title = "Lagu sướng non heo";
        Constants.feedNews.get(18).title = "Bò kho";
        Constants.feedNews.get(19).title = "Mực xào chua ngọt";

        Constants.feedNews.get(1).material = "200g măng tây"
                + "200g nấm mỡ"
                + "3 muỗng dầu ăn"
                + "1 muỗng cafe hạt nêm chay"
                + "1 muỗng cafe dầu hào chay"
                + "½ muỗng cafe tiêu";
        Constants.feedNews.get(2).material = "8 miếng bánh mì sandwich"
                + "4 viên phô mai"
                + "2 quả trứng gà"
                + "50 ml sữa tươi"
                + "½ muỗng cà phê muối"
                + "½ muỗng cà phê hạt tiêu xay"
                + "100 g bột chiên xù";
        Constants.feedNews.get(3).material = "100g mắm cá linh"
                + "50g mắm cá sặc"
                + "200g tôm tươi"
                + "200g thịt ba chỉ"
                + "200g heo quay"
                + "200g mực ống"
                + "150g chả cá thác lác"
                + "Sả, ớt, hành tím băm"
                + "2 quả cà tím"
                + "4 trái ớt sừng"
                + "1kg bún"
                + "Gia vị thông thường: đường, hạt nêm, muối, bột ngọt, muối tiêu, dầu ăn, đường phèn"
                + "Các loại rau ăn kèm như: rau đắng, rau thơm, bắp chuối bào, cù nèo, bông súng,…";
        Constants.feedNews.get(4).material = "500g bào ngư (6 - 7 con)"
                + "1g tổ yến (1 tổ yến)"
                + "500g xương gà"
                + "20g táo đỏ khô"
                + "60g nấm đông cô (nấm hương)"
                + "1 trái bắp mỹ, hành tím, gừng"
                + "Gia vị: Muối hạt, đường phèn, hạt nêm, tiêu, dầu mè";
        Constants.feedNews.get(5).material = "1 bịch bột bánh bao 1kg"
                + "500g thịt heo xay"
                + "1 vỉ trứng cút (đã luộc và bóc vỏ)"
                + "6 - 7 tai nấm mèo"
                + "Một ít ngò rí"
                + "2 bịch sữa tươi"
                + "Hành tím băm"
                + "Gia vị nêm gồm có: Hạt nêm, dầu hào, tiêu đen...";
        Constants.feedNews.get(6).material = "500g thịt ba chỉ"
                + "500g thịt nạc vai"
                + "Đu đủ, cà rốt, rau sống ăn kèm"
                + "Bún tươi"
                + "Sả, hành tím, ớt, tỏi, chanh"
                + "Giấm, đường, bột canh, nước mắm, mắm ruốc, nước màu, mì chính hay bột ngọt";
        Constants.feedNews.get(7).material = "Hành Tím, Tỏi Tép Lột Sẵn 20g"
                + "Rau Canh Chua (Cà Chua, Đậu Bắp, Thơm, Bạc Hà, Giá Đỗ) 280g"
                + "Rau Nêm (Ngò Gai, Ngò Om, Ớt Chỉ Thiên Đỏ) 50g"
                + "Cá Hú Làm Sạch Cắt Khúc 200g"
                + "Bột Gia Vị Canh Chua CookyMADE 110g"
                + "Tỏi Phi 10g";
        Constants.feedNews.get(8).material = "Sả Bào, Ớt Chỉ Thiên Đỏ 60g"
                + "Hành Lá, Ngò Rí 30g"
                + "Hành Tím, Tỏi Tép Lột Sẵn 20g"
                + "Lòng Gà Làm Sạch 200g"
                + "Sốt Xào CookyMADE 30g";
        Constants.feedNews.get(9).material = "Hành Lá, Ớt Chỉ Thiên Đỏ 30g"
                + "Tàu Hũ Ky Tươi 150g"
                + "Sốt Kho Chay CookyMADE 40g"
                + "Thơm (Gọt Sẵn) 100g";
        Constants.feedNews.get(10).material = "Bánh Phồng Tôm 30g"
                + "Đậu Phộng Rang 10g"
                + "Rau Gỏi Đu Đủ (Ớt Sừng Đỏ, Rau Răm, Ớt Chỉ Thiên Đỏ) 50g"
                + "Đu Đủ Xanh Hữu Cơ (Bào Sẵn) 300g"
                + "Tôm Khô 20g"
                + "Sốt Trộn Gỏi CookyMADE 100g"
                + "Hành Phi 10g";
        Constants.feedNews.get(11).material = "Nước Tương Maggi 10g"
                + "Ba Rọi Heo (Nhập Khẩu) 300g"
                + "Bột Gia Vị Chiên CookyMADE 9g"
                + "(Lựa chọn) Ba Rọi Heo (Thịt Tươi) 300g";
        Constants.feedNews.get(12).material = "Rau Lẩu Cá Kèo (Lá Giang, Cà Chua, Rau Muống Cọng, Đậu Bắp, Bạc Hà) 880g"
                + "Rau Nêm (Ngò Gai, Ngò Om, Ớt Chỉ Thiên Đỏ) 60g"
                + "Cá Kèo Làm Sạch 400g"
                + "Nước Cốt Lẩu Lá Giang CookyMADE 400g"
                + "(Lựa chọn) Thêm Bún Tươi Sợi Trung Ba Khánh 500g";
        Constants.feedNews.get(13).material = "Giấy Bạc"
                + "Bơ Lạt 20g"
                + "Dầu Tỏi 50g"
                + "Rau Nướng Kiểu Pháp (Khoai Tây Bi, Cà Chua Bi, Măng Tây, Bông Cải Xanh) 160g"
                + "Thyme Tươi, Rosemary Tươi 2g"
                + "Tỏi Nguyên Vỏ 10g"
                + "Đùi Gà Góc Tư (Giữ Nguyên) 350-450g"
                + "Sốt Nâu CookyMADE 100g"
                + "(Lựa chọn) Sốt Vang Đỏ CookyMADE 100g";
        Constants.feedNews.get(14).material = "Bơ Lạt 20g"
                + "Rau Củ Steak (Cà Chua Bi, Măng Tây, Bông Cải Xanh) 110g"
                + "Nạc Vai Bò Mỹ (Top Blade) 200g"
                + "Thyme Tươi, Rosemary Tươi 10g"
                + "Khoai Tây Đông Lạnh 100g"
                + "Tỏi Nguyên Vỏ 10g"
                + "Sốt Kem Nấm CookyMADE 100g";
        Constants.feedNews.get(15).material = "Rau Củ Nấu Lagu (Cà Rốt, Khoai Tây, Hành Tây, Đậu Hà Lan, Lá Quế Khô, Ngò Tây Tươi, Thyme Tươi) 257g"
                + "Hành Tím Lột 10g"
                + "Sườn Non Heo (Nhập Khẩu) 300g"
                + "Gia Vị Nấu Lagu (Bơ Lạt, Bột Mì, Rượu Vang Đỏ, Cà Chua Tomato Paste, Dầu Màu Điều, Tiêu Xay...) 63g"
                + "(Lựa chọn) Sườn Non Heo (Thịt Tươi) 300g";
        Constants.feedNews.get(16).material = "Hành Tím, Tỏi Tép Lột Sẵn 20g"
                + "Rau Bò Kho (Cà Rốt, Húng Cây, Hành Tây, Ngò Gai, Sả Cây, Gừng Củ) 185g"
                + "Nạm Bò Úc (Cắt Sẵn) 300g"
                + "Bột Gia Vị Bò Kho CookyMADE 55g"
                + "Nước Dừa Tươi 200Ml"
                + "Nước Mắm, Dầu Ăn, Sa Tế, Tương Ớt Cholimex 45g"
                + "Quế Khô, Hoa Hồi 7g"
                + "Gia Vị Nấu Bò Kho DH Foods 10g";
        Constants.feedNews.get(17).material = "Rau Củ Chua Ngọt (Thơm, Cần Tàu, Cà Chua, Dưa Leo, Hành Tây, Ớt Chuông) 300g"
                + "Hành Tím, Tỏi Tép Lột Sẵn 20g"
                + "Mực Lá Làm Sạch 200g"
                + "Sốt Xào Chua Ngọt CookyMADE 90g";

        Constants.feedNews.get(1).experience = "Nên chọn thịt lợn ba chỉ, nấu sau khi ướp khoảng 1 tiếng và chiên khi thấy miếng thịt có chút cháy sém thì sẽ ngon hơn";
        Constants.feedNews.get(2).experience = "Để thịt băm trong tủ lạnh khoảng 2 tiếng, để thịt đang đông lạnh xay thì nem mới dai và không bị bở.";
        Constants.feedNews.get(3).experience = "Nấm nên nấu kĩ để mềm, chọn măng tây tươi để có độ giòn";
        Constants.feedNews.get(4).experience = "Cắt bỏ viền bánh trước khi tạo lớp bánh, nướng bánh ở nhiệt độ 200°C";
        Constants.feedNews.get(5).experience = "Nước dùng là phần quan trọng nhất, nên nêm nếm chuẩn xác và cẩn thận đúng như công thức";
        Constants.feedNews.get(6).experience = "Nấu súp bằng nước luộc gà, dùng muối để làm sạch bào ngư";
        Constants.feedNews.get(7).experience = "Pha bột với sữa tươi và trộ kĩ để bột nở đều, nhào đập bột 10-20p, cho rễ ngò vào nước hấp bánh, hấp trong vòng 25p";
        Constants.feedNews.get(8).experience = "Nên ngâm cà rốt và đu đủ trong nước muối loãng, cắt thịt thành miếng mỏng bản to, khi nướng phết dầu lên bề mặt thịt để không bị khô";
        Constants.feedNews.get(9).experience = " Thêm nước mắm làm dậy mùi thơm và canh thêm đậm đà";
        Constants.feedNews.get(10).experience = "- Gói gia vị nên đổ từ từ (không đổ hết) để nêm nếm cho vừa ăn."
                + "- Có thể thay đổi định lượng nước và gia vị để phù hợp với khẩu phần và khẩu vị.";
        Constants.feedNews.get(11).experience = "Có thể làm chín bằng Lò Nướng hoặc Nồi chiên không dầu";
        Constants.feedNews.get(12).experience = "- Gói gia vị nên đổ từ từ (không đổ hết) để nêm nếm cho vừa ăn. ";
        Constants.feedNews.get(13).experience = "- Có thể thay đổi định lượng nước và gia vị để phù hợp với khẩu phần và khẩu vị.";
        Constants.feedNews.get(14).experience = "- Gói gia vị nên đổ từ từ (không đổ hết) để nêm nếm cho vừa ăn. ";
        Constants.feedNews.get(15).experience = "- Có thể thay đổi định lượng nước và gia vị để phù hợp với khẩu phần và khẩu vị.";

        Constants.historyTextSearch.add("gà kho xả ớt");
        Constants.historyTextSearch.add("Rau muốn xào tỏi");


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
            case R.id.action_notification:
                // TODO
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}