package com.example.rickandmortyapp.data



import retrofit2.http.GET
import retrofit2.http.Path



interface RetrofitService {

    @GET("?name={character}")
    suspend fun getCharactersList(@Path("character")query:String):CharactersDataResponsive

}


