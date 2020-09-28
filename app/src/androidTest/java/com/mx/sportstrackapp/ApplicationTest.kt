package com.mx.sportstrackapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import com.mx.sportstrackapp.ui.main.adapter.TeamResultsAdapter
import com.mx.sportstrackapp.util.EspressoIdlingResource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.core.IsNot.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@LargeTest
class ApplicationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun runApp() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.textInputEditText))
            .perform(
                ViewActions.typeText(USER_SEARCH),
                ViewActions.closeSoftKeyboard()
            )
        onView(withId(R.id.button))
            .check(matches(ViewMatchers.withText(BUTTON_STRING)))
            .perform(click())
        // Idle Resource
        onView(withId(R.id.recyclerview_teams))
            .check(matches(isDisplayed()))
        onView(withId(R.id.progressBar))
            .check(matches(not(isDisplayed())))
        onView(withId(R.id.recyclerview_teams))
            .perform(
                actionOnItemAtPosition<TeamResultsAdapter.TeamViewHolder>(2, click())
            )
    }

    companion object {
        const val USER_SEARCH = "Arsenal"
        const val BUTTON_STRING = "Search"
    }

}