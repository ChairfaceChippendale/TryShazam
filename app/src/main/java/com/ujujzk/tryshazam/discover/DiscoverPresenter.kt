package com.ujujzk.tryshazam.discover

import com.ujujzk.tryshazam.data.identify.SongIdentifyService


/**
 * Created by ujujzk on 12.02.2018
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

class DiscoverPresenter(private val songIdentifyService: SongIdentifyService): DiscoverContract.Presenter {

    override fun takeView(view: DiscoverContract.View) {
        TODO("implement this")
    }

    override fun dropView() {
        TODO("implement this")
    }

    override fun onStartIdentifyButtonClicked() {
        TODO("implement this")
    }

    override fun onStopIdentifyButtonClicked() {
        TODO("implement this")
    }

    override fun onDonateButtonClicked() {
        TODO("implement this")
    }

    override fun onHistoryButtonClicked() {
        TODO("implement this")
    }
}