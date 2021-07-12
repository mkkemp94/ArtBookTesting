package com.mkemp.artbooktesting.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.mkemp.artbooktesting.MainCoroutineRule
import com.mkemp.artbooktesting.getOrAwaitValueTest
import com.mkemp.artbooktesting.repo.FakeArtRepository
import com.mkemp.artbooktesting.util.Status
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewModelTest
{
    // make sure everything runs on the main thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    
    private lateinit var viewModel: ArtViewModel
    
    @Before
    fun setup()
    {
        // Test Doubles
        viewModel = ArtViewModel(FakeArtRepository())
    }
    
    @Test
    fun makeArt_withoutYear_returnsError()
    {
        viewModel.makeArt("Mona Lisa", "Da Vinci", "")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }
    
    @Test
    fun makeArt_withoutName_returnsError()
    {
        viewModel.makeArt("", "Da Vinci", "1900")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }
    
    @Test
    fun makeArt_withoutArtistName_returnsError()
    {
        viewModel.makeArt("", "l", "1900")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }
}