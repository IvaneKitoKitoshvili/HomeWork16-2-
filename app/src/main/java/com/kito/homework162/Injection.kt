package com.kito.homework162

import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.example.android.codelabs.paging.ui.ViewModelFactory
import com.kito.homework162.Data.UserInfoPagingSource

object Injection {
    private fun provideArticleRepository(): UserInfoPagingSource = UserInfoPagingSource()

    fun provideViewModelFactory(owner: SavedStateRegistryOwner): ViewModelProvider.Factory {
        return ViewModelFactory(owner, provideArticleRepository())
    }
}

