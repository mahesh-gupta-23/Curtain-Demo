package com.example.mahesh.curtaindemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahesh.curtaindemo.databinding.ListRowBinding;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private Context context;

    RvAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.list_row, parent, false);
        return new MyViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.binding.tvTitle.setText("Title " + position);
            holder.binding.tvContent.setText("Content " + position);
            holder.binding.clText.setVisibility(View.VISIBLE);
            holder.binding.ivImage.setVisibility(View.GONE);
        } else {
            holder.binding.clText.setVisibility(View.GONE);
            holder.binding.ivImage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ListRowBinding binding;

        public MyViewHolder(ListRowBinding listRowBinding) {
            super(listRowBinding.getRoot());
            binding = listRowBinding;
        }
    }
}
