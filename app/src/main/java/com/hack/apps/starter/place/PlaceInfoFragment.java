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
import com.hack.apps.starter.dashboard.MapFragment;


public class PlaceInfoFragment extends Fragment {

    private static final String TAG = PlaceInfoFragment.class.getCanonicalName();

    private String[] tabs = new String[]{"Деталі", "Розташування", "Коментарі"};

    Bundle bundle;

    public static Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_place_info, container, false);

        this.bundle = getArguments();
        toolbar = view.findViewById(R.id.toolbar);

        ViewPager mViewPager;

        setHasOptionsMenu(true);
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Заклад");
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

            Fragment fragment = null;

            if (i == 0)
                fragment = new PlaceDetailsFragment();
            else if (i == 1) {
                fragment = new MapFragment();
            } else if (i == 2) fragment = new FragmentComments();

            fragment.setArguments(bundle);

            return fragment;
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