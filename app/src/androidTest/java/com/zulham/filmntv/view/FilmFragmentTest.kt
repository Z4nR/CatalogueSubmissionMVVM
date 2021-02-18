package com.zulham.filmntv.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.zulham.filmntv.R
import com.zulham.filmntv.adapter.FilmAdapter.ViewHolder
import com.zulham.filmntv.model.DataFilm
import org.junit.Rule
import org.junit.Test

class FilmFragmentTest{

    @get : Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val LIST_ITEM_IN_TEST = 4
    val MOVIE_IN_TEST = DataFilm.list[LIST_ITEM_IN_TEST]

    @Test
    fun test_isListFragment_onLaunch() {
        onView(withId(R.id.tab_layout_main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectItem_DetailVisible() {
        onView(withId(R.id.tab_layout_main))
                .perform(actionOnItemAtPosition<ViewHolder>(LIST_ITEM_IN_TEST, click()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(MOVIE_IN_TEST.title)))
    }
}