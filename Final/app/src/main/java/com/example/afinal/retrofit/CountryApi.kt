package com.example.afinal.retrofit

import com.example.afinal.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryApi {
    @GET("countries")
    fun getCountries(): Call<CountryList>

    @GET("country/?")
    fun getCountryById(@Query("i") id: String): Call<CountryDetail>
}