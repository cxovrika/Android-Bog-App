package ge.aleksandre.tskhovrebovi.finalproject.activities;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Date;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.adapters.ViewPagerAdapter;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.login.LoginResult;

public class HomeActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LoginResult lr = getIntent().getParcelableExtra("loginResult");

        tabLayout = findViewById(R.id.tab_layout);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public static void setCorrespondingBackground(View view) {
        int hours = new Date().getHours();
        if (hours >= 18) {
            if (view instanceof ImageView) {
                ((ImageView)view).setImageResource(R.drawable.ic_evening_bg);
            } else {
                view.setBackgroundResource(R.drawable.ic_evening_bg);
            }
        } else {
            if (view instanceof ImageView) {
                ((ImageView)view).setImageResource(R.drawable.ic_day_bg);
            }
            else {
                view.setBackgroundResource(R.drawable.ic_day_bg);
            }
        }
    }
}
