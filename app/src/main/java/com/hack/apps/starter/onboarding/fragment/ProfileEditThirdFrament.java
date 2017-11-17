package com.hack.apps.starter.onboarding.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.hack.apps.starter.R;
import com.hack.apps.starter.callback.OnboardingThirdCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProfileEditThirdFrament extends Fragment {
    public static String TAG = "ProfileFrament";
    private Unbinder unbinder;
    private OnboardingThirdCallback callback;

    private int maxAlcoholCount = 0;
    private int alcoholLevelCount = 0;
    private int healthLevel = 0;

//    @BindView(R.id.health_seekbar)
//    DiscreteSeekBar healthSeekBar;
//
//    @BindView(R.id.title_health)
//    TextView healthTitle;
//
//    @BindView(R.id.alcohol_seekbar)
//    DiscreteSeekBar alcoholSeekBar;
//
//    @BindView(R.id.title_alcohol)
//    TextView alcoholTitle;
//
//    @BindView(R.id.alcohol_level_seekbar)
//    DiscreteSeekBar alcoholLevelSeekBar;

//    @BindView(R.id.title_alcohol_level)
//    TextView alcoholLevelTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_third_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

//        callback = (OnboardingThirdCallback) getActivity();

//        initHealthSeekBar();
//        initAlcoholSeekBar();
//        initAlcoholLevelSeekBar();

        return view;
    }

//    private void initHealthSeekBar() {
//        healthTitle.setText(getString(R.string.health) + " " + healthSeekBar.getProgress() + " %");
//        healthLevel = healthSeekBar.getProgress();
//        healthSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
//            @Override
//            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
//                healthTitle.setText(getString(R.string.health) + " " + value + " %");
//                if (value != 0)
//                    healthLevel = value;
//            }
//
//            @Override
//            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
//            }
//        });
//    }
//
//    private void initAlcoholSeekBar() {
//        Log.e(TAG, "seekbsr alcohol progr=" + alcoholSeekBar.getProgress());
//        alcoholTitle.setText(getString(R.string.alcohol) + " " + alcoholSeekBar.getProgress() + " "+getString(R.string.ml));
//        maxAlcoholCount = alcoholSeekBar.getProgress();
//        alcoholSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
//            @Override
//            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
//                alcoholTitle.setText(getString(R.string.alcohol) + " " + value + " "+getString(R.string.ml));
//                if (value != 0)
//                    maxAlcoholCount = value;
//            }
//
//            @Override
//            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
//            }
//        });
//    }
//
//    private void initAlcoholLevelSeekBar() {
//        Log.e(TAG, "seekbsr alcohol progr=" + alcoholSeekBar.getProgress());
//        alcoholTitle.setText(getString(R.string.alcoho_level) + " " + alcoholSeekBar.getProgress() + " %");
//        alcoholLevelCount = alcoholLevelSeekBar.getProgress();
//        alcoholLevelSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
//            @Override
//            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
//                alcoholTitle.setText(getString(R.string.alcohol) + " " + value + " %");
//                if (value != 0)
//                    maxAlcoholCount = value;
//            }
//
//            @Override
//            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
//            }
//        });
//    }
//
//    public void updateModel() {
//        Log.i("ProfileEditThirdFrament", "updateModel");
//        callback.onSeekbarDataReceived(healthLevel, maxAlcoholCount, alcoholLevelCount);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
