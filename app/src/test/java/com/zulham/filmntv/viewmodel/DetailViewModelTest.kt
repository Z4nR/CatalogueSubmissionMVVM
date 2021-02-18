package com.zulham.filmntv.viewmodel

import com.zulham.filmntv.R
import com.zulham.filmntv.model.DataModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun setUp(){
        detailViewModel = DetailViewModel()
    }

    @Test
    fun setDetail() {
        val movieDetail = detailViewModel.setDetail(DataModel(title = "Jumanji", desc = "Set in 1869, two children receive a mysterious game after their father goes missing in the jungles of Africa. They unravel both the secret of their father’s disappearance and the origin of Jumanji. See how it all began.", production = "Anchors", releaseDate = "January, 20 2021", img = R.drawable.jumanji, genre = "Adventure, Comedy"))
        assertNotNull(movieDetail)
    }

    @Test
    fun getDetail() {
        val movieDetail = detailViewModel.getDetail()
        assertNotNull(movieDetail)
    }
}