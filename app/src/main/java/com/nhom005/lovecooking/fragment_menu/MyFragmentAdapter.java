package com.nhom005.lovecooking.fragment_menu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapter extends FragmentStateAdapter {
    public MyFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new FavoriteFragment();
            case 3:
                return new MenuFragment();
            default:
                return new HomeFragment();
        }
    }

    // Trả về số page
    @Override
    public int getItemCount() {
        return 4;
    }
}
