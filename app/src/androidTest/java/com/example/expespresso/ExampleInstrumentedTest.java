package com.example.expespresso;

import android.content.Context;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
  //  Context appContext;
    //doit être public
    @Rule
    public ActivityScenarioRule<MainActivity> myTestActivity =
            new ActivityScenarioRule<>(MainActivity.class) ;
    @Before
    public void setup()
    {
     //   appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    }
   @Test
    public void useAppContext() {
        // Context of the app under test.
     //   assertEquals("com.example.expespresso", appContext.getPackageName());

        onView(ViewMatchers.withId(R.id.edit_login))
                .perform(ViewActions.replaceText("test")
                ,ViewActions.closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.edit_password))
                .perform(ViewActions.replaceText("1273")
                        ,ViewActions.closeSoftKeyboard());
       onView(ViewMatchers.withId(R.id.btn_go))
               .perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.txt_result)).check(ViewAssertions.matches(ViewMatchers.withText("KO")));
        onView(ViewMatchers.withId(R.id.edit_password))
                .perform(ViewActions.replaceText("123"), ViewActions.closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.btn_go)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.txt_result)).check(ViewAssertions.matches(ViewMatchers.withText("OK")));

    }

}