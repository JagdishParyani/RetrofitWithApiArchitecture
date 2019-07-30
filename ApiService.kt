package com.example.retrofit_kotlin

import com.example.apiarchitecture.model.BaseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/json/movies.json")
    fun getMoviesData() : Call<String>

    @GET("/contacts")
    fun getAllContacts() : Call<String>
    //https://api.androidhive.info/contacts/

}