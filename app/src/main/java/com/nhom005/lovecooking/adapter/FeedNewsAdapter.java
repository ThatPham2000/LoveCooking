package com.nhom005.lovecooking.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.FeedNews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FeedNewsAdapter extends RecyclerView.Adapter<FeedNewsAdapter.FeedNewsHolder> {
    private List<FeedNews> values;
    private Context context;

    public FeedNewsAdapter(List<FeedNews> values) {
        this.values = values;
    }

    @NonNull
    @Override
    public FeedNewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newsfeed_layout, parent, false);
        context = parent.getContext();

        return new FeedNewsHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FeedNewsHolder holder, int position) {
        if (values != null && !values.isEmpty()) {
            FeedNews feedNews = values.get(position);
            AtomicInteger indexImage = new AtomicInteger();
            indexImage.set(0);
            AtomicInteger index = new AtomicInteger();
            index.set(1);

            holder.avtUser.setImageResource(feedNews.user.avatar);
            holder.userName.setText(feedNews.user.name);
            holder.timeUpload.setText(feedNews.timeUpload + " phút trước");
            holder.titleStatus.setText(feedNews.title);
            holder.materialFood.setText(feedNews.material);
            holder.numberComment.setText(feedNews.numberComment + "");
            holder.numberLove.setText(feedNews.numberLove + "");
            holder.numberRating.setText(feedNews.rating + "");
            holder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));

            if (feedNews.isLoving) {
                holder.loveBtn.setImageResource(R.drawable.ic_love);
            } else {
                holder.loveBtn.setImageResource(R.drawable.ic_un_love);
            }

            holder.imageView.setImageResource(feedNews.images.get(0));
            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.mon_an);
//            holder.videoView.setVideoURI(Uri.parse(feedNews.ulrVideo));
            holder.videoView.setVideoURI(uri);
            holder.videoView.requestFocus();

            MediaController mediaController = new MediaController(context);
            mediaController.setAnchorView(holder.videoView);
            holder.videoView.setMediaController(mediaController);

            holder.videoView.setOnPreparedListener(mp -> {
//                holder.videoView.start();
                mp.setOnVideoSizeChangedListener((mp1, width, height) -> mediaController.setAnchorView(holder.videoView));
            });

            holder.videoView.setOnClickListener(v -> {
                if (holder.videoView.isPlaying()) {
                    holder.videoView.pause();
                } else {
                    holder.videoView.start();
                }
            });


            holder.loveBtn.setOnClickListener(v -> {
                feedNews.isLoving = !feedNews.isLoving;
                if (feedNews.isLoving) {
                    holder.loveBtn.setImageResource(R.drawable.ic_love);
                    feedNews.numberLove++;
                } else {
                    holder.loveBtn.setImageResource(R.drawable.ic_un_love);
                    feedNews.numberLove--;
                }
                holder.numberLove.setText(feedNews.numberLove + "");
            });

            holder.nextImageBtn.setOnClickListener(v -> {
                holder.prevImageBtn.setVisibility(View.VISIBLE);

                if (index.get() > 1) {
                    index.set(index.get() + 1);

                    indexImage.set(indexImage.get() + 1);
                    holder.imageView.setImageResource(feedNews.images.get(indexImage.get()));
                    holder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                } else {
                    index.set(index.get() + 1);

                    holder.videoView.setVisibility(View.GONE);
                    if (holder.videoView.isPlaying()) {
                        holder.videoView.pause();
                    }
                    holder.imageView.setVisibility(View.VISIBLE);
                    holder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                }
                if (indexImage.get() == feedNews.images.size() - 1) {
                    holder.nextImageBtn.setVisibility(View.GONE);
                }
            });

            holder.prevImageBtn.setOnClickListener(v -> {

                holder.nextImageBtn.setVisibility(View.VISIBLE);
                if (index.get() == 2) {
                    index.set(index.get() - 1);

                    holder.prevImageBtn.setVisibility(View.GONE);
                    holder.videoLayout.setVisibility(View.VISIBLE);
                    holder.imageView.setVisibility(View.GONE);
                    holder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                    holder.imageView.setImageResource(feedNews.images.get(0));

                    holder.videoView.setVideoURI(uri);
                    holder.videoView.requestFocus();

                    mediaController.setAnchorView(holder.videoView);
                    holder.videoView.setMediaController(mediaController);

                } else if (index.get() > 1) {
                    index.set(index.get() - 1);
                    indexImage.set(indexImage.get() - 1);

                    holder.imageView.setImageResource(feedNews.images.get(indexImage.get()));
                    holder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                }

            });
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class FeedNewsHolder extends RecyclerView.ViewHolder {
        ImageView avtUser;
        ImageView imageView;
        ImageView loveBtn;
        ImageView commentBtn;
        ImageView shareBtn;
        ImageView ratingBtn;
//        ImageView playVideoBtn;

        TextView userName;
        TextView timeUpload;
        TextView titleStatus;
        TextView materialFood;
        TextView moreContent;
        TextView pagingImage;
        TextView numberLove;
        TextView numberComment;
        TextView numberRating;

        ImageButton moreBtn;
        VideoView videoView;
        ImageView nextImageBtn;
        ImageView prevImageBtn;
        FrameLayout videoLayout;

        public FeedNewsHolder(@NonNull View itemView) {
            super(itemView);
            avtUser = itemView.findViewById(R.id.avtUser);
            imageView = itemView.findViewById(R.id.imageView);
            loveBtn = itemView.findViewById(R.id.loveBtn);
            commentBtn = itemView.findViewById(R.id.commentBtn);
            shareBtn = itemView.findViewById(R.id.shareBtn);
            ratingBtn = itemView.findViewById(R.id.ratingBtn);
            videoLayout = itemView.findViewById(R.id.videoLayout);
//            playVideoBtn = itemView.findViewById(R.id.playVideoBtn);

            userName = itemView.findViewById(R.id.userName);
            timeUpload = itemView.findViewById(R.id.timeUpload);
            titleStatus = itemView.findViewById(R.id.titleStatus);
            materialFood = itemView.findViewById(R.id.materialFood);
            moreContent = itemView.findViewById(R.id.moreContent);
            pagingImage = itemView.findViewById(R.id.pagingImage);
            numberLove = itemView.findViewById(R.id.numberLove);
            numberComment = itemView.findViewById(R.id.numberComment);
            numberRating = itemView.findViewById(R.id.numberRating);

            moreBtn = itemView.findViewById(R.id.moreBtn);
            videoView = itemView.findViewById(R.id.videoView);
            nextImageBtn = itemView.findViewById(R.id.nextImageBtn);
            prevImageBtn = itemView.findViewById(R.id.prevImageBtn);
        }
    }
}
