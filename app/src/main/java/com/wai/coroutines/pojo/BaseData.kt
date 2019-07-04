package com.wai.coroutines.pojo

data class BaseData<T>(
    var code : Int,

    var msg: String,

    var data: T
)
