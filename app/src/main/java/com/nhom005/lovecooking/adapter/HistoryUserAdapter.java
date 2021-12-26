package com.nhom005.lovecooking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.User;
import com.nhom005.lovecooking.search.ProfileActivity;
import com.nhom005.lovecooking.utils.Constants;

import java.util.List;

public class HistoryUserAdapter extends RecyclerView.Adapter<HistoryUserAdapter.UserHistoryHolder> {
    private List<User> values;
    private Context context;
    public  HistoryUserAdapter(List<User> users){
        values = users;
    }

    @NonNull
    @Override
    public UserHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_user_history, parent, false);
        return new UserHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHistoryHolder holder, int position) {
        User user = values.get(position);
        holder.userLayout.setOnClickListener(v->{
            Intent intent = new Intent(context, ProfileActivity.class);
            intent.putExtra(Constants.KEY_USER, user);
            context.startActivity(intent);
        });
        holder.avatar.setImageResource(user.avatar);
        holder.userName.setText(user.name);
        holder.deleteBtn.setOnClickListener(v->{
            values.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class UserHistoryHolder extends RecyclerView.ViewHolder {
        LinearLayout userLayout;
        ImageView avatar;
        TextView userName;
        TextView deleteBtn;
        public UserHistoryHolder(@NonNull View itemView) {
            super(itemView);
            userLayout = itemView.findViewById(R.id.userLayout);
            avatar = itemView.findViewById(R.id.avatar);
            userName = itemView.findViewById(R.id.userName);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }
}
