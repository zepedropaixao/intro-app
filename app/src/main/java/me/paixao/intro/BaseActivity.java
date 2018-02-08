package me.paixao.intro;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import me.paixao.intro.fragments.BaseFragment;

public class BaseActivity<T extends BaseFragment> extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public FragmentManager mFM;
    public ActionBar actionBar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_brain) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("to", "brain");
            startActivity(intent);
        } else if (id == R.id.nav_ear) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("to", "ear");
            startActivity(intent);
        } else if (id == R.id.nav_heart) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("to", "heart");
            startActivity(intent);
        } else if (id == R.id.nav_hand) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("to", "hand");
            startActivity(intent);
        } else if (id == R.id.nav_foot) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("to", "foot");
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            sendMail();
        } else if (id == R.id.nav_call) {
            callMe();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"zepedropaixao@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "I'd like to know you Pedro");
        i.putExtra(Intent.EXTRA_TEXT, "Hello,\n" +
                "I would like to know more about you Pedro.");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void callMe() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "000000000"));
        startActivity(intent);
    }

    public void changeFragment(T newFragment) {

        try {

            if (mFM == null)
                mFM = getSupportFragmentManager();

            // Create fragment and give it an argument specifying the article it should show
            //ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            newFragment.setArguments(args);

            View f = findViewById(R.id.fragment_container);

            if (f == null) {
                super.setContentView(R.layout.activity_main);

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);

                actionBar = getSupportActionBar();
                if (actionBar != null && !(this instanceof MainActivity))
                    actionBar.setDisplayHomeAsUpEnabled(true);
            }

            FragmentTransaction transaction = mFM.beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);

            // Commit the transaction
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }


    @Override
    public void setContentView(int content) {
        super.setContentView(content);
        if (mFM == null)
            mFM = getSupportFragmentManager();

        T f = (T) mFM.findFragmentById(R.id.fragment_container);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (f == null || toolbar == null) {
            super.setContentView(R.layout.activity_main);
            f = (T) mFM.findFragmentById(R.id.fragment_container);
        }


        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);

        //getSupportActionBar().setHomeAsUpIndicator(upArrow);

        if (actionBar != null && content != R.layout.content_main) {
            actionBar.setHomeAsUpIndicator(upArrow);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (actionBar != null && content == R.layout.content_main)
            actionBar.setDisplayHomeAsUpEnabled(false);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Base Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
