package com.rodgim.pokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonType>,
    val stats: List<PokemonStat>
)

data class PokemonType(
    val slot: Int,
    val type: PokemonBaseType
)

data class PokemonBaseType(
    val name: String,
    val url: String
)

data class PokemonStat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: PokemonBaseStat
)

data class PokemonBaseStat(
    val name: String,
    val url: String
)
