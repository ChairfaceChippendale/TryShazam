package com.ujujzk.tryshazam.discover

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.ujujzk.tryshazam.data.identify.Song
import com.ujujzk.tryshazam.data.identify.SongIdentifyService
import org.junit.After
import org.junit.Before
import org.junit.Test


/**
 * Created by ujujzk on 12.02.2018
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

class DiscoverPresenterTest {

    private val mSong = Song()

    // A mocked SongIdentifyService. Mocking is creating objects that simulate the behaviour of real objects.
    private val mSongIdentifyService: SongIdentifyService = mock()
    // A mocked DiscoverView
    private val mDiscoverView: DiscoverContract.View = mock()

    private lateinit var mDiscoverPresenter: DiscoverContract.Presenter

    @Before
    fun setUpDiscoverPresenter(){
        mDiscoverPresenter = DiscoverPresenter(mSongIdentifyService)
        mDiscoverPresenter.takeView(mDiscoverView)
    }

    @After
    fun releasePresenter() {
        mDiscoverPresenter.dropView()
    }

    @Test
    fun onStartIdentifyButtonClickedAndSongWasFoundOpensSongDetailPage() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply {
            // Ensure that when start discovering button is clicked,
            // a call is made to the SongIdentifyService to start song identification
            // Also capture the callback that is passed to the SongIdentifyService startIdentification function
            verify(mSongIdentifyService).startIdentication(capture())

            // Call the callback onSongFound function passing in the simply song object we created
            firstValue.onSongFound(mSong)
        }

        // Ensure that when start discovering button is clicked
        // A call is made to hide the start discovering button,
        // A call is made to show stop discovering button,
        // A call is made to show the progress view,
        // A call is made to hide any error view
        verify(mDiscoverView).hideStartIdentifyButtonView()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()

        // And since the MusicIdentifyService was able to identify the song,
        // ensure that a call was made to open the song detail page
        verify(mDiscoverView).openSongDetailPage(mSong)
    }

    @Test
    fun onStartIdentifyButtonClickedAndSongWasNotFoundShowsSongNotFoundError() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply {
            verify(mSongIdentifyService).startIdentication(capture())
            firstValue.onSongNotFound()
        }

        verify(mDiscoverView).hideStartIdentifyButtonView()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()
        verify(mDiscoverView).showIdentifyProgressView()

        // And since the MusicIdentifyService could not identify the song,
        // ensure that a call was made to show a song not found error view
        verify(mDiscoverView).showNotFoundErrorView()
    }

    @Test
    fun onStartIdentifyButtonClickedAndOfflineErrorShowsOfflineErrorView() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply {
            verify(mSongIdentifyService).startIdentication(capture())
            firstValue.onOfflineError()
        }

        verify(mDiscoverView).hideStartIdentifyButtonView()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()
        verify(mDiscoverView).showIdentifyProgressView()

        // And since the MusicIdentifyService could not identify a song because the user is offline,
        // ensure that a call was made to show an offline error view
        verify(mDiscoverView).showOfflineErrorView()
    }

    @Test
    fun onStartIdentifyButtonClickedAndGenericErrorShowsGenericErrorView() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply {
            verify(mSongIdentifyService).startIdentication(capture())
            firstValue.onGenericError()
        }

        verify(mDiscoverView).hideStartIdentifyButtonView()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()
        verify(mDiscoverView).showIdentifyProgressView()

        // And since the MusicIdentifyService could not identify a song because of a generic error,
        // ensure that a call was made to show an offline error view
        verify(mDiscoverView).showGenericErrorView()
    }

    @Test
    fun onStopIdentifyButtonClicked() {
        mDiscoverPresenter.onStopIdentifyButtonClicked()

        // Ensure that when stop identify button is clicked, music identification is stopped, progress view is hidden,
        // stop discovering button is hidden and start discovering button is shown
        verify(mSongIdentifyService).stopIdentification()
        verify(mDiscoverView).hideIdentifyProgressView()
        verify(mDiscoverView).hideStopIdentifyButtonView()
        verify(mDiscoverView).showStartIdentifyButtonView()
    }

    @Test
    fun onDonateButtonClicked() {
        mDiscoverPresenter.onDonateButtonClicked()
        // Ensure that when the donate button is clicked, a call to open the donate page is made
        verify(mDiscoverView).openDonatePage()
    }

    @Test
    fun onHistoryButtonClicked() {
        mDiscoverPresenter.onHistoryButtonClicked()
        // Ensure that when the history button is clicked, a call to open the history page is made
        verify(mDiscoverView).openHistoryPage()
    }

}