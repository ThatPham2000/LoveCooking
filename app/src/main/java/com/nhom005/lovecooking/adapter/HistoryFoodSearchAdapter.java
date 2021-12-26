package com.nhom005.lovecooking.adapter;

import android.content.Context;
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

import java.util.List;

public class HistoryFoodSearchAdapter extends RecyclerView.Adapter<HistoryFoodSearchAdapter.TextHistoryHolder> {
    private List<String> values;
    private Context context;

    public HistoryFoodSearchAdapter(List<String> foods) {
        values = foods;
    }

    @NonNull
    @Override
    public TextHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_history_food_search, parent, false);
        return new TextHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextHistoryHolder holder, int position) {
        String keySearch = values.get(position);

        holder.keySearch.setText(keySearch);
        holder.deleteBtn.setOnClickListener(v -> {
            values.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class TextHistoryHolder extends RecyclerView.ViewHolder {
        TextView keySearch;
        TextView deleteBtn;

        public TextHistoryHolder(@NonNull View itemView) {
            super(itemView);
            keySearch = itemView.findViewById(R.id.keySearch);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }
}
