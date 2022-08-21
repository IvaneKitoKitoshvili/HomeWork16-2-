package com.kito.homework162.Data

import androidx.paging.PagingSource
import androidx.paging.PagingState

class UserInfoPagingSource : PagingSource<Int, UserInfo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserInfo> {
        TODO("Not yet implemented")
    }
    override fun getRefreshKey(state: PagingState<Int, UserInfo>): Int? {
        TODO("Not yet implemented")
    }
}