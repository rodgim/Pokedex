package com.rodgim.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rodgim.pokedex.ui.pokemondetail.PokemonDetailScreen
import com.rodgim.pokedex.ui.pokemonlist.PokemonListScreen
import java.util.Locale

@Composable
fun NavHostContainer(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppRoute.ListScreen.route) {
        composable(AppRoute.ListScreen.route) {
            PokemonListScreen(
                onPokemonSelected = { color, name ->
                    navController.navigate(
                        AppRoute.DetailScreen.createRoute(color.toArgb(), name)
                    )
                }
            )
        }
        composable(
            AppRoute.DetailScreen.route,
            arguments = listOf(
                navArgument(PokemonArgs.COLOR) {
                    type = NavType.IntType
                },
                navArgument(PokemonArgs.NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt(PokemonArgs.COLOR)
                color?.let { Color(it) } ?: Color.White
            }
            val pokemonName = remember {
                it.arguments?.getString(PokemonArgs.NAME)
            }
            PokemonDetailScreen(
                dominantColor = dominantColor,
                pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "",
                goBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
