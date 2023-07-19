package com.rodgim.pokedex.di

import com.rodgim.pokedex.data.datasources.PokemonRemoteDataSource
import com.rodgim.pokedex.data.datasources.RetrofitPokemonRemoteDataSource
import com.rodgim.pokedex.data.remote.PokeApi
import com.rodgim.pokedex.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun providePokeApi(
        retrofit: Retrofit
    ): PokeApi = retrofit.create(PokeApi::class.java)

    @Singleton
    @Provides
    fun providePokemonRemoteDataSource(
        api: PokeApi
    ): PokemonRemoteDataSource = RetrofitPokemonRemoteDataSource(api)
}