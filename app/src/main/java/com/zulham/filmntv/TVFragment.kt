package com.zulham.filmntv

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_film.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TVFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var tvViewModel: TVViewModel

    /*private lateinit var dataTitle: Array<String>
    private lateinit var dataReleaseDate: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPH: Array<String>
    private lateinit var dataPoster: TypedArray
    private lateinit var tvs: ArrayList<DataModel>*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(TVViewModel::class.java)

        tvViewModel.setData()

        tvViewModel.getData().observe(viewLifecycleOwner, {
            recyclerV(it) }
        )

        /*dataTitle = resources.getStringArray(R.array.tv_title)
        dataReleaseDate = resources.getStringArray(R.array.tv_daterelease)
        dataGenre = resources.getStringArray(R.array.tv_genre)
        dataPH = resources.getStringArray(R.array.tv_ph)
        dataDescription = resources.getStringArray(R.array.tv_desc)
        dataPoster = resources.obtainTypedArray(R.array.img_tv)

        plusItem()

        recyclerV_movie.apply {
            adapter = FilmAdapter(tvs!!, object : FilmAdapter.OnItemClicked{
                override fun onItemClick(position: Int) {
                    Toast.makeText(context, tvs!![position].title+" Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("film", tvs!![position])
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }*/
    }

    private fun recyclerV(tvs: ArrayList<DataModel>){
        recyclerV_movie.apply {
            adapter = FilmAdapter(tvs, object : FilmAdapter.OnItemClicked{
                override fun onItemClick(position: Int) {
                    Toast.makeText(context, tvs[position].title+" Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("film", tvs[position])
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    /*private fun plusItem() {
        tvs = ArrayList()

        for (i in 0 until dataTitle.size){
            val film = DataModel(
                    dataTitle[i],
                    dataReleaseDate[i],
                    dataGenre[i],
                    dataPH[i],
                    dataDescription[i],
                    dataPoster.getResourceId(i, -1)

            )

            tvs.add(film)
        }
    }*/
}