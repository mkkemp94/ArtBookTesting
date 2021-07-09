package com.mkemp.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.mkemp.artbooktesting.model.ImageResponse
import com.mkemp.artbooktesting.roomdb.Art
import com.mkemp.artbooktesting.util.Resource

interface ArtRepositoryInterface
{
    suspend fun insertArt(art: Art)
    
    suspend fun deleteArt(art: Art)
    
    fun getArt() : LiveData<List<Art>>
    
    suspend fun searchImage(imageString : String) : Resource<ImageResponse>
}