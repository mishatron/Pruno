package com.hack.apps.starter.auth.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;
import com.hack.apps.starter.R;
import com.hack.apps.starter.callback.LoginCallback;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.profile.entity.User;
import com.hack.apps.starter.settings.CommonSettings;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FacebookAuth extends AppCompatActivity implements LoginCallback {
    public static String TAG = "FacebookAuth";
    private CallbackManager callbackManager;
    private FacebookCallback<LoginResult> callback;

    private LoginManager loginManager;

    private CommonSettings settings;

    @BindView(R.id.facebook_login_button)
    LoginButton logInFacebokButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook);
        ButterKnife.bind(this);

        prepareAuth();
    }

    public void prepareAuth() {


        Log.e(TAG, "prepareAuth");
        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();
        loginManager.logInWithPublishPermissions(this, Collections.singletonList("publish_actions"));

        logInFacebokButton.setReadPermissions("email", "public_profile");

        callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("LoginFacebookToken", loginResult.getAccessToken().getToken());
                String token = loginResult.getAccessToken().getToken();
                onFacebookTokenReceived(token);
                Log.e(TAG, "facebook token onSuccess");

            }

            @Override
            public void onCancel() {
                Log.e(TAG, "canceled");
            }

            @Override
            public void onError(FacebookException e) {
                Log.e(TAG, "error");
            }
        };
    }

    private void openMain() {
        // TODO
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        logInFacebokButton.registerCallback(callbackManager, callback);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onFacebookTokenReceived(String token) {
        saveToken(token);
        Log.e("OnTokenReceived", token);
    }

    public void logOut() {
        FirebaseAuth.getInstance().signOut();

        LoginManager.getInstance().logOut();


        Log.e(TAG, "LOGOUT");
    }

    private void saveToken(String token) {

        User user = UserDB.get();
        user.setToken(token);
        UserDB.save(user);

        Log.e(TAG, "saved token ok");
    }

}