package com.ujujzk.tryshazam.data.identify


/**
 * Created by ujujzk on 12.02.2018
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

interface SongIdentifyService {

    // Called to start identifying/discovering the song that is currently playing
    fun startIdentication(callback: SongIdentificationCallback)

    // Called to stop identifying/discovering song
    fun stopIdentification()


    interface SongIdentificationCallback {
        // Called when the user is offline and music identification failed
        fun onOfflineError()

        // Called when a generic error occurs and music identification failed
        fun onGenericError()

        // Called when music identification completed but couldn't identify the song
        fun onSongNotFound()

        // Called when identification completed and a matching song was found
        fun onSongFound(song: Song)
    }
}