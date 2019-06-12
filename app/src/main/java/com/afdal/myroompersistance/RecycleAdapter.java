package com.afdal.myroompersistance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afdal.myroompersistance.Room.Mahasiswa;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private Context context;
    private List<Mahasiswa> mList;

    public RecycleAdapter(Context context, List<Mahasiswa> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Mahasiswa album = mList.get(position);
        holder.mName.setText(album.getName());
        holder.mNim.setText(album.getNim());
        holder.mMajor.setText(album.getMajor());
        holder.mYear.setText(album.getYear());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView mName;
        @BindView(R.id.tvNim)
        TextView mNim;
        @BindView(R.id.tvMajor)
        TextView mMajor;
        @BindView(R.id.tvYear)
        TextView mYear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
