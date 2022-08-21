package com.example.android.codelabs.paging.ui

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kito.homework162.Data.UserInfo
import com.kito.homework162.databinding.ActivityMainBinding.inflate
import com.kito.homework162.databinding.UserItemBinding.inflate

class UserInfoAdapter : ListAdapter<UserInfo, UserInfoViewHolder>(ARTICLE_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder =
        UserInfoViewHolder(
            UserInfo.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        val tile = getItem(position)
        if (tile != null) {
            holder.bind(tile)
        }
    }

    companion object {
        private val ARTICLE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserInfo>() {
            override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean =
                oldItem == newItem
        }
    }
}
