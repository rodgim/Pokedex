package com.rodgim.pokedex.utils

import androidx.compose.ui.graphics.Color
import com.rodgim.pokedex.data.remote.responses.PokemonStat
import com.rodgim.pokedex.data.remote.responses.PokemonType
import com.rodgim.pokedex.ui.theme.AtkColor
import com.rodgim.pokedex.ui.theme.DefColor
import com.rodgim.pokedex.ui.theme.HPColor
import com.rodgim.pokedex.ui.theme.SpAtkColor
import com.rodgim.pokedex.ui.theme.SpDefColor
import com.rodgim.pokedex.ui.theme.SpdColor
import com.rodgim.pokedex.ui.theme.TypeBug
import com.rodgim.pokedex.ui.theme.TypeDark
import com.rodgim.pokedex.ui.theme.TypeDragon
import com.rodgim.pokedex.ui.theme.TypeElectric
import com.rodgim.pokedex.ui.theme.TypeFairy
import com.rodgim.pokedex.ui.theme.TypeFighting
import com.rodgim.pokedex.ui.theme.TypeFire
import com.rodgim.pokedex.ui.theme.TypeFlying
import com.rodgim.pokedex.ui.theme.TypeGhost
import com.rodgim.pokedex.ui.theme.TypeGrass
import com.rodgim.pokedex.ui.theme.TypeGround
import com.rodgim.pokedex.ui.theme.TypeIce
import com.rodgim.pokedex.ui.theme.TypeNormal
import com.rodgim.pokedex.ui.theme.TypePoison
import com.rodgim.pokedex.ui.theme.TypePsychic
import com.rodgim.pokedex.ui.theme.TypeRock
import com.rodgim.pokedex.ui.theme.TypeSteel
import com.rodgim.pokedex.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: PokemonType): Color {
    return when(type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: PokemonStat): Color {
    return when(stat.stat.name.lowercase(Locale.ROOT)) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: PokemonStat): String {
    return when(stat.stat.name.lowercase(Locale.ROOT)) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}