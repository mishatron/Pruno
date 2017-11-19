package com.hack.apps.starter.onboarding.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.apps.starter.R;
import com.hack.apps.starter.callback.OnboardingSecondCallback;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProfileEditSecondFrament extends Fragment {
    public static String TAG = "ProfileEditSecondFrament";
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_second_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
