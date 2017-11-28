package com.ujujzk.tryshazam.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


/**
 * Created by ujujzk on 28.11.2017
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */
object FragmentUtils {

    fun addIfNotExist(fm: FragmentManager, containerRes: Int, fragment: Fragment, tag: String) {
        val existingFragmentWithTag = fm.findFragmentByTag(tag)

        if (existingFragmentWithTag == null){
            fm.beginTransaction().add(containerRes, fragment, tag).commit()
        }
    }
}