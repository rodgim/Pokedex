package com.rodgim.pokedex.di

import com.rodgim.pokedex.BuildConfig
import com.rodgim.pokedex.data.datasources.PokemonRemoteDataSource
import com.rodgim.pokedex.data.datasources.RetrofitPokemonRemoteDataSource
import com.rodgim.pokedex.data.remote.LoggingInterceptor
import com.rodgim.pokedex.data.remote.PokeApi
import com.rodgim.pokedex.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: LoggingInterceptor
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): LoggingInterceptor = LoggingInterceptor()

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