package com.example.uxpro.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.uxpro.api.UxResponse.UxItemsResponse
import com.example.uxpro.databinding.ListItemBinding

class UxItemsAdapter :
    RecyclerView.Adapter<UxItemsViewHolder>() {
    private val uxItemsList = mutableListOf<UxItemsResponse>()
    internal fun updateUxItemsList(uxItemsResponse: List<UxItemsResponse>) {
        uxItemsList.addAll(uxItemsResponse)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UxItemsViewHolder {
        val binding = ListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UxItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UxItemsViewHolder, position: Int) {
        holder.bindDetails(uxItemsList[position])
    }

    override fun getItemCount(): Int {
        return uxItemsList.size
    }
}

class UxItemsViewHolder(@NonNull val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindDetails(
        uxItemsResponse: UxItemsResponse
    ) {
        with(binding) {
            title.text = uxItemsResponse.title
            description.text = uxItemsResponse.description
            subtitle.text = uxItemsResponse.subTitle
        }
    }
}