package com.fabiosilvateck69.track;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainTabLayout extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tab;
    ViewPager pager;
    PagerAdaptor pagerAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Status, Track");

        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("Imagens"));
        tab.addTab(tab.newTab().setText("videos"));
        tab.addTab(tab.newTab().setText("Outros apps"));

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdaptor = new PagerAdaptor(getApplicationContext(), getSupportFragmentManager(), tab.getTabCount());
        pager.setAdapter(pagerAdaptor);
        pager.setOffscreenPageLimit(pagerAdaptor.getCount() > 1 ? pagerAdaptor.getCount() - 1 : 1);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
