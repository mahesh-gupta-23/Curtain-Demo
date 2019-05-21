package com.example.mahesh.curtaindemo

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.mahesh.curtaindemo.databinding.ListRowBinding

class RvAdapter internal constructor(private val context: Context) : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ListRowBinding>(LayoutInflater.from(context),
                R.layout.list_row, parent, false)
        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position % 2 == 0) {
            holder.binding.tvTitle.text = "Title $position"
            holder.binding.tvContent.text = "Content $position"
            holder.binding.clText.visibility = View.VISIBLE
            holder.binding.ivImage.visibility = View.GONE
        } else {
            holder.binding.clText.visibility = View.GONE
            holder.binding.ivImage.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class MyViewHolder(val binding: ListRowBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.clBack.setOnClickListener {
                Toast.makeText(context, "itemClicked $adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
