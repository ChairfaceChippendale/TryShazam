package com.ujujzk.tryshazam.discover

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.ujujzk.tryshazam.R
import kotlinx.android.synthetic.main.fragment_discover.view.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by ujujzk on 21.01.2018
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class DiscoverFragmentTest {

    @JvmField
    @Rule
    val mDiscoverActivityTestRule = ActivityTestRule<DiscoverActivity>(DiscoverActivity::class.java)

    @Test
    fun clickStartIdentifyButtonOpensSongDetailPage() {
        onView(withId(R.id.discoverStartIdentifyButton)).perform(click())
        onView(withId(R.id.songDetailFragmentContainer)).check(matches(isDisplayed()))
    }

    @Test
    fun clickDonateButtonOpensDonatePage() {
        onView(withId(R.id.discoverDonateButton)).perform(click())
        onView(withId(R.id.donateFragmentContainer)).check(matches(isDisplayed()))
    }

    @Test
    fun clickHistoryButtonOpensHistoryPage() {
        onView(withId(R.id.discoverHistoryButton)).perform(click())
        onView(withId(R.id.historyFragmentContainer)).check(matches(isDisplayed()))
    }

}