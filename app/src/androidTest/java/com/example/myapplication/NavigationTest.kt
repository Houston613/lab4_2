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
        aboutOnScreen()
    }

    @Test
    fun testFromFirstToSecond() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        fragment2OnScreen()

    }

    @Test
    fun testFromSecondToFirst() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        fragment2OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst)).perform(ViewActions.click())
        fragment1OnScreen()

    }

    @Test
    fun testFromSecondToThird(){
        launchActivity<MainActivity>()
        fragment1OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        fragment2OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird)).perform(ViewActions.click())
        fragment3OnScreen()
    }

    @Test
    fun testFromThirdToFirst(){
        launchActivity<MainActivity>()
        fragment1OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        fragment2OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird)).perform(ViewActions.click())
        fragment3OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst)).perform(ViewActions.click())
        fragment1OnScreen()

    }

    @Test
    fun testFromThirdToSecond(){
        launchActivity<MainActivity>()
        fragment1OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        fragment2OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird)).perform(ViewActions.click())
        fragment3OnScreen()
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond)).perform(ViewActions.click())
        fragment2OnScreen()
    }
    private fun fragment1OnScreen() {
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun fragment2OnScreen() {
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun fragment3OnScreen() {
        Espresso.onView(ViewMatchers.withId(R.id.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun aboutOnScreen() {
        Espresso.onView(ViewMatchers.withId(R.id.activity_about))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tvAbout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}