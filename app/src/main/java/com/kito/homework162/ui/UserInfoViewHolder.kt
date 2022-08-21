package com.example.android.codelabs.paging.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.paging.data.createdText
import com.kito.homework162.Data.UserInfo
import com.kito.homework162.databinding.UserItemBinding

class UserInfoViewHolder(
    private val binding: UserItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: UserInfo) {
        binding.apply {
            binding.title.text = article.title
            binding.description.text = article.description
            binding.created.text = article.createdText
        }
    }
}
