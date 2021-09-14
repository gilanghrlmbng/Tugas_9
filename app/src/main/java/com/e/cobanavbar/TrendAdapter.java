package com.e.cobanavbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TrendAdapter extends RecyclerView.Adapter<TrendAdapter.myViewHolder> {
    private List<TrendModel> trendlist;
    private itemCLickListener itemCLickListener;

    public TrendAdapter(List<TrendModel> trendlist, itemCLickListener itemCLickListener) {
        this.trendlist = trendlist;
        this.itemCLickListener = itemCLickListener;
    }

    @NonNull
    @Override
    public TrendAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new TrendAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendAdapter.myViewHolder holder, int position) {
        holder.judul.setText(trendlist.get(position).getTitle());
        Glide.with(holder.gambar_brt).load(trendlist.get(position).getUrl()).into(holder.gambar_brt);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCLickListener.onItemCLick(trendlist.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView gambar_brt;
        public myViewHolder(View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.title);
            gambar_brt = itemView.findViewById(R.id.gambar_berita);
        }
    }
    public interface itemCLickListener {

        void onItemCLick(TrendModel trendModel);
    }
}
