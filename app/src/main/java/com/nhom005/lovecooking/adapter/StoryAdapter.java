package com.nhom005.lovecooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.Story;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {
    private List<Story> stories;
    private Context context;

    public StoryAdapter(List<Story> stories) {
        this.stories = stories;
    }

    @NonNull
    @Override
    public StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story_layout, parent, false);
        context = parent.getContext();
        return new StoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryHolder holder, int position) {
        Story story = stories.get(position);
        if (story != null) {
            holder.imgStory.setImageResource(story.getImageContent());
            holder.avtUser.setImageResource(story.getAvatar());
        }
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    class StoryHolder extends RecyclerView.ViewHolder {
        ImageView imgStory;
        ImageView avtUser;

        public StoryHolder(@NonNull View itemView) {
            super(itemView);
            imgStory = itemView.findViewById(R.id.imgStory);
            avtUser = itemView.findViewById(R.id.avtUser);
        }
    }
}
