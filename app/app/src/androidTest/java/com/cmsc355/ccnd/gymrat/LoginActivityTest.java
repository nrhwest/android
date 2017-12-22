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

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    //Scenario 1 for the login activity tests to see if information was right and moves to the home screen
    public void loginScenario1() {
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
    }


    @Test
    //Scenario 1 for the login activity tests to see if information was right and moves to the home screen
    public void loginScenario2() {

        loginScenario1();

        //Button My Profile gets us to the My Profile Screen
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.MyProfile), withText("My Profile"), isDisplayed()));
        appCompatButton2.perform(click());
    }

    @Test
    public void loginScenario3(){
        loginScenario1();
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.MyProfile), withText("My Profile"), isDisplayed()));
        appCompatButton2.perform(click());
        //Button Logout gets us back to the Login Screen
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.Logout), withText("Logout"), isDisplayed()));
        appCompatButton3.perform(click());
    }

}
