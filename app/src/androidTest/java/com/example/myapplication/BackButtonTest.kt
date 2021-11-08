package com.example.myapplication

import androidx.test.core.app.launchActivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId


import org.junit.Test
class BackButtonTest {
    @Test
    fun backFromSecondToFirst() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        pressBack()
        fragment1OnScreen()
    }
    @Test(expected = androidx.test.espresso.NoActivityResumedException::class)
    fun backFromFirstToNothing() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        pressBack()
    }

    @Test
    fun backFromThirdToSecond() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        onView(withId(R.id.bnToThird)).perform(click())
        fragment3OnScreen()
        pressBack()
        fragment2OnScreen()
    }
    @Test
    fun backFromThirdToFirst() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        onView(withId(R.id.bnToThird)).perform(click())
        fragment3OnScreen()
        pressBack()
        fragment2OnScreen()
        pressBack()
        fragment1OnScreen()

    }

    @Test
    fun backFromAboutToFirst() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        openAbout()
        aboutOnScreen()
        pressBack()
        fragment1OnScreen()
    }

    @Test
    fun backFromAboutToSecond() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        openAbout()
        aboutOnScreen()
        pressBack()
        fragment2OnScreen()
    }

    @Test
    fun backFromAboutToThird() {
        launchActivity<MainActivity>()
        fragment1OnScreen()
        onView(withId(R.id.bnToSecond)).perform(click())
        fragment2OnScreen()
        onView(withId(R.id.bnToThird)).perform(click())
        fragment3OnScreen()
        openAbout()
        aboutOnScreen()
        pressBack()
        fragment3OnScreen()
    }


    private fun fragment1OnScreen() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
    }

    private fun fragment2OnScreen() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))
    }

    private fun fragment3OnScreen() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
    }

    private fun aboutOnScreen() {
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))
    }
}