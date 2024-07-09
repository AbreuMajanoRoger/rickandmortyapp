package com.example.rickandmortyapp.data

import com.google.gson.annotations.SerializedName

data class CharactersDataResponsive(
    @SerializedName ("info") val info:infoCharacters ,
    @SerializedName("results") val results:List<reultsCharacters>
) {}

data class reultsCharacters(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String
){}

data class infoCharacters(
    @SerializedName("count")val count:String,
    @SerializedName("page")val page:String,
    @SerializedName("next")val next:String
)