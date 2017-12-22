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
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SetGoalsTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void setGoalsScenario1() {

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
                allOf(withId(R.id.SetGoals), withText("Set Goals"),isDisplayed()));
        appCompatButton1.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.GoalName),isDisplayed()));
        appCompatEditText3.perform(replaceText("Get Big"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.messageText),isDisplayed()));
        appCompatEditText4.perform(replaceText("Bench more than 5 lbs"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.setGoalButton), withText("Set Goal"),isDisplayed()));
        appCompatButton2.perform(click());

        appCompatEditText3.perform(replaceText("Run Fast"), closeSoftKeyboard());

        appCompatEditText4.perform(replaceText("Runn a 100m fast"), closeSoftKeyboard());

        appCompatButton2.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.deleteAllButton), withText("Delete ALl"),isDisplayed()));
        appCompatButton4.perform(click());

    }

    @Test
    public void setGoalsScenario2() {

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
                allOf(withId(R.id.SetGoals), withText("Set Goals"),isDisplayed()));
        appCompatButton1.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.GoalName),isDisplayed()));
        appCompatEditText3.perform(replaceText("Get Big"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.messageText),isDisplayed()));
        appCompatEditText4.perform(replaceText("Bench more than 5 lbs"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.setGoalButton), withText("Set Goal"),isDisplayed()));
        appCompatButton2.perform(click());

        appCompatEditText3.perform(replaceText("Run Fast"), closeSoftKeyboard());

        appCompatEditText4.perform(replaceText("Runn a 100m fast"), closeSoftKeyboard());

        appCompatButton2.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        appCompatEditText3.perform(replaceText("Run Fast"), closeSoftKeyboard());


        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.deleteButton), withText("Delete"),isDisplayed()));
        appCompatButton3.perform(click());
    }

    @Test
    public void setGoalsScenario3() {


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
                allOf(withId(R.id.SetGoals), withText("Set Goals"),isDisplayed()));
        appCompatButton1.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.GoalName),isDisplayed()));
        appCompatEditText3.perform(replaceText("Bench"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.messageText),isDisplayed()));
        appCompatEditText4.perform(replaceText("Bench more than 5 lbs"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.setGoalButton), withText("Set Goal"),isDisplayed()));
        appCompatButton2.perform(click());

    }
}
