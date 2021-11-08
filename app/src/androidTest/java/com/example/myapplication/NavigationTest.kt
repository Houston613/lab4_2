package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @Test
    fun testAbout() {
        launchActivity<MainActivity>()
        openAbout()
        Espresso.onView(ViewMatchers.withId(R.id.activity_about))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromFirstToSecond() {
        launchActivity<MainActivity>()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromSecondToFirst() {
        launchActivity<MainActivity>()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromSecondToThird(){
        launchActivity<MainActivity>()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromThirdToFirst(){
        launchActivity<MainActivity>()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromThirdToSecond(){
        launchActivity<MainActivity>()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}