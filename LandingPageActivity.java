package com.example.dell.intents;

/**
 * Created by DELL on 6/24/2016.
 */


        import android.app.Activity;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.design.widget.TabLayout;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.GestureDetector;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.TextView;
        import android.widget.Toast;

public class LandingPageActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener,GestureDetector.OnGestureListener {
    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

        tv1=(TextView)findViewById(R.id.a);
        tv2=(TextView)findViewById(R.id.m);
        tv3=(TextView)findViewById(R.id.b);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
         com.example.dell.intents.PagerAdapter adapter = new PagerAdapter
                (this, getSupportFragmentManager(), 4);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
       tabLayout.setTabTextColors(getResources().getColor(android.R.color.white), getResources().getColor(android.R.color.black));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action1) {
            AlertDialog.Builder a= new AlertDialog.Builder(this);
            a.setMessage("Search an item");
            a.show();
            return true;
        }

        if (id == R.id.action2) {
            AlertDialog.Builder a= new AlertDialog.Builder(this);
            a.setMessage("sort items");
            a.show();
            return true;
        }

        if (id == R.id.action3) {
            AlertDialog.Builder a= new AlertDialog.Builder(this);
            a.setMessage("snip out");
            a.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;

    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        AlertDialog.Builder a = new AlertDialog.Builder(getBaseContext());
        a.setMessage("Date\nTime\nVenue\nAttendees\nDescription");
        a.show();
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
