package com.payelpaul.mvmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.payelpaul.mvmvvm.adapter.ArtistAdapter
import com.payelpaul.mvmvvm.api.PersonService
import com.payelpaul.mvmvvm.api.RetrofitHelper
import com.payelpaul.mvmvvm.databinding.ActivityMainBinding
import com.payelpaul.mvmvvm.db.ArtistDao
import com.payelpaul.mvmvvm.db.ArtistDataBase
import com.payelpaul.mvmvvm.reposi.PopularRepository
import com.payelpaul.mvmvvm.viewmodel.MainModelFactory
import com.payelpaul.mvmvvm.viewmodel.Mainviewmodel

class MainActivity : AppCompatActivity() {
    //https://api.themoviedb.org/3/person/popular/?api_key=df57ebe7d0723991d4ab8564e57256dc

    lateinit var viewModel: Mainviewmodel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val respo = (application as ApplicationMovie).repository


        viewModel = ViewModelProvider(this, MainModelFactory(respo)).get(Mainviewmodel::class.java)


        viewModel.checkInternet.observe(this, Observer {
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
        })





        initRecyclerView()

    }
//fun checkDb(dao:ArtistDao){
//    val dao = ArtistDataBase.getDatabase(applicationContext).artistDao()
//    if (dao.getArtist().isEmpty()){
//        Log.e("japan","database is emptry")
//    }
//}

    private fun initRecyclerView(){
        binding.tvRecyclerView.layoutManager=LinearLayoutManager(this)
        adapter= ArtistAdapter()
        binding.tvRecyclerView.adapter = adapter
        displayPopularArtist()
    }

    private fun displayPopularArtist() {
       val response= viewModel.liveDataPopular
        response.observe(this, Observer {
            if (it!=null){
                adapter.setList(it.results)
                adapter.notifyDataSetChanged()
            }
        })
    }

}