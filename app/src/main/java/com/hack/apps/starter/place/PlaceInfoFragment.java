package com.hack.apps.starter.place;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.apps.starter.R;


public class PlaceInfoFragment extends Fragment {


    private String[] tabs = new String[]{"Деталі", "Розташування", "Коментарі"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_place_info, container, false);

        ViewPager mViewPager;

        setHasOptionsMenu(true);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("!@##RT$#@");
//        toolbar.inflateMenu(R.menu.schedule_week_menu);


        mViewPager = view.findViewById(R.id.container);
        mViewPager.setAdapter(new DemoCollectionPagerAdapter(getChildFragmentManager()));

        TabLayout tabLayout = view.findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    private class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

        DemoCollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) throws NullPointerException {

            if (i == 0)
                return new PlaceDetailsFragment();
            else if (i == 1) {
                // TODO
            } else if (i == 2) return new FragmentComments();

            return null;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) throws NullPointerException {
            return tabs[position];
        }
    }


}