package com.ujujzk.tryshazam.discover

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.ujujzk.tryshazam.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by ujujzk on 28.11.2017
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

@RunWith(AndroidJUnit4::class)
// Read more about test sizes here: https://plus.google.com/+AndroidDevelopers/posts/TPy1EeSaSg8
@LargeTest
class DiscoverActivityTest {

    // Required to expose the property as a field, if not you will get an error when you try to run the test
    @JvmField
    @Rule
    val mDiscoverActivityTestRule = ActivityTestRule<DiscoverActivity>(DiscoverActivity::class.java)

    @Test
    fun onViewLoadedShowDiscoverFragment() {
        onView(withId(R.id.discover_fragment_view)).check(matches(isDisplayed()))
    }
}
