package com.ujujzk.tryshazam


/**
 * Created by ujujzk on 12.02.2018
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

interface BasePresenter<in V> {

    fun takeView(view: V)

    fun dropView()
}