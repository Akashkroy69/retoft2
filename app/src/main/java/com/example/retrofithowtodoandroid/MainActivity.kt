package com.example.retrofithowtodoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Callback
import com.example.retrofithowtodoandroid.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        //rv
        val rvAdapter = AdapterClass()
        binding.rv.adapter = rvAdapter

        val apiInterface = ApiInterface.createInstance().getMovies()

        apiInterface.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.body() != null) {
                    rvAdapter.dataSet = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {

            }

        })


    }
}