package com.example.myapplication1

import com.example.myapplication1.models.Driver
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

  @GET("api/f1/current/driverStandings.json")
  fun getData(): Call<List<Driver>>

}