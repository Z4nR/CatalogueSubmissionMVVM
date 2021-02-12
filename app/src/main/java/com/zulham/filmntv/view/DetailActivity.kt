package com.zulham.filmntv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.zulham.filmntv.model.DataModel
import com.zulham.filmntv.R
import com.zulham.filmntv.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<DataModel>("film")

        detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailViewModel::class.java)

        movie?.let { detailViewModel.setDetail(it) }

        detailViewModel.getDetai().observe(this, {
            movie?.let { showDetail(it) }
        })


    }

    private fun showDetail(mov: DataModel){
        mov?.let { img_poster_detail.setImageResource(it.img) }
        title_detail.text = mov?.title
        genre_detail.text = mov?.genre
        release_detail.text = mov?.releaseDate
        ph_detail.text = mov?.production
        desc_detail.text = mov?.desc
    }
}