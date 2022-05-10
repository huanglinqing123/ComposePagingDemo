package com.hlq.composepagingdemo.bean


/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc
 */
class DemoReqData {
    var data: DataBean? = null
    var errorCode = 0
    var errorMsg: String? = null

    class DataBean {
        var curPage = 0
        var offset = 0
        var isOver = false
        var pageCount = 0
        var size = 0
        var total = 0
        var datas: List<DatasBean>? = null

        class DatasBean {

            var apkLink: String? = null
            var audit = 0
            var author: String? = null
            var isCanEdit = false
            var chapterId = 0
            var chapterName: String? = null
            var isCollect = false
            var courseId = 0
            var desc: String? = null
            var descMd: String? = null
            var envelopePic: String? = null
            var isFresh = false
            var id = 0
            var link: String? = null
            var niceDate: String? = null
            var niceShareDate: String? = null
            var origin: String? = null
            var prefix: String? = null
            var projectLink: String? = null
            var publishTime: Long = 0
            var realSuperChapterId = 0
            var selfVisible = 0
            var shareDate: Long = 0
            var shareUser: String? = null
            var superChapterId = 0
            var superChapterName: String? = null
            var title: String? = null
            var type = 0
            var userId = 0
            var visible = 0
            var zan = 0
            var tags: List<TagsBean>? = null

            class TagsBean {
                /**
                 * name : 本站发布
                 * url : /article/list/0?cid=440
                 */
                var name: String? = null
                var url: String? = null
            }
        }
    }
}