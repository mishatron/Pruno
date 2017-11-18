package com.hack.apps.starter.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack.apps.starter.MainActivity;
import com.hack.apps.starter.R;
import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.onboarding.fragment.ProfileEditFirstFrament;
import com.hack.apps.starter.onboarding.fragment.ProfileEditSecondFrament;
import com.hack.apps.starter.onboarding.fragment.ProfileEditThirdFrament;
import com.hack.apps.starter.profile.entity.User;
import com.hack.apps.starter.settings.CommonSettings;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;

import static com.hack.apps.starter.db.DB.initDB;

public class OnboardingActivity extends AppCompatActivity {
    private static final String TAG = "CheckInActivity";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private List<ImageView> doneList = new ArrayList<>();
    private List<ImageView> list = new ArrayList<>();
    private int pos = 0;

    private ProfileEditFirstFrament firstFrgment = new ProfileEditFirstFrament();
    private ProfileEditSecondFrament secondFrgment = new ProfileEditSecondFrament();
    private ProfileEditThirdFrament thirdFrgment = new ProfileEditThirdFrament();


    @BindView(R.id.text_view_next_finish)
    TextView nextFinish;

    @BindView(R.id.container)
    ViewPager mViewPager;

    @BindView(R.id.first_indicator)
    ImageView firstIndicator;

    @BindView(R.id.second_indicator)
    ImageView secondIndicator;

    @BindView(R.id.third_indicator)
    ImageView thirdIndicator;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        ButterKnife.bind(this);

        initDB(OnboardingActivity.this);

        list.add(firstIndicator);
        list.add(secondIndicator);
        list.add(thirdIndicator);
        doneList.add(firstIndicator);

        updateIndicator(doneList);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);

    }

    @OnClick(R.id.text_view_next_finish)
    public void onButtonClick(View view) {
        switch (mViewPager.getCurrentItem()) {
            case 0: {
                mViewPager.setCurrentItem(getItem(+1), true);
                break;
            }
            case 1: {
                mViewPager.setCurrentItem(getItem(+1), true);
//                secondFrgment.updateModel();
                break;
            }
            case 2: {
//                thirdFrgment.updateModel();
                openMain();
                break;
            }
        }
    }

    private void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        CommonSettings commonSettings = CommonSettingsDB.get();
        commonSettings.performFirstUse();
        CommonSettingsDB.save(commonSettings);


        User user = new User();
        user.setUsername("user");
        user.setGender(0);
        UserDB.save(user);

        startActivity(intent);
    }


    @OnPageChange(value = R.id.container, callback = OnPageChange.Callback.PAGE_SELECTED)
    void onPageChange(int position) {
        if (position == 2) {
            nextFinish.setText(getString(R.string.onboarding_finish));
        } else {
            nextFinish.setText(getString(R.string.onboarding_next));
        }
        if (pos < position) {
            doneList.add(list.get(position));
        } else if (pos > position) {
            doneList.remove(list.get(pos));
        }
        updateIndicator(doneList);
        pos = position;
    }

    void updateIndicator(List<ImageView> list) {
        if (list.contains(firstIndicator)) {
            firstIndicator.setImageResource(R.drawable.circle_choosen);
        }
        if (list.contains(secondIndicator)) {
            secondIndicator.setImageResource(R.drawable.circle_choosen);
        }
        if (list.contains(thirdIndicator)) {
            thirdIndicator.setImageResource(R.drawable.circle_choosen);
        }

        if (!list.contains(firstIndicator)) {
            firstIndicator.setImageResource(R.drawable.circle);
        }
        if (!list.contains(secondIndicator)) {
            secondIndicator.setImageResource(R.drawable.circle);
        }
        if (!list.contains(thirdIndicator)) {
            thirdIndicator.setImageResource(R.drawable.circle);
        }
    }

    private int getItem(int i) {
        Log.i(TAG, " getCurrentItem() + i" + mViewPager.getCurrentItem() + i + "");
        return mViewPager.getCurrentItem() + i;
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
        int numb = 3;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position) {
                case 0: {
                    return firstFrgment;
                }
                case 1: {
                    return secondFrgment;
                }
                case 2: {
                    return thirdFrgment;

                }
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return numb;
        }
    }

}
