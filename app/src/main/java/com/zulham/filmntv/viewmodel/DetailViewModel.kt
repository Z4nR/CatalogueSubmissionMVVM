package com.zulham.filmntv.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zulham.filmntv.model.DataModel

class DetailViewModel: ViewModel() {
    private val detailShow = MutableLiveData<DataModel>()

    fun setDetail(movie: DataModel){
        movie.desc
        movie.genre
        movie.img
        movie.production
        movie.releaseDate
        movie.title

        detailShow.postValue(movie)
    }

    fun getDetai(): LiveData<DataModel> {
        return detailShow
    }
}