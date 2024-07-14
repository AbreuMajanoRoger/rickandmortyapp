package com.example.rickandmortyapp.data

import com.google.gson.annotations.SerializedName

data class CharactersDataResponsive(
    //@SerializedName ("info") val info:infoCharacters ,
    @SerializedName("results") val results:List<ResultCharacters>
) {}

data class ResultCharacters(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("image") val image:String,
    @SerializedName("status") val status:String,
    @SerializedName("species") val species:String,
    @SerializedName("gender") val gender:String
){}

data class infoCharacters(
    @SerializedName("count")val count:String,
    @SerializedName("page")val page:String,
    @SerializedName("next")val next:String
)