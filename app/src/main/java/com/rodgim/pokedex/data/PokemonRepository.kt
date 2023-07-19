package com.rodgim.pokedex.data

import com.rodgim.pokedex.data.datasources.PokemonRemoteDataSource
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getPokemonList(limit: Int, offset: Int) = pokemonRemoteDataSource.getPokemonList(limit, offset)

    suspend fun getPokemonDetail(pokemonName: String) = pokemonRemoteDataSource.getPokemonDetail(pokemonName)
}