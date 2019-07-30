package com.example.apiarchitecture.controller

import com.example.apiarchitecture.model.BaseModel
import com.example.apiarchitecture.model.Movies
import com.example.apiarchitecture.model.ReqModelMovies
import com.example.apiarchitecture.model.ResModelMovies
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MoviesController : BaseController() {

    override fun onPopulate(objJson: JSONObject?) {
        //var objArr: JSONArray = objJson!!.getJSONArray("data")
        var resModelMovies : Movies = Gson().fromJson(objJson.toString(),Movies::class.java)
        this.mCallBackListener.handleSuccessData(resModelMovies)
    }

    override fun startFetching(callBackListner: CallBackListener) {
        super.startFetching(callBackListner)
        this.mCallBackListener = callBackListner
        callRequestToServer(mApiService.getMoviesData())
    }
}