package com.example.testapi1.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testapi1.Model.Music.Item;
import com.example.testapi1.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {
    private List<Item> itemList;
    private MediaPlayer mediaPlayer;
    private Context context;
    private int i;
    public MusicAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rcv,parent,false);
        context = parent.getContext();
        return new MusicHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
        final Item item = itemList.get(position);
        holder.tvRowName.setText(item.getName());
        holder.tvRowSinger.setText(item.getSinger().getName());
        holder.tvRowLink.setText(item.getId());
        Glide
                .with(holder.itemView.getContext())
                .load(itemList.get(holder.getAdapterPosition()).getThumbnail())
                .centerCrop()
                .into(holder.imgLogoMusicRow);
        i = holder.getAdapterPosition();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khoiTaoMedia();
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.release();
                }
                khoiTaoMedia();
                mediaPlayer.start();
            }
        });
    }
    void khoiTaoMedia(){
        mediaPlayer = MediaPlayer.create(context, Uri.parse("https://api.mp3.zing.vn/api/streaming/audio/"+itemList.get(i).getId()+"/320"));
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    protected class MusicHolder extends RecyclerView.ViewHolder {
        private TextView tvRowName;
        private TextView tvRowSinger;
        private TextView tvRowLink;
        private ImageView imgLogoMusicRow;
        public MusicHolder(@NonNull View itemView) {
            super(itemView);
            tvRowName = (TextView) itemView.findViewById(R.id.tvRowName);
            tvRowSinger = (TextView) itemView.findViewById(R.id.tvRowSinger);
            tvRowLink = (TextView) itemView.findViewById(R.id.tvRowLink);
            imgLogoMusicRow = (ImageView) itemView.findViewById(R.id.imgLogoMusicRow);

        }
    }
}
