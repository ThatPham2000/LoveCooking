package com.nhom005.lovecooking.search.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.comment.CommentActivity;
import com.nhom005.lovecooking.models.FeedNews;
import com.nhom005.lovecooking.models.User;
import com.nhom005.lovecooking.search.PostDetailActivity;
import com.nhom005.lovecooking.search.ProfileActivity;
import com.nhom005.lovecooking.utils.Constants;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultSearchAdapter extends RecyclerView.Adapter<ResultViewHolder> {
    private ArrayList values;
    private final int VIEW_USER = 0, VIEW_POST = 1;
    private Context context;

    public ResultSearchAdapter(ArrayList result) {
        values = result;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        context = parent.getContext();
        if (viewType == VIEW_USER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_search, parent, false);

            return new UserResultHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_search_layout, parent, false);
            return new PostResultHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return values.get(position).getClass() == User.class ? VIEW_USER : VIEW_POST;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        if (holder instanceof UserResultHolder) {
            UserResultHolder userResultHolder = (UserResultHolder) holder;
            User user = (User) values.get(position);
            if (user.isFollowing) {
                userResultHolder.unfollowBtn.setVisibility(View.GONE);
                userResultHolder.followBtn.setVisibility(View.VISIBLE);
            } else {
                userResultHolder.followBtn.setVisibility(View.GONE);
                userResultHolder.unfollowBtn.setVisibility(View.VISIBLE);
            }

            userResultHolder.followBtn.setOnClickListener(v -> {
                user.isFollowing = !user.isFollowing;
                userResultHolder.followBtn.setVisibility(View.GONE);
                userResultHolder.unfollowBtn.setVisibility(View.VISIBLE);
            });

            userResultHolder.unfollowBtn.setOnClickListener(v -> {
                user.isFollowing = !user.isFollowing;
                userResultHolder.unfollowBtn.setVisibility(View.GONE);
                userResultHolder.followBtn.setVisibility(View.VISIBLE);
            });

            userResultHolder.avtUser.setImageResource(user.avatar);
            userResultHolder.userName.setText(user.name);
            userResultHolder.followNumber.setText(user.numberFollower + "");
            userResultHolder.postNumber.setText(user.numberStatus + "");

            userResultHolder.userLayout.setOnClickListener(v->{
                Constants.historyUser.add(user);
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra(Constants.KEY_USER, user);
                context.startActivity(intent);
            });
        } else {
            PostResultHolder postResultHolder = (PostResultHolder) holder;
            if (values != null && !values.isEmpty()) {
                FeedNews feedNews = (FeedNews) values.get(position);

                postResultHolder.postLayout.setOnClickListener(v->{
                    Intent intent = new Intent(context, PostDetailActivity.class);
                    intent.putExtra(Constants.KEY_FEED_NEWS, feedNews);
                    context.startActivity(intent);
                });

                postResultHolder.commentBtn.setOnClickListener(v->{
                    Intent intent = new Intent(context, CommentActivity.class);
                    context.startActivity(intent);
                });

                AtomicInteger indexImage = new AtomicInteger();
                indexImage.set(0);
                AtomicInteger index = new AtomicInteger();
                index.set(1);

                postResultHolder.avtUser.setImageResource(feedNews.user.avatar);
                postResultHolder.avtUser.setOnClickListener(v->{
                    Intent intent = new Intent(context, ProfileActivity.class);
                    intent.putExtra(Constants.KEY_USER, feedNews.user);
                    context.startActivity(intent);
                });
                postResultHolder.userName.setText(feedNews.user.name);
                postResultHolder.timeUpload.setText(feedNews.timeUpload + " phút trước");
                postResultHolder.titleStatus.setText(feedNews.title.toUpperCase(Locale.ROOT));
                postResultHolder.materialFood.setText(feedNews.material);
                postResultHolder.numberComment.setText(feedNews.numberComment + "");
                postResultHolder.numberLove.setText(feedNews.numberLove + "");
                postResultHolder.numberRating.setText(feedNews.rating + "");
                postResultHolder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));

                if (feedNews.isLoving) {
                    postResultHolder.loveBtn.setImageResource(R.drawable.ic_love);
                } else {
                    postResultHolder.loveBtn.setImageResource(R.drawable.ic_un_love);
                }

                postResultHolder.imageView.setImageResource(feedNews.images.get(0));
                Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.mon_an);
//            postResultHolder.videoView.setVideoURI(Uri.parse(feedNews.ulrVideo));
                postResultHolder.videoView.setVideoURI(uri);
                postResultHolder.videoView.requestFocus();

                MediaController mediaController = new MediaController(context);
                mediaController.setAnchorView(postResultHolder.videoView);
                postResultHolder.videoView.setMediaController(mediaController);

                postResultHolder.videoView.setOnPreparedListener(mp -> {
//                postResultHolder.videoView.start();
                    mp.setOnVideoSizeChangedListener((mp1, width, height) -> mediaController.setAnchorView(postResultHolder.videoView));
                });

                postResultHolder.videoView.setOnClickListener(v -> {
                    if (postResultHolder.videoView.isPlaying()) {
                        postResultHolder.videoView.pause();
                    } else {
                        postResultHolder.videoView.start();
                    }
                });


                postResultHolder.loveBtn.setOnClickListener(v -> {
                    feedNews.isLoving = !feedNews.isLoving;
                    if (feedNews.isLoving) {
                        postResultHolder.loveBtn.setImageResource(R.drawable.ic_love);
                        feedNews.numberLove++;
                    } else {
                        postResultHolder.loveBtn.setImageResource(R.drawable.ic_un_love);
                        feedNews.numberLove--;
                    }
                    postResultHolder.numberLove.setText(feedNews.numberLove + "");
                });

                postResultHolder.nextImageBtn.setOnClickListener(v -> {
                    postResultHolder.prevImageBtn.setVisibility(View.VISIBLE);

                    if (index.get() > 1) {
                        index.set(index.get() + 1);

                        indexImage.set(indexImage.get() + 1);
                        postResultHolder.imageView.setImageResource(feedNews.images.get(indexImage.get()));
                        postResultHolder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                    } else {
                        index.set(index.get() + 1);

                        postResultHolder.videoView.setVisibility(View.GONE);
                        if (postResultHolder.videoView.isPlaying()) {
                            postResultHolder.videoView.pause();
                        }
                        postResultHolder.imageView.setVisibility(View.VISIBLE);
                        postResultHolder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                    }
                    if (indexImage.get() == feedNews.images.size() - 1) {
                        postResultHolder.nextImageBtn.setVisibility(View.GONE);
                    }
                });

                postResultHolder.prevImageBtn.setOnClickListener(v -> {

                    postResultHolder.nextImageBtn.setVisibility(View.VISIBLE);
                    if (index.get() == 2) {
                        index.set(index.get() - 1);

                        postResultHolder.prevImageBtn.setVisibility(View.GONE);
                        postResultHolder.videoLayout.setVisibility(View.VISIBLE);
                        postResultHolder.imageView.setVisibility(View.GONE);
                        postResultHolder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                        postResultHolder.imageView.setImageResource(feedNews.images.get(0));

                        postResultHolder.videoView.setVideoURI(uri);
                        postResultHolder.videoView.requestFocus();

                        mediaController.setAnchorView(postResultHolder.videoView);
                        postResultHolder.videoView.setMediaController(mediaController);

                    } else if (index.get() > 1) {
                        index.set(index.get() - 1);
                        indexImage.set(indexImage.get() - 1);

                        postResultHolder.imageView.setImageResource(feedNews.images.get(indexImage.get()));
                        postResultHolder.pagingImage.setText(index.get() + "/" + (feedNews.images.size() + 1));
                    }

                });

                if (feedNews.user.isFollowing) {
                    postResultHolder.unfollowBtn.setVisibility(View.GONE);
                    postResultHolder.followBtn.setVisibility(View.VISIBLE);
                } else {
                    postResultHolder.followBtn.setVisibility(View.GONE);
                    postResultHolder.unfollowBtn.setVisibility(View.VISIBLE);
                }

                postResultHolder.followBtn.setOnClickListener(v -> {
                    feedNews.user.isFollowing = !feedNews.user.isFollowing;
                    postResultHolder.followBtn.setVisibility(View.GONE);
                    postResultHolder.unfollowBtn.setVisibility(View.VISIBLE);
                });

                postResultHolder.unfollowBtn.setOnClickListener(v -> {
                    feedNews.user.isFollowing = !feedNews.user.isFollowing;
                    postResultHolder.unfollowBtn.setVisibility(View.GONE);
                    postResultHolder.followBtn.setVisibility(View.VISIBLE);
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
