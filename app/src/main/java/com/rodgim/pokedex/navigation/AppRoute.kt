package com.rodgim.pokedex.navigation

sealed class AppRoute(val route: String) {
    object ListScreen : AppRoute("pokemon_list_screen")

    object DetailScreen : AppRoute("pokemon_detail_screen/{${PokemonArgs.COLOR}}/{${PokemonArgs.NAME}}") {
        fun createRoute(dominantColor: Int, pokemonName: String) = "pokemon_detail_screen/$dominantColor/$pokemonName"
    }
}

object PokemonArgs {
    const val COLOR = "dominantColor"
    const val NAME = "pokemonName"
}
