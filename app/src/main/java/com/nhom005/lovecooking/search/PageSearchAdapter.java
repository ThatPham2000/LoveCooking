package com.nhom005.lovecooking.search;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nhom005.lovecooking.search.fragment.AllResultFragment;
import com.nhom005.lovecooking.search.fragment.PostResultFragment;
import com.nhom005.lovecooking.search.fragment.UserResultFragment;

public class PageSearchAdapter extends FragmentStateAdapter {
    public PageSearchAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return UserResultFragment.newInstance();
            case 2:
                return PostResultFragment.newInstance();
            default:
                return AllResultFragment.newInstance();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
