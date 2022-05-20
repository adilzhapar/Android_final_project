package com.example.afinal.adapter;

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.data.CountryDetail
import com.example.afinal.data.CountryListItem
import com.example.afinal.databinding.CountryCardBinding
import java.text.FieldPosition

class CountriesRecyclerAdapter :
    RecyclerView.Adapter<CountriesRecyclerAdapter.CountriesViewHolder>(){
    private var countries: List<CountryListItem> = ArrayList()
    private lateinit var onCountryClickListener: OnCountryClickListener

    fun setCountriesList(countries: List<CountryListItem>){
        this.countries = countries
        notifyDataSetChanged()
    }

    fun getCountryByPosition(position: Int):CountryListItem{
        return countries[position]
    }

    fun setOnCountryClickListener(onCountryClickListener: OnCountryClickListener){
        this.onCountryClickListener = onCountryClickListener
    }


    class CountriesViewHolder(val binding: CountryCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(CountryCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val i = position
        holder.binding.apply {
            tvCountryName.text = countries[position].Country
            tvIso2.text =countries[position].ISO2
        }

        holder.itemView.setOnClickListener {
            onCountryClickListener.onCountryClick(countries[position])
        }
    }


    interface OnCountryClickListener {
        fun onCountryClick(country: CountryListItem)
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}