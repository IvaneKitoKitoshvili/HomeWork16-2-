package com.example.android.codelabs.paging.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kito.homework162.Injection
import com.kito.homework162.databinding.UserItemBinding
import kotlinx.coroutines.launch

class UserInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = UserItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val viewModel by viewModels<UserInfoViewModel>(
            factoryProducer = { Injection.provideViewModelFactory(owner = this) }
        )

        val items = viewModel.items
        val articleAdapter = UserInfoAdapter()

        binding.bindAdapter(articleAdapter = articleAdapter)


        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {
                items.collect {
                    articleAdapter.submitList(it)
                }
            }
        }
    }
}
private fun UserItemBinding.bindAdapter(articleAdapter: UserInfoAdapter) {
    list.adapter = UserInfoAdapter
    list.layoutManager = LinearLayoutManager(list.context)
    val decoration = DividerItemDecoration(list.context, DividerItemDecoration.VERTICAL)
    list.addItemDecoration(decoration)
}
