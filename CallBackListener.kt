package com.example.apiarchitecture.controller

import com.example.apiarchitecture.model.BaseModel

interface CallBackListener {

    fun handleSuccessData(resModel: BaseModel)
    fun networkConnectionError()
    fun onserverConnectionError()
    fun handleErrorDataFromServer(errorModel: BaseModel)
}