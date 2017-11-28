package com.ujujzk.tryshazam.discover

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ujujzk.tryshazam.R
import com.ujujzk.tryshazam.utils.FragmentUtils


/**
 * Created by ujujzk on 28.11.2017
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */
class DiscoverActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        FragmentUtils.addIfNotExist(
                supportFragmentManager,
                R.id.discover_fragment_container,
                DiscoverFragment(),
                "DiscoverFragment")
    }
}