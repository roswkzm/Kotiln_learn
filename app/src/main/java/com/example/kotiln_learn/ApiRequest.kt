package com.example.kotiln_learn

import retrofit2.Call
import retrofit2.http.GET


interface ApiRequest {
    companion object{
        const val BASE_URL = "https://api.corona-19.kr"
        const val Token = "WNr54nBbo3w9OCRlpayGhKqmHA1DzLejZ"
    }

    @GET("/korea/country/new/?serviceKey=${Token}")
    fun getApi() : Call<ApiData>
}