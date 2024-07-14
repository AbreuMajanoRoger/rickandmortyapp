package com.example.rickandmortyapp.data



import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitService {

    @GET("character/")
    suspend fun searchByName(@Query("name") query:String): Response<CharactersDataResponsive>


    @GET("character/{id}")
   suspend fun getId(@Path("id") id: Int): ResultCharacters

    //     https://rickandmortyapi.com/api/
    //https://rickandmortyapi.com/api/character/1
    //https://rickandmortyapi.com/api/character/10


   // https://superheroapi.com/api/10229233666327556/{id}


    //  @GET("/api/10229233666327556/search/{name}")
    //    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<SuperHeroDataResponse>




    //    @GET("/api/10229233666327556/{id}")
    //    suspend fun getSuperheroDetail(@Path("id") superheroId:String):Response<SuperHeroDetailResponse>


    // / https://superheroapi.com/api/10229233666327556/{id}

   // https://rickandmortyapi.com/api/morty

//https://superheroapi.com/api/10229233666327556/1



///https://superheroapi.com/api/10229233666327556/search/a





}


