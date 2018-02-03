package me.paixao.intro;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void clickingFoot_shouldStartMainActivityFootFragment() {

        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.bt_foot).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        expectedIntent.putExtra("to", "foot");
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getExtras().toString().trim(), actual.getExtras().toString().trim());
    }


}