package com.example.afinal

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.afinal.data.CountryDetail
import com.example.afinal.data.CountryListItem
import com.example.afinal.data.CountryList
import com.example.afinal.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel(application: Application) : AndroidViewModel(application) {
    private val mutableCountryDetail = MutableLiveData<List<CountryDetail>>()
    private lateinit var countries: LiveData<List<CountryListItem>>

    fun getCountryById(id: String){
        RetrofitInstance.countryApi.getCountryById(id).enqueue(object: Callback<CountryList> {
            override fun onResponse(call: Call<CountryList>, response: Response<CountryList>) {
                mutableCountryDetail.value = response.body()!!.countries
            }

            override fun onFailure(call: Call<CountryList>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }
        })
    }
}