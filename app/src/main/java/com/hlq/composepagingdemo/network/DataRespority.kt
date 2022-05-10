package com.hlq.composepagingdemo.network

import com.hlq.composepagingdemo.api.DataApi
import com.hlq.composepagingdemo.bean.DemoReqData


/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc 数据仓库层
 */
class DataRespority {

    private var netWork = RetrofitService.createService(
        DataApi::class.java
    )

    /**
     * 查询数据
     */
    suspend fun loadData(
        pageId: Int
    ): DemoReqData {
        return netWork.getData(pageId)
    }
}