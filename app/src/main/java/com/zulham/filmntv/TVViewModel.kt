package com.zulham.filmntv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TVViewModel: ViewModel() {
    private val listFilm = MutableLiveData<ArrayList<DataModel>>()

    fun setData(){
        listFilm.postValue(DataTV.list)
    }

    fun getData(): LiveData<ArrayList<DataModel>> {
        return listFilm
    }
}