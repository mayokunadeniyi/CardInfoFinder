package com.mayokunadeniyi.cardinfofinder


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import com.mayokunadeniyi.cardinfofinder.ui.utils.DataBindingIdlingResource
import com.mayokunadeniyi.cardinfofinder.ui.utils.monitorActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

import org.junit.After

/**
 * Created by Mayokun Adeniyi on 25/07/2020.
 */
@RunWith(MockitoJUnitRunner::class)
class MainActivityTest {

    //region constants

    //endregion constants

    //region helper fields

    private val dataBindingIdlingResource = DataBindingIdlingResource()
    //endregion helper fields

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(dataBindingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(dataBindingIdlingResource)
    }


    @Test
    fun onKeyboardFragmentCardClicked_navigateToKeyboardFragmentAndBack(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        dataBindingIdlingResource.monitorActivity(activityScenario)

        onView(withId(R.id.welcome_text_view))
            .check(matches(isDisplayed()))
        onView(withId(R.id.keyboard_card))
            .check(matches(isDisplayed()))
        onView(withId(R.id.ocr_card))
            .check(matches(isDisplayed()))

        onView(withId(R.id.keyboard_card)).perform(ViewActions.click())

        onView(withId(R.id.welcome_text_view))
            .check(doesNotExist())
        pressBack()
        onView(withId(R.id.welcome_text_view))
            .check(matches(isDisplayed()))

        activityScenario.close()
    }



    // region helper methods

    // endregion helper methods

    // region helper classes

    // endregion helper classes

}