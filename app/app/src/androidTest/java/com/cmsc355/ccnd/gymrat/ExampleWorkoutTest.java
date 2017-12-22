package com.cmsc355.ccnd.gymrat;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

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

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExampleWorkoutTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void exampleWorkoutScenario1() {

        ViewInteraction appCompatAutoCompleteTextView = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView.perform(scrollTo(), click());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(scrollTo(), replaceText("charleswells@email.com"), closeSoftKeyboard());

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

        ViewInteraction appCompatButton1 = onView(
                allOf(withId(R.id.ExampleWorkout), withText("Example Workout"),isDisplayed()));
        appCompatButton1.perform(click());


    }

    @Test
    public void exampleWorkoutScenario2() {

        ViewInteraction appCompatAutoCompleteTextView = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView.perform(scrollTo(), click());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(scrollTo(), replaceText("charleswells@email.com"), closeSoftKeyboard());

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

        ViewInteraction appCompatButton1 = onView(
                allOf(withId(R.id.ExampleWorkout), withText("Example Workout"),isDisplayed()));
        appCompatButton1.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.abBtn), withText("Abs"),isDisplayed()));
        appCompatButton2.perform(click());

    }

    @Test
    public void exampleWorkoutScenario3() {

        ViewInteraction appCompatAutoCompleteTextView = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView.perform(scrollTo(), click());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(scrollTo(), replaceText("charleswells@email.com"), closeSoftKeyboard());

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

        ViewInteraction appCompatButton1 = onView(
                allOf(withId(R.id.ExampleWorkout), withText("Example Workout"),isDisplayed()));
        appCompatButton1.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.abBtn), withText("Abs"),isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.exampleDisplay), isDisplayed()));
        appCompatButton3.perform(click());

    }

}
