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

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.MyViewHolder> {
    private List<DataModel> Datalist;
    private itemCLickListener itemCLickListener;

    public TodayAdapter(List<DataModel> Datalist, itemCLickListener itemCLickListener) {
        this.Datalist = Datalist;
        this.itemCLickListener = itemCLickListener;
    }

    @NonNull
    @Override
    public TodayAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.judul.setText(Datalist.get(position).getTitle());
        Glide.with(holder.gambar_brt).load(Datalist.get(position).getUrl()).into(holder.gambar_brt);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCLickListener.onItemCLick(Datalist.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (Datalist != null) ? Datalist.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView gambar_brt;
        public MyViewHolder(View view) {
            super(view);
            judul = view.findViewById(R.id.title);
            gambar_brt = view.findViewById(R.id.gambar_berita);
        }
    }
    public interface itemCLickListener {

        void onItemCLick(DataModel dataModel);
    }
}
