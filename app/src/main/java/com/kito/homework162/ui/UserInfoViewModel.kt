package com.example.android.codelabs.paging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.android.codelabs.paging.data.Article
import com.example.android.codelabs.paging.data.ArticleRepository
import com.example.android.codelabs.paging.data.ITEMS_PER_PAGE
import com.kito.homework162.Data.UserInfo
import com.kito.homework162.Data.UserInfoPagingSource
import kotlinx.coroutines.flow.Flow

private const val ITEMS_PER_PAGE = 50

class UserInfoViewModel(
    private val repository: UserInfoPagingSource,
) : ViewModel() {

    val items: Flow<PagingData<UserInfo>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { repository.articlePagingSource() }
    )
        .flow
        .cachedIn(viewModelScope)
}
