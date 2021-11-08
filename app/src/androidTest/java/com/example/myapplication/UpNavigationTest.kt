package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test

class UpNavigationTest {
    @Test
    fun testNavigateUpFromSecond() {
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        fragment1OnScreen()
    }
    @Test
    fun testNavigateUpFromThird() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        onView(withId(R.id.bnToThird)).perform(click())
        fragment3OnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        fragment2OnScreen()
    }
    @Test
    fun testNavigateUpFromAboutToFirst() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        openAbout()
        aboutOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        fragment1OnScreen()
    }
    @Test
    fun testNavigateUpFromAboutToSecond() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        openAbout()
        aboutOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        fragment2OnScreen()
    }
    @Test
    fun testNavigateUpFromAboutToThird() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        onView(withId(R.id.bnToThird)).perform(click())
        fragment3OnScreen()
        openAbout()
        aboutOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        fragment3OnScreen()
    }

    private fun fragment1OnScreen() {
        onView(withId(R.id.activity_main)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.fragment1)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun fragment2OnScreen() {
        onView(withId(R.id.activity_main)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.fragment2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.bnToThird)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun fragment3OnScreen() {
        onView(withId(R.id.activity_main)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.fragment3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun aboutOnScreen() {
        onView(withId(R.id.activity_about)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tvAbout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}