package com.example.uxpro.view.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.uxpro.R
import com.example.uxpro.api.UxResponse.UxItemsResponse
import com.example.uxpro.databinding.ListItemBinding

class UxItemsAdapter(val context: Context) :
    RecyclerView.Adapter<UxItemsViewHolder>() {
    private val uxItemsList = mutableListOf<UxItemsResponse>()
    internal fun updateUxItemsList(uxItemsResponse: List<UxItemsResponse>) {
        uxItemsList.clear()
        uxItemsList.addAll(uxItemsResponse)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UxItemsViewHolder {
        val binding = ListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UxItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UxItemsViewHolder, position: Int) {
        holder.bindDetails(uxItemsList[position], position, context)
    }

    override fun getItemCount(): Int {
        return uxItemsList.size
    }
}

class UxItemsViewHolder(@NonNull val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindDetails(
        uxItemsResponse: UxItemsResponse,
        position: Int,
        context: Context
    ) {
        with(binding) {
            if (position % 2 == 0) {
                gradientBackground.background =
                    ContextCompat.getDrawable(context, R.drawable.gradient_background_orange)
            } else {
                gradientBackground.background =
                    ContextCompat.getDrawable(context, R.drawable.gradient_background)
            }
            title.text = uxItemsResponse.title
            description.text = uxItemsResponse.description
            subtitle.text = uxItemsResponse.subTitle
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uxItemsResponse.url))
                context.startActivity(intent)
            }
        }
    }
}