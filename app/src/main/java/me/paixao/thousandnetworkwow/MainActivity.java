package me.paixao.thousandnetworkwow;

import android.os.Bundle;
import android.support.design.widget.NavigationView;

import me.paixao.thousandnetworkwow.fragments.BrainFragment;
import me.paixao.thousandnetworkwow.fragments.EarFragment;
import me.paixao.thousandnetworkwow.fragments.FootFragment;
import me.paixao.thousandnetworkwow.fragments.HandFragment;
import me.paixao.thousandnetworkwow.fragments.HeartFragment;
import me.paixao.thousandnetworkwow.fragments.MainFragment;

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
