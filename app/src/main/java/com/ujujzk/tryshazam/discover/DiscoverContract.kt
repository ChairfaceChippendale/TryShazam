package com.ujujzk.tryshazam.discover

import com.ujujzk.tryshazam.BasePresenter
import com.ujujzk.tryshazam.BaseView
import com.ujujzk.tryshazam.data.identify.Song


/**
 * Created by ujujzk on 12.02.2018
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

interface DiscoverContract {

    interface View: BaseView<Presenter> {

        fun showIdentifyProgressView()
        fun hideIdentifyProgressView()

        fun showStartIdentifyButtonView()
        fun hideStartIdentifyButtonView()

        fun showStopIdentifyButtonView()
        fun hideStopIdentifyButtonView()

        fun showOfflineErrorView()
        fun showGenericErrorView()
        fun showNotFoundErrorView()

        fun hideErrorViews()

        fun openSongDetailPage(song: Song)
        fun openDonatePage()
        fun openHistoryPage()

    }

    interface Presenter: BasePresenter<View> {

        fun onStartIdentifyButtonClicked()

        fun onStopIdentifyButtonClicked()

        fun onDonateButtonClicked()

        fun onHistoryButtonClicked()

    }
}