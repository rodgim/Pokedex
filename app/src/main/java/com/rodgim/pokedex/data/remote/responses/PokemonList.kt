package com.rodgim.pokedex.data.remote.responses

data class PokemonList(
    val count: Int,
    val next: String,
    val results: List<PokemonListItem>
)

data class PokemonListItem(
    val name: String,
    val url: String
)
