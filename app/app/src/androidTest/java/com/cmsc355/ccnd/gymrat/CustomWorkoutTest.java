package com.cmsc355.ccnd.gymrat;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


@RunWith(AndroidJUnit4.class)
public class CustomWorkoutTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    /*
           USER STORY / SCENARIO TESTING BEGINS HERE
    */

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void customWorkoutScenarioThree() {
        customWorkoutScenarioTwo();
        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(android.R.id.text1), withText("Cable pushdowns"),
                        childAtPosition(
                                withId(R.id.exercisesNames),
                                1),
                        isDisplayed()));
        appCompatTextView3.perform(click());
        ViewInteraction editText = onView(
                allOf(withId(R.id.workoutName), isDisplayed()));
        editText.perform(replaceText("tricep workout"), closeSoftKeyboard());
        ViewInteraction editText2 = onView(
                allOf(withId(R.id.numOfSets), isDisplayed()));
        editText2.perform(replaceText("4"), closeSoftKeyboard());
        ViewInteraction editText3 = onView(
                allOf(withId(R.id.weight), isDisplayed()));
        editText3.perform(replaceText("35"), closeSoftKeyboard());
        ViewInteraction button = onView(
                allOf(withId(R.id.addExercisebtn), withText("Save"), isDisplayed()));
        button.perform(click());
    }


    @Test
    public void customWorkoutScenarioOne() {


        ViewInteraction appCompatAutoCompleteTextView = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView.perform(scrollTo(), replaceText("charleswells@email.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.password));
        appCompatEditText.perform(scrollTo(), replaceText("burger11"), closeSoftKeyboard());



        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.email_sign_in_button), withText("Sign In"),
                        withParent(allOf(withId(R.id.email_login_form),
                                withParent(withId(R.id.login_form))))));
        appCompatButton.perform(scrollTo(), click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.CreateCustomWorkout), withText("Create Custom Workout"), isDisplayed()));
        appCompatButton2.perform(click()); // when "Create Custom Workout" is clicked
    }

    @Test
    public void customWorkoutScenarioTwo() {

        customWorkoutScenarioOne();
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.Triceps), withText("Triceps"),
                        withParent(withId(R.id.gridLayout2)),
                        isDisplayed()));
        appCompatButton2.perform(click());
    }



}
