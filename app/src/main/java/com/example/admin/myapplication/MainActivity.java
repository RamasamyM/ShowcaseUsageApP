package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private ShowcaseView showcaseView;
    private int counter = 0;
    private FloatingActionButton floatingActionButton;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private static final String INTRO_CARD = "material_intro";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        Target viewTarget = new ViewTarget(R.id.fab, this);
        new ShowcaseView.Builder(this)
                .setTarget(viewTarget)
                .setContentTitle(R.string.title_single_shot)
                .setContentText(R.string.R_string_desc_single_shot).singleShot(42)
                .build();
        floatingActionButton.setOnClickListener(this);
        showIntro(floatingActionButton, INTRO_CARD, "This is MainFAB! Hello There. click me!");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showIntro(toolbar, INTRO_CARD, "This is ToolBar! Hello There. click me!t!");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      /*  initUI();
        showcaseUtils();*/

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_item1) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            startActivity(new Intent(getApplication(), SecondActivity.class));

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
   /* private void initUI() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    *//**
     * Showcase view
     *//*
    private void showcaseUtils() {
        showcaseView = new ShowcaseView.Builder(this).setTarget(new ViewTarget(navigationView))
                .setContentTitle("Title").setContentText("Description").setOnClickListener(this).build();
        showcaseView.setButtonText("okay");
    }

    @Override
    public void onClick(View v) {
        if (showcaseView != null) {
            showcaseView.hide();
        }
    }*/

    private void showIntro(FloatingActionButton view, String usageId, String text)
    {
        new MaterialIntroView.Builder(this)
                .enableDotAnimation(true)
                .setFocusGravity(FocusGravity.CENTER)
                .setFocusType(Focus.MINIMUM)
                .setDelayMillis(200)
                .enableFadeAnimation(true)
                .performClick(true)
                .setInfoText(text)
                .setTarget(view)
                .setUsageId(usageId) //THIS SHOULD BE UNIQUE ID
                .show();
    }
    private void showIntro(View view, String usageId, String text)
    {
        new MaterialIntroView.Builder(this)
                .enableDotAnimation(true)
                .setFocusGravity(FocusGravity.LEFT)
                .setFocusType(Focus.MINIMUM)
                .setDelayMillis(200)
                .enableFadeAnimation(true)
                .performClick(true)
                .setInfoText(text)
                .setTarget(view)
                .setUsageId(usageId) //THIS SHOULD BE UNIQUE ID
                .show();
    }
    @Override
    public void onClick(View v) {

    }
}
