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
    private int gender = 0;
    private String name = "";
    private float weight = 0;
    private float height = 0;
    private final int REQUEST_IMAGE_GALLERY = 1;

    private OnboardingSecondCallback callback;

//    @BindView(R.id.profile_view)
//    RelativeLayout profileView;
//
//    @BindView(R.id.profile_image_view)
//    CircleImageView profileImage;
//
//    @BindView(R.id.camera_image)
//    ImageView cameraImage;
//
//    @BindView(R.id.button_male)
//    Button buttonMale;
//
//    @BindView(R.id.button_female)
//    Button buttonFemale;
//
//    @BindView(R.id.user_name)
//    EditText userNameEdit;
//
//    @BindView(R.id.weight)
//    EditText weightEdit;
//
//    @BindView(R.id.height)
//    EditText heightEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_second_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

//        callback = (OnboardingSecondCallback) getActivity();

        return view;
    }

//    @OnClick(R.id.button_male)
//    public void clickMale(View view) {
//        Log.e(TAG, "clicked male");
//        buttonMale.setBackgroundResource(R.drawable.gender_button_background_selected);
//        buttonFemale.setBackgroundResource(R.drawable.gender_button_background_not_selected);
//        gender = 0;
//    }
//
//    @OnClick(R.id.button_male)
//    public void clickFemale(View view) {
//        Log.e(TAG, "clicked female");
//        buttonMale.setBackgroundResource(R.drawable.gender_button_background_not_selected);
//        buttonFemale.setBackgroundResource(R.drawable.gender_button_background_selected);
//        gender = 1;
//    }
//
//    @OnTextChanged(value = R.id.user_name, callback = OnTextChanged.Callback.TEXT_CHANGED)
//    public void onUserNameChanged(CharSequence charSequence, int i, int i1, int i2) {
//        Log.i(TAG, "userName onTextChanged=" + charSequence);
//        if (charSequence.length() > 0)
//            name = String.valueOf(charSequence);
//    }
//
//    @OnTextChanged(value = R.id.weight, callback = OnTextChanged.Callback.TEXT_CHANGED)
//    public void onWeightChanged(CharSequence charSequence, int i, int i1, int i2) {
//        Log.i(TAG, "weight onTextChanged=" + charSequence);
//        if (charSequence.length() > 0)
//            weight = (Float.parseFloat(String.valueOf(charSequence)));
//    }
//
//    @OnTextChanged(value = R.id.height, callback = OnTextChanged.Callback.TEXT_CHANGED)
//    public void onHeightChanged(CharSequence charSequence, int i, int i1, int i2) {
//        Log.i(TAG, "height onTextChanged=" + charSequence);
//        if (charSequence.length() > 0)
//            height = (Float.parseFloat(String.valueOf(charSequence)));
//    }

//    public void updateModel() {
//        callback.onUserDataReceived(name, gender, weight, height);
//    }
//
//    @OnClick(R.id.profile_view)
//    public void choosePicture(View view) {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Зображення"), REQUEST_IMAGE_GALLERY);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.i(TAG, "onActivityResult");
//        if (requestCode == REQUEST_IMAGE_GALLERY) {
//            if (data != null) {
//                try {
//                    profileImage.setImageBitmap(MediaStore.Images.Media.getBitmap(
//                            getActivity().getContentResolver(), data.getData()));
//                    cameraImage.setVisibility(View.GONE);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
