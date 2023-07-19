package com.rodgim.pokedex.data.datasources

import com.rodgim.pokedex.data.remote.PokeApi
import com.rodgim.pokedex.data.remote.responses.Pokemon
import com.rodgim.pokedex.data.remote.responses.PokemonList
import javax.inject.Inject

class RetrofitPokemonRemoteDataSource @Inject constructor(
    private val api: PokeApi
) : PokemonRemoteDataSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonList> {
        return try {
            val response = api.getPokemonList(limit, offset)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Result.success(result)
            } else {
                Result.failure(Exception("An unknown error occurred"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPokemonDetail(pokemonName: String): Result<Pokemon> {
        return try {
            val response = api.getPokemonDetail(pokemonName)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Result.success(result)
            } else {
                Result.failure(Exception("An unknown error occurred"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}