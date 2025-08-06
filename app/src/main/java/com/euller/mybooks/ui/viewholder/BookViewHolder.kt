package com.euller.mybooks.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.euller.mybooks.databinding.ItemBookBinding
import com.euller.mybooks.entity.BookEntity

class BookViewHolder(private val item: ItemBookBinding) : RecyclerView.ViewHolder(item.root) {

    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
    }

}