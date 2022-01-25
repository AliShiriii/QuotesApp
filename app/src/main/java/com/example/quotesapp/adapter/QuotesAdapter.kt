package com.example.quotesapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.databinding.QuotesItemBinding

class QuotesAdapter: RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {

    class QuotesViewHolder constructor(private val binding: QuotesItemBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesAdapter.QuotesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: QuotesAdapter.QuotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}