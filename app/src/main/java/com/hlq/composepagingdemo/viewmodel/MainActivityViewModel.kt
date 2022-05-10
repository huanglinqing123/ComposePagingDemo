package com.hlq.composepagingdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.hlq.composepagingdemo.source.ADataSource

/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc viewModel 对象
 */
class MainActivityViewModel : ViewModel() {

    /**
     * 获取数据
     */
    fun getData() = Pager(PagingConfig(pageSize = 8)) {
        ADataSource()
    }.flow
}