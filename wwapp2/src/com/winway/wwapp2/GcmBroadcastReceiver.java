package com.winway.wwapp2;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
 
/**
 * 接收來自GCM的訊息
 * 
 * @author magiclen
 * 
 */public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
 
        public static final int NOTIFICATION_ID = 0;
 
        @Override
        public void onReceive(Context context, Intent intent) {
                Bundle extras = intent.getExtras();
                GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
                String messageType = gcm.getMessageType(intent);
                if (!extras.isEmpty()) {
                        if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
                                        .equals(messageType)) {
                                Log.i(getClass() + " GCM ERROR", extras.toString());
                        } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
                                        .equals(messageType)) {
                                Log.i(getClass() + " GCM DELETE", extras.toString());
                        } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
                                        .equals(messageType)) {
                                Log.i(getClass() + " GCM MESSAGE", extras.toString());
                                Intent i = new Intent(context, MainActivity.class);
                                i.setAction("android.intent.action.MAIN");
                                i.addCategory("android.intent.category.LAUNCHER");
                              //點選後自動移除該通知
                                //notification.flags = Notification.FLAG_AUTO_CANCEL;PendingIntent.FLAG_CANCEL_CURRENT
                                MagicLenGCM.sendLocalNotification(context, NOTIFICATION_ID,
                                                R.drawable.ic_launcher, "GCM 通知", extras
                                                                .getString("message"), "magiclen.org", true,
                                                PendingIntent.getActivity(context, 0, i,
                                                		PendingIntent.FLAG_CANCEL_CURRENT));
                        }
                }
                setResultCode(Activity.RESULT_OK);
        }
 
}
