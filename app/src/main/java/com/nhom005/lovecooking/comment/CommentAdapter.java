package com.nhom005.lovecooking.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.Comment;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private ArrayList<Comment> values;
    private Context context;
    private IComment iComment;

    public CommentAdapter(ArrayList<Comment> comments, IComment icmt) {
        this.values = comments;
        this.iComment = icmt;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_coment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = values.get(position);
        holder.avtUser.setImageResource(comment.user.avatar);
        holder.userName.setText(comment.user.name);
        holder.content.setText(comment.content);
        holder.loveBtn.setOnClickListener(v -> {
            comment.isLoving = !comment.isLoving;
            if (comment.isLoving) {
                holder.loveBtn.setImageResource(R.drawable.ic_love);
                comment.numberLove++;

            } else {
                holder.loveBtn.setImageResource(R.drawable.ic_un_love);
                comment.numberLove--;
            }
            holder.numberLove.setText(comment.numberLove + "");
        });
        if (comment.isLoving) {
            holder.loveBtn.setImageResource(R.drawable.ic_love);
        } else {
            holder.loveBtn.setImageResource(R.drawable.ic_un_love);
        }
        holder.numberLove.setText(comment.numberLove + "");
        holder.replyLv.setAdapter(new CommentAdapter(comment.reply, new IComment() {
            @Override
            public void replyComment(int index) {

            }
        }));
        holder.replyBtn.setOnClickListener(v->{
            iComment.replyComment(position);
            comment.isReply = true;
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        ImageView avtUser, loveBtn;
        TextView content, userName, numberLove, replyBtn;
        RecyclerView replyLv;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            avtUser = itemView.findViewById(R.id.avtUser);
            loveBtn = itemView.findViewById(R.id.loveBtn);
            content = itemView.findViewById(R.id.content);
            userName = itemView.findViewById(R.id.userName);
            replyLv = itemView.findViewById(R.id.replyLv);
            numberLove = itemView.findViewById(R.id.numberLove);
            replyBtn = itemView.findViewById(R.id.replyBtn);

        }
    }
}
