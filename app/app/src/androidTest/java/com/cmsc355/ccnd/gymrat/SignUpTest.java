package com.cmsc355.ccnd.gymrat;


import android.support.test.espresso.DataInteraction;
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

import java.util.UUID;

import static android.support.test.espresso.Espresso.onData;
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
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SignUpTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);


    @Test
    public void signUpScenario1() {

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.sign_up_button), withText("Sign Up"),
                        withParent(allOf(withId(R.id.email_login_form),
                                withParent(withId(R.id.login_form))))));
        appCompatButton.perform(scrollTo(), click());

    }

    @Test
    public void signUpScenario2() {

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.sign_up_button), withText("Sign Up"),
                        withParent(allOf(withId(R.id.email_login_form),
                                withParent(withId(R.id.login_form))))));
        appCompatButton.perform(scrollTo(), click());

        String random = UUID.randomUUID().toString();
        random = random.substring(0,3);
        random = "mike" + random;
        random = random + "@email.com";

        ViewInteraction appCompatAutoCompleteTextView = onView(
                withId(R.id.emailText));
        appCompatAutoCompleteTextView.perform(scrollTo(), replaceText(random), closeSoftKeyboard());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.passwordText));
        appCompatEditText.perform(scrollTo(), replaceText("123456"), closeSoftKeyboard());

        ViewInteraction appCompatButton1 = onView(
                allOf(withId(R.id.signUpButton), withText("Sign Up"),isDisplayed()));
        appCompatButton1.perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatAutoCompleteTextView1 = onView(
                withId(R.id.profileName));
        appCompatAutoCompleteTextView1.perform(scrollTo(), replaceText("Me"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(
                withId(R.id.sexText));
        appCompatAutoCompleteTextView2.perform(scrollTo(), replaceText("Male"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView3 = onView(
                withId(R.id.ageText));
        appCompatAutoCompleteTextView3.perform(scrollTo(), replaceText("20"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView4 = onView(
                withId(R.id.heightText));
        appCompatAutoCompleteTextView4.perform(scrollTo(), replaceText("5' 10''"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView5 = onView(
                withId(R.id.weightText));
        appCompatAutoCompleteTextView5.perform(scrollTo(), replaceText("140lbs"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView6 = onView(
                withId(R.id.workoutText));
        appCompatAutoCompleteTextView6.perform(scrollTo(), replaceText("Running"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.finishedButton), withText("All Done!"),isDisplayed()));
        appCompatButton2.perform(click());
    }


    @Test
    public void signUpScenario3() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.sign_up_button), withText("Sign Up"),
                        withParent(allOf(withId(R.id.email_login_form),
                                withParent(withId(R.id.login_form))))));
        appCompatButton.perform(scrollTo(), click());

        String random = UUID.randomUUID().toString();
        random = random.substring(0,3);
        random = "mike" + random;
        random = random + "@email.com";

        ViewInteraction appCompatAutoCompleteTextView = onView(
                withId(R.id.emailText));
        appCompatAutoCompleteTextView.perform(scrollTo(), replaceText(random), closeSoftKeyboard());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.passwordText));
        appCompatEditText.perform(scrollTo(), replaceText("123456"), closeSoftKeyboard());

        ViewInteraction appCompatButton1 = onView(
                allOf(withId(R.id.signUpButton), withText("Sign Up"),isDisplayed()));
        appCompatButton1.perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatAutoCompleteTextView1 = onView(
                withId(R.id.profileName));
        appCompatAutoCompleteTextView1.perform(scrollTo(), replaceText("Me"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(
                withId(R.id.sexText));
        appCompatAutoCompleteTextView2.perform(scrollTo(), replaceText("Male"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView3 = onView(
                withId(R.id.ageText));
        appCompatAutoCompleteTextView3.perform(scrollTo(), replaceText("20"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView4 = onView(
                withId(R.id.heightText));
        appCompatAutoCompleteTextView4.perform(scrollTo(), replaceText("5' 10''"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView5 = onView(
                withId(R.id.weightText));
        appCompatAutoCompleteTextView5.perform(scrollTo(), replaceText("140lbs"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView6 = onView(
                withId(R.id.workoutText));
        appCompatAutoCompleteTextView6.perform(scrollTo(), replaceText("Running"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.finishedButton), withText("All Done!"),isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.MyProfile), withText("My Profile"),isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.EditInfo), withText("Edit Info"),isDisplayed()));
        appCompatButton4.perform(click());

        appCompatAutoCompleteTextView1.perform(scrollTo(), replaceText("Changed"), closeSoftKeyboard());
        appCompatAutoCompleteTextView2.perform(scrollTo(), replaceText("Female"), closeSoftKeyboard());
        appCompatAutoCompleteTextView3.perform(scrollTo(), replaceText("30"), closeSoftKeyboard());
        appCompatAutoCompleteTextView4.perform(scrollTo(), replaceText("4' 11''"), closeSoftKeyboard());
        appCompatAutoCompleteTextView5.perform(scrollTo(), replaceText("200lbs"), closeSoftKeyboard());
        appCompatAutoCompleteTextView6.perform(scrollTo(), replaceText("Curls"), closeSoftKeyboard());

        appCompatButton2.perform(click());

        appCompatButton3.perform(click());

    }
 }
