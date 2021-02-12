package com.zulham.filmntv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zulham.filmntv.model.DataFilm
import com.zulham.filmntv.model.DataModel


class FilmViewModel: ViewModel() {
    private val listFilm = MutableLiveData<ArrayList<DataModel>>()

    fun setData(){
        listFilm.postValue(DataFilm.list)
    }

    fun getData(): LiveData<ArrayList<DataModel>>{
        return listFilm
    }
}