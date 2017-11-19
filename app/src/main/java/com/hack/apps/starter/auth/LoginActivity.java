package com.hack.apps.starter.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hack.apps.starter.MainActivity;
import com.hack.apps.starter.R;
import com.hack.apps.starter.callback.LoginCallback;
import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.onboarding.OnboardingActivity;
import com.hack.apps.starter.profile.entity.User;
import com.hack.apps.starter.settings.CommonSettings;
import com.stfalcon.socialauthhelper.fb.FacebookClient;
import com.stfalcon.socialauthhelper.gplus.GooglePlusClient;
import com.stfalcon.socialauthhelper.gplus.model.GooglePlusProfile;
import com.stfalcon.socialauthhelper.vk.VkClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hack.apps.starter.db.DB.initDB;

public class LoginActivity extends AppCompatActivity implements LoginCallback {

    private static final String TAG = LoginActivity.class.getCanonicalName();

    private VkClient vkClient;

    private FacebookClient facebookClient;
    private GooglePlusClient googlePlusClient;
    @BindView(R.id.fb)
    ImageView facebook;

    @BindView(R.id.vk)
    ImageView vk;

    @BindView(R.id.gp)
    ImageView gp;

    @OnClick(R.id.vk)
    public void vkLogin(View view) {

        vkClient.getProfile(vkProfile -> {
            //after authorization successful you have access to user profile and Access Token


//                    vkProfile.getFirstName() + " " + vkProfile.getLastName(),
//                    vkProfile.getId(),
//                    vkClient.getAccessToken();

//                Picasso.with(MainActivity.this).load(vkProfile.getProfilePhoto()).into(ivVk);

            loginUser(vkProfile.getId(), vkProfile.getFirstName() + " " + vkProfile.getLastName(), vkClient.getAccessToken());

        });

    }
    @OnClick(R.id.gp)
    public void gpLogin(View view) {

        googlePlusClient.getProfile(new GooglePlusClient.GooglePlusResultCallback() {
            @Override
            public void onProfileLoaded(GooglePlusProfile googlePlusProfile) {
                loginUser(Long.parseLong(googlePlusProfile.getId()), googlePlusProfile.getName(), googlePlusProfile.getToken());
            }
        });

    }

    @OnClick(R.id.fb)
    public void facebookLogin(View view) {

        facebookClient.getProfile(facebookProfile -> {
            //after authorization successful you have access to user profile and Access Token

//                        facebookProfile.getName(),
//                        facebookProfile.getId(),
//                        facebookClient.getToken()));


            loginUser(facebookProfile.getId(), facebookProfile.getName(), facebookClient.getToken());


        });
    }

    private void loginUser(Long userId, String username, String token) {

        User user = UserDB.findById(userId);

        if (user == null) {

            User newUser = new User();
            newUser.setId(userId);
            newUser.setUsername(username);
            newUser.setToken(token);

            UserDB.save(newUser);

        }

        CommonSettings commonSettings = CommonSettingsDB.get();
        commonSettings.setUserLoggined(true);
        commonSettings.setUserId(userId);
        CommonSettingsDB.save(commonSettings);

        openMain();

    }


    @Override
    protected void onResume() {
        super.onResume();

        initDB(LoginActivity.this);

        if (CommonSettingsDB.get().isFirstUse())
            openOnboarding();

        if (CommonSettingsDB.get().isUserLoggined()) {
            openMain();
        }

    }

    private void openOnboarding() {
        startActivity(new Intent(LoginActivity.this, OnboardingActivity.class));
        finish();
    }

    private void openMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initDB(LoginActivity.this);


        vkClient = new VkClient(this, //activity or fragment
                getString(R.string.vk_redirect_uri), //vk application redirect uri
                getString(R.string.vk_client_id)); //vk application clientId


        facebookClient = new FacebookClient(this);

        googlePlusClient = new GooglePlusClient(this,
                getString(R.string.googleClientId));//Web client id

    }

    @Override
    public void onFacebookTokenReceived(String token) {
        saveToken(token);
        Log.e("OnTokenReceived", token);
    }


    private void saveToken(String token) {

        User user = UserDB.get();
        user.setToken(token);
        UserDB.save(user);

        Log.e(TAG, "saved token ok");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        vkClient.onActivityResult(requestCode, resultCode, data);

        facebookClient.onActivityResult(requestCode, resultCode, data);

        googlePlusClient.onActivityResult(requestCode, resultCode, data);

    }

}
