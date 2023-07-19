package com.rodgim.pokedex.data.datasources

import com.rodgim.pokedex.data.remote.responses.Pokemon
import com.rodgim.pokedex.data.remote.responses.PokemonList

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonList>
    suspend fun getPokemonDetail(pokemonName: String): Result<Pokemon>
}