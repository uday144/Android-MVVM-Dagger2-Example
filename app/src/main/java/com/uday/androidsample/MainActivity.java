package com.uday.androidsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.uday.androidsample.fragments.FactsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Uday on 27/06/2018.
 */

public class MainActivity extends AppCompatActivity implements FactsFragment.CountrySelectedListener {
    private ActionBar actionBar;
    @BindView(R.id.fragmentContainer)
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        actionBar = getSupportActionBar();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = new FactsFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }

    }

    public void onCountrySelected(String title) {
        actionBar.setTitle(title);
    }


}
