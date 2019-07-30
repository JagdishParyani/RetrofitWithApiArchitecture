package com.example.apiarchitecture.controller

import android.util.Log
import com.example.apiarchitecture.model.BaseModel
import com.example.retrofit_kotlin.ApiCLient
import com.example.retrofit_kotlin.ApiService
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract open class BaseController {

    val TAG = "BaseController"
    lateinit var mCallBackListener: CallBackListener
    lateinit var mBaseModel: BaseModel
    lateinit var mApiCLient: ApiCLient
    lateinit var mApiService: ApiService


    fun callRequestToServer(modelCall: Call<String>) {
        //var modelCall: Call<String> = mApiService.getMoviesData()

        modelCall.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                mCallBackListener.networkConnectionError()
                Log.e(TAG, t.message)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.code() == 200) {

                     var obj : JSONObject = JSONObject()
                     var jsonResp = JSONArray(response.body())
                     obj.put("data", jsonResp)

                     onPopulate(obj)

                    //onPopulate(JSONObject(response.body()))
                } else {
                    Log.e(TAG, response.code().toString())
                }
            }
        })
    }

    open fun startFetching(callBackListner: CallBackListener) {
        //Log.e(TAG, "Request :" + Gson().toJson(model))
        this.mCallBackListener = callBackListner
        mApiCLient = ApiCLient()
        mApiService = mApiCLient.getClient()
    }

    abstract fun onPopulate(objJson: JSONObject?)
}