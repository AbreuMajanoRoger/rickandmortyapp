package com.example.rickandmortyapp.data



import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitService {

    @GET("character/")
    suspend fun searchByName(@Query("name") query:String): Response<CharactersDataResponsive>


    @GET("character/id")
    fun getId(@Query("id") id: Int): Response<ResultCharacters>





}


