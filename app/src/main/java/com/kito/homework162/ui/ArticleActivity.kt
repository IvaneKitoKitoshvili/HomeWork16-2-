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
import com.example.android.codelabs.paging.databinding.ActivityArticlesBinding
import com.kito.homework162.Injection
import com.kito.homework162.databinding.UserItemBinding
import kotlinx.coroutines.launch

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = UserItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val viewModel by viewModels<ArticleViewModel>(
            factoryProducer = { Injection.provideViewModelFactory(owner = this) }
        )

        val items = viewModel.items
        val articleAdapter = USerInfoAdapter()

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

/**
 * Sets up the [RecyclerView] and binds [ArticleAdapter] to it
 */
private fun UserItemBinding.bindAdapter(articleAdapter: USerInfoAdapter) {
    list.adapter = articleAdapter
    list.layoutManager = LinearLayoutManager(list.context)
    val decoration = DividerItemDecoration(list.context, DividerItemDecoration.VERTICAL)
    list.addItemDecoration(decoration)
}
