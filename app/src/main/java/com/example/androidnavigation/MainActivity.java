package com.example.androidnavigation;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    TabLayout mTabLayout;

    int back = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabLayout = findViewById(R.id.tablayout);

        NavController navController = Navigation.findNavController(this, R.id.fragment);

        NavOptions navOptions = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(navController.getGraph().getStartDestination(), false)
                .build();



//        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
//        toggle.setDrawerIndicatorEnabled(true);
//        toggle.syncState();


            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {

                    Log.d(TAG, "onTabSelected: TAN : " + tab.getText());
                    switch (tab.getPosition())
                    {
                        case 0:
                            //
                            navController.navigate(R.id.fragmentOne, null, navOptions);
                            break;
                        case 1:
                            //
                            navController.navigate(R.id.fragmentTwo, null, navOptions);
                            break;
                        case 2:
                            //
                            navController.navigate(R.id.fragmentThree, null, navOptions);
                            break;
                    }

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
    public void onBackPressed() {



        if(back == 0)
        {
            mTabLayout.getTabAt(0).select();
            back++;
        }
        else
        {
            super.onBackPressed();
        }

    }
}