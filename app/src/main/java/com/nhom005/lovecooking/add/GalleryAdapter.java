package com.nhom005.lovecooking.add;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder>{
    private Context context;
    private List<Integer> listPhoto;
    protected OnItemClickListener onItemClickListener;

    public GalleryAdapter(Context context, List<Integer> listPhoto, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.listPhoto = listPhoto;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.gallery_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Integer photo = this.listPhoto.get(position);
        holder.imageView.setImageResource(photo);
        if (position == 0 || position % 5 == 0){
            holder.linearLayoutVdieo.setVisibility(View.VISIBLE);
            holder.imgPlay.setVisibility(View.VISIBLE);
        } else {
            holder.linearLayoutVdieo.setVisibility(View.GONE);
            holder.imgPlay.setVisibility(View.GONE);
        }
        Integer p = position;
        holder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(p, holder.checkbox.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listPhoto != null) {
            return listPhoto.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private LinearLayout linearLayoutVdieo;
        private CircleImageView imgPlay;
        CheckBox checkbox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.gallery_item_imgView);
            linearLayoutVdieo = (LinearLayout) itemView.findViewById(R.id.linear_video);
            imgPlay = (CircleImageView) itemView.findViewById(R.id.ic_play_video);
            checkbox =  itemView.findViewById(R.id.checkbox);
        }
    }

    interface OnItemClickListener{
        void onClick(Integer position, boolean checked);
    }
}
