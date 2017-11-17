package com.hack.apps.starter.auth.vk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKImageParameters;
import com.vk.sdk.api.photo.VKUploadImage;

import org.json.JSONObject;

import static com.hack.apps.starter.auth.vk.VkAuth.getUserId;
import static com.hack.apps.starter.auth.vk.VkAuth.login;


public class VkPost {

    private String TAG = "VkPose";


    void toMyWall(Activity activity, final Bitmap photo, final String message) {
        VKRequest request = VKApi.uploadWallPhotoRequest
                (new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), getUserId(), 0);

        request.executeWithListener(new VKRequest.VKRequestListener() {

            @Override
            public void onComplete(VKResponse response) {
                // recycle bitmap
                VKApiPhoto photoModel = ((VKPhotoArray) response.parsedModel).get(0);
                vkMakePost(new VKAttachments(photoModel), message, getUserId());
            }

            @Override
            public void onError(VKError error) {
                login(activity);
            }
        });
    }

    private void vkMakePost(VKAttachments att, String msg, final int ownerId) {
        VKParameters parameters = new VKParameters();
        parameters.put(VKApiConst.OWNER_ID, String.valueOf(ownerId));
        parameters.put(VKApiConst.ATTACHMENTS, att);
        parameters.put(VKApiConst.MESSAGE, msg);
        parameters.put(VKApiConst.FROM_GROUP, 0);
        VKRequest post = VKApi.wall().post(parameters);
        post.setModelClass(VKWallPostResult.class);
        post.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                // post was added
                Log.e(TAG, "Пост зроблено успішно");
                JSONObject res = response.json;
                Log.e("RESPONSE", res.toString());
            }

            @Override
            public void onError(VKError error) {
                Log.e(TAG, "Помилка створення посту");
            }
        });
    }


}
