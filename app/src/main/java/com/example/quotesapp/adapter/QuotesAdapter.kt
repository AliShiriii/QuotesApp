package com.example.quotesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.databinding.QuotesItemBinding
import com.example.quotesapp.interfase.CopyListener
import com.example.quotesapp.model.QuotesResponse

class QuotesAdapter(
    private val copied: CopyListener
) :
    RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {

    inner class QuotesViewHolder constructor(private val binding: QuotesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(quotesResponse: QuotesResponse, listener: CopyListener) {

            binding.apply {

                textQuotes.text = quotesResponse.text
                textAuthor.text = quotesResponse.author

                copy.setOnClickListener {

                    listener.onCopiedClick(differ.currentList[adapterPosition].text)

                }
            }

        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<QuotesResponse>() {
        override fun areItemsTheSame(oldItem: QuotesResponse, newItem: QuotesResponse): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: QuotesResponse, newItem: QuotesResponse): Boolean {

            return oldItem == newItem

        }

    }

    val differ = AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuotesAdapter.QuotesViewHolder {

        return QuotesViewHolder(
            QuotesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: QuotesAdapter.QuotesViewHolder, position: Int) {

        val quotes = differ.currentList[position]
        if (quotes != null) {
            holder.bind(quotes, copied)

        }
    }

    override fun getItemCount(): Int {

        return differ.currentList.size
    }

}