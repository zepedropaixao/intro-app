package me.paixao.intro;

import android.os.Bundle;
import android.support.design.widget.NavigationView;

import me.paixao.intro.fragments.BrainFragment;
import me.paixao.intro.fragments.EarFragment;
import me.paixao.intro.fragments.FootFragment;
import me.paixao.intro.fragments.HandFragment;
import me.paixao.intro.fragments.HeartFragment;
import me.paixao.intro.fragments.MainFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().hasExtra("to")) {
            String to = getIntent().getStringExtra("to");
            if (to.equals("brain")) {
                changeFragment(new BrainFragment());
            } else if (to.equals("ear")) {
                changeFragment(new EarFragment());
            } else if (to.equals("heart")) {
                changeFragment(new HeartFragment());
            } else if (to.equals("hand")) {
                changeFragment(new HandFragment());
            } else if (to.equals("foot")) {
                changeFragment(new FootFragment());
            }

        } else {
            changeFragment(new MainFragment());
        }
    }
}
