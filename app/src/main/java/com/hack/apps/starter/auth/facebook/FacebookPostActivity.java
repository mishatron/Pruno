package com.hack.apps.starter.auth.facebook;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.login.LoginManager;
import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.hack.apps.starter.R;

import java.io.IOException;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FacebookPostActivity extends AppCompatActivity {
    public static String TAG = "FacebookPostActivity";

    private final int REQUEST_IMAGE_GALLERY = 2;
    private Bitmap bitmap;
    private String filePath;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.gallery)
    Button gallery;

    @BindView(R.id.share)
    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_post);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.share)
    public void share(View view) {
        postToFacebook(bitmap);
    }

    public void postToFacebook(Bitmap bitmap) {

//        LoginManager loginManager = LoginManager.getInstance();

        if (bitmap != null) {
            Log.e("Share", "ok");
            SharePhoto photo = new SharePhoto.Builder()
                    .setBitmap(bitmap)
                    .setCaption("Caption this")
                    .build();
            SharePhotoContent content = new SharePhotoContent.Builder()
                    .addPhoto(photo)
                    .build();

            ShareApi.share(content, null);
        }
    }

    @OnClick(R.id.gallery)
    public void openGallery(View view) {
        Log.e("gallery", "ok");
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Зображення"), REQUEST_IMAGE_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_GALLERY) {
            if (data != null) {
                try {
                    Uri selectedImageUri = data.getData();
                    filePath = getRealPathFromURI(selectedImageUri);
                    Log.e(TAG, "path=" + filePath);
                    bitmap = MediaStore.Images.Media.getBitmap(FacebookPostActivity.this.getContentResolver(), data.getData());
                    image.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getRealPathFromURI(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

}
