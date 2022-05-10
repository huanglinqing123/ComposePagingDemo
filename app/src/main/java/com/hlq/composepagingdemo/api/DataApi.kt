package com.hlq.composepagingdemo.api

import com.hlq.composepagingdemo.bean.DemoReqData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author：HuangLinqing
 * @date ：2022/5/10
 * @desc：
 */
interface DataApi {

    /**
     * 获取数据
     */
    @GET("wenda/list/{pageId}/json")
    suspend fun getData(@Path("pageId") pageId:Int): DemoReqData
}