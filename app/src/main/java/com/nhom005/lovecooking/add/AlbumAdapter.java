package com.nhom005.lovecooking.add;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.AlbumPicker;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
    private Context context;
    private List<AlbumPicker> listAlbum;
    protected AlbumListener albumListener;

    public AlbumAdapter(Context context, List<AlbumPicker> listAlbum, AlbumListener albumListener) {
        this.context = context;
        this.listAlbum = listAlbum;
        this.albumListener = albumListener;
    }

    @NonNull
    @Override
    public AlbumAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_album, parent, false);
        return new AlbumAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AlbumPicker album = listAlbum.get(position);
        holder.txtAlbumName.setText(album.getName());
        holder.txtCount.setText(String.valueOf(album.getNumber()));
        holder.imgAlbum.setImageResource(album.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                albumListener.onAlbumClick(album.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listAlbum != null) {
            return listAlbum.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAlbum;
        private TextView txtAlbumName, txtCount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAlbum = (ImageView) itemView.findViewById(R.id.imgAlbum);
            txtAlbumName = (TextView) itemView.findViewById(R.id.txtTenAlbum);
            txtCount = (TextView) itemView.findViewById(R.id.txtSoLuong);
        }
    }

    // Interface xử lý sự kiện click
    public interface AlbumListener {
        void onAlbumClick(String name);
    }
}
