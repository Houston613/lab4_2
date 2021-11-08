package com.example.myapplication

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class RotationTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun firstFragmentRotationTest() {
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        Thread.sleep(1000)
        fragment1OnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        fragment1OnScreen()
    }

    @Test
    fun secondFragmentRotationTest() {
        onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        Thread.sleep(1000)
        fragment2OnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        fragment2OnScreen()
    }

    @Test
    fun thirdFragmentRotationTest() {
        onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        Thread.sleep(1000)
        fragment3OnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        fragment3OnScreen()
    }

    @Test
    fun aboutRotationTest() {
        openAbout()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        Thread.sleep(1000)
        aboutOnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        aboutOnScreen()
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