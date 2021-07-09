package com.mkemp.artbooktesting.di

import android.content.Context
import androidx.room.Room
import com.mkemp.artbooktesting.api.RetrofitAPI
import com.mkemp.artbooktesting.roomdb.ArtDatabase
import com.mkemp.artbooktesting.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule
{
    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
            context, ArtDatabase::class.java, "ArtBookDB"
    ).build()
    
    @Singleton
    @Provides
    fun injectDao(database: ArtDatabase) = database.artDao()
    
    @Singleton
    @Provides
    fun injectRetrofitAPI() : RetrofitAPI {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(RetrofitAPI::class.java)
    }
}