package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.models.Driver
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    val driverAdapter = DriverAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://ergast.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object: Callback<List<Driver>> {
            override fun onResponse(call: Call<List<Driver>>, response: Response<List<Driver>>) {
               Log.d("checkresponse", response.toString())
            }

            override fun onFailure(call: Call<List<Driver>>, t: Throwable) {
                Log.d("checkresponse", t.toString())
            }

        })

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = driverAdapter

        val drivers = listOf(
            Driver("1","Max Verstapen", "50"),
            Driver("2","Lewis Hamilton", "49"),
            Driver("3","Charles Leclerc", "45"),
            Driver("4", "Lando Norris", "37")
        )
        driverAdapter.updateItems(drivers)
    }
}