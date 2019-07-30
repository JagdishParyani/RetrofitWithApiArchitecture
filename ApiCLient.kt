package com.example.retrofit_kotlin

import com.google.gson.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

class ApiCLient() {

        private lateinit var mRetrofit: Retrofit
        private val mBaseUrl : String = "https://api.androidhive.info"

        fun getClient(): ApiService {
            val gson = GsonBuilder()
                .registerTypeAdapter(String::class.java, StringDesirializer())
                .create()
            mRetrofit = Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return mRetrofit.create(ApiService::class.java)
        }
    }

class StringDesirializer : JsonDeserializer<String> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): String {
        return json.toString()
    }
}
