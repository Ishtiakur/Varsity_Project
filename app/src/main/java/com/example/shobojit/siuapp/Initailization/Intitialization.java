package com.example.shobojit.siuapp.Initailization;

import android.app.Application;
import android.content.Intent;

import com.example.shobojit.siuapp.OneSignalActivity.ImageActivity;
import com.example.shobojit.siuapp.OneSignalActivity.TextActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.crashlytics.android.Crashlytics;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import io.fabric.sdk.android.Fabric;

/**
 * Created by SHOBOJIT on 12/13/2016.
 */

public class Intitialization extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        Fresco.initialize(this);

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new ShuvojitHandler())
                /*.autoPromptLocation(true)*/
                .init();

}

private class ShuvojitHandler implements OneSignal.NotificationOpenedHandler{

    @Override
    public void notificationOpened(OSNotificationOpenResult result) {
        JSONObject data = result.notification.payload.additionalData;
        String value = "info";
        String Image = "img";



            if (data.has(value)) {
                try {
                    Intent intent = new Intent(getApplicationContext(), TextActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("info", data.getString(value));
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if (data.has(Image)) {
                try {
                    Intent intent2 = new Intent(getApplicationContext(), ImageActivity.class);
                    intent2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent2.putExtra("img", data.getString(Image));
                    startActivity(intent2);
                } catch (JSONException e) {
                    e.printStackTrace();

            }
        }
    }
}
}
