package com.santrucho.myplants.util

import com.santrucho.myplants.data.network.ApiService
import com.santrucho.myplants.repository.DefaultPlantRepository
import com.santrucho.myplants.repository.PlantRepository
import com.santrucho.myplants.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun providePlantRepository(implementation: DefaultPlantRepository): PlantRepository =
        implementation

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}