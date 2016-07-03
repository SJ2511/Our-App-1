package com.example.dell.intents;

/**
 * Created by DELL on 6/24/2016.
 */


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class LandingPageActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener ,GestureDetector.OnGestureListener {
    TextView tv1, tv2, tv3;
    private static final int PICK_IMAGE_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void Add1(View v){
        Intent intent1= new Intent("com.example.dell.intents.NEWevent");
        startActivity(intent1);
    }

    public void Add2(View v){
        Intent intent2= new Intent("com.example.dell.intents.NEWmenuentry");
        startActivity(intent2);
    }

    public void Add3(View v){
        Intent intent3= new Intent("com.example.dell.intents.NEWtimetableentry");
        startActivity(intent3);
    }

    public void Add4(View v){
        Intent intent4= new Intent("com.example.dell.intents.NEWnotes");
        startActivity(intent4);
    }

    public void Weekly1(View v){
        Intent intent1= new Intent("com.example.dell.intents.NEWevent");
        startActivity(intent1);
    }

    public void Weekly2(View v){
        Intent intent2= new Intent("com.example.dell.intents.NEWmenuentry");
        startActivity(intent2);
    }

    public void Weekly3(View v){
        Intent intent3= new Intent("com.example.dell.intents.NEWtimetableentry");
        startActivity(intent3);
    }

    public void Monthly1(View v){
        Intent intent1= new Intent("com.example.dell.intents.NEWevent");
        startActivity(intent1);
    }

    public void Monthly2(View v){
        Intent intent2= new Intent("com.example.dell.intents.NEWmenuentry");
        startActivity(intent2);
    }

    public void Monthly3(View v){
        Intent intent3= new Intent("com.example.dell.intents.NEWtimetableentry");
        startActivity(intent3);
    }

    public void Addpic(View v){
        Intent intent = new Intent();
// Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Camera(View v){
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }


    public void Email(View v){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getBaseContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
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




