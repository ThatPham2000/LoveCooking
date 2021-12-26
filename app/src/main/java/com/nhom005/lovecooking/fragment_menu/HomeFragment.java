package com.nhom005.lovecooking.fragment_menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.adapter.FeedNewsAdapter;
import com.nhom005.lovecooking.adapter.StoryAdapter;
import com.nhom005.lovecooking.models.FeedNews;
import com.nhom005.lovecooking.models.Story;
import com.nhom005.lovecooking.models.User;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView lvStory, lvFeedNews;
    StoryAdapter adapter;
    FeedNewsAdapter feedNewsAdapter;
    ArrayList<FeedNews> feedNewsList = new ArrayList<>();
    ArrayList<Story> stories = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setComponents(view);
        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setComponents(View view) {

        lvStory = view.findViewById(R.id.lvStory);
        lvStory.setPaddingRelative(5, 0, 5, 0);
        adapter = new StoryAdapter(stories);
        lvStory.setAdapter(adapter);

        getDataStory();
        adapter.notifyDataSetChanged();

        lvFeedNews = view.findViewById(R.id.lvFeedNews);
        lvFeedNews.setPaddingRelative(0, 0, 0, 10);
        lvFeedNews.setLayoutManager(new LinearLayoutManager(this.getContext()));
        feedNewsAdapter = new FeedNewsAdapter(feedNewsList);
        lvFeedNews.setAdapter(feedNewsAdapter);

        getDataFeedNews();
        feedNewsAdapter.notifyDataSetChanged();
    }

    private void getDataFeedNews() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.avatar = R.drawable.user9;
            user.education = "Đại học Khoa Học Tự Nhiên";
            user.work = "Nhóm 05 Thiết kế giao diện";
            user.name = "Nguyễn Văn A" + i;
            user.numberFollower = 10000;
            user.numberStatus = 30;
            user.website = "https://www.abc.nhom05.vn";

            FeedNews feedNews = new FeedNews();
            feedNews.images = new ArrayList<>();
            feedNews.images.add(R.drawable.mon1);
            feedNews.images.add(R.drawable.mon2);
            feedNews.images.add(R.drawable.mon3);
            feedNews.images.add(R.drawable.mon4);

            feedNews.user = user;
            feedNews.isLoving = i % 2 == 0;
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
            feedNews.numberComment = 50;
            feedNews.numberLove = 120;
            feedNews.rating = 4.5f;
            feedNews.timeUpload = 10 + i * 5 + "";

            feedNewsList.add(feedNews);
            feedNewsAdapter.notifyItemInserted(i);
        }
    }

    private void getDataStory() {
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

}