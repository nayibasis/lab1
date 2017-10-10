package com.example.nayibasiselizalde.lab1;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.os.Bundle;
import java.util.ArrayList;
import android.support.design.widget.*;

/**
 * Created by Nayib and Lindsey on 9/28/17.
 */

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    Activity ctx;
  /*  final int request_image_capture = 1;
    // variable to check if password has been confirmed
    public static int check = 0;
    Bitmap bitmap;

    public static String shared_pref = "my_sharedpref";

    private PasswordDialog confirmationDialogBox;
    public static Editable pass;
    public static Button save;
    private ImageView imagebutton;
    public Button confirm;
    public Button back;
    public Button clear;
    public EditText handle;
    public EditText name;
    public EditText password;
*/
    private SlidingTabLayout slidingTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> fragments;
    private TabViewPagerAdapter mViewPagerAdapter;

    private boolean launchLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        /**if(Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        Intent intent = getIntent();
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("login")) {
            launchLogin = false;
        }
        /**
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        fragments = new ArrayList<Fragment>();
        //fragments.add(new FindFragment());
        fragments.add(new ChatFragment());

        //fragments.add(new MeetFragment());
        //fragments.add(new PartyFragment());

        mViewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager(),fragments);

        mViewPager.setAdapter(mViewPagerAdapter);

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(mViewPager);
        setContentView(R.layout.activity_main);

        ctx=this;
         */

        // initiate previously declared variables
/*        save = findViewById(R.id.save_button);
        confirm = findViewById(R.id.confirm_button);
        back = findViewById(R.id.backButton);
        clear = findViewById(R.id.clear);
        handle = findViewById(R.id.editText);
        name = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        imagebutton = findViewById(R.id.image_button);
*/
        // show image if there is a bitmap
        //if(bitmap != null)imagebutton.setImageBitmap(bitmap);

        // Set up tabs

/*        TabHost tabHost = (TabHost) findViewById(R.id.tab);
        tabHost.setup();
        TabHost.TabSpec ts = tabHost.newTabSpec("tag1");
        ts.setContent(R.id.tab1);
        ts.setIndicator("Tag");
        tabHost.addTab(ts);

        ts = tabHost.newTabSpec("tag 2");
        ts.setContent(R.id.tab2);
        ts.setIndicator("History");
        tabHost.addTab(ts);

        ts = tabHost.newTabSpec("tag 3");
        ts.setContent(R.id.tab3);
        ts.setIndicator("Score");
        tabHost.addTab(ts);

        ts = tabHost.newTabSpec("tag 4");
        ts.setContent(R.id.tab4);
        ts.setIndicator("Settings");
        tabHost.addTab(ts);
*/
    }

    @Override
    public void onStart() {
        super.onStart();
        if(launchLogin) {
            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
        }
    }


    public void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlayFragment(), "Play");
        adapter.addFragment(new HistoryFragment(), "History");
        adapter.addFragment(new ScoreFragment(), "Score");
        adapter.addFragment(new SettingsFragment(), "Settings");
        viewPager.setAdapter(adapter);
    }
}