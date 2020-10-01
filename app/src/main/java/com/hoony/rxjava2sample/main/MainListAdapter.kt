package com.hoony.rxjava2sample.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hoony.rxjava2sample.R
import com.hoony.rxjava2sample.databinding.ItemMainBinding

class MainListAdapter(
    private val listener: MainListListener
) : ListAdapter<Sample, MainListAdapter.MainItemHolder>(
    object : DiffUtil.ItemCallback<Sample>() {
        override fun areItemsTheSame(oldItem: Sample, newItem: Sample): Boolean =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: Sample, newItem: Sample): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }
) {
    interface MainListListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemHolder {
        return MainItemHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_main,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainItemHolder, position: Int) {
        holder.apply {
            bind(getItem(position))
            setListener(listener)
        }
    }

    inner class MainItemHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sample: Sample) {
            binding.sample = sample
        }

        fun setListener(listener: MainListAdapter.MainListListener) {
            binding.container.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onItemClick(adapterPosition)
                }
            }
        }
    }
}


