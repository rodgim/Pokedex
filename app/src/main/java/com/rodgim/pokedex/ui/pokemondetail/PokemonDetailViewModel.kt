package com.rodgim.pokedex.ui.pokemondetail

import androidx.lifecycle.ViewModel
import com.rodgim.pokedex.data.PokemonRepository
import com.rodgim.pokedex.data.remote.responses.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonDetail(pokemonName: String): UiPokemonDetailState {
        val result = repository.getPokemonDetail(pokemonName)
        return result.fold(
            onSuccess = {
                UiPokemonDetailState.Success(it)
            },
            onFailure = {
                UiPokemonDetailState.Failure(it.message ?: "Unexpected error")
            }
        )
    }
}

sealed class UiPokemonDetailState {
    data class Success(val data: Pokemon): UiPokemonDetailState()
    data class Failure(val message: String): UiPokemonDetailState()
    object Loading: UiPokemonDetailState()
}
