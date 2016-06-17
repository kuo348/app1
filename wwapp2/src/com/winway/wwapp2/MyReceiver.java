package com.winway.wwapp2;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

public class MyReceiver extends ParsePushBroadcastReceiver {
	 private static final String TAG = "MyCustomReceiver";
    @Override
    protected Notification getNotification(Context context, Intent intent) {
        final Notification notification = super.getNotification(context, intent);
 // TODO Update this notification here          
        return notification;
    }

    @Override
    protected void onPushOpen(Context context, Intent intent) {
 //TODO For app specific implementation comment the following line calling super version of this method  
       // super.onPushOpen(context, intent);
    	 //TODO Add App Specific implementation below
    	 try {
             String action = intent.getAction();
             String channel = intent.getExtras().getString("com.parse.Channel");
             JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
             Log.d(TAG, "got action " + action + " on channel " + channel + " with:");
            /* Iterator itr = json.keys();
             while (itr.hasNext()) {
                 String key = (String) itr.next();
                 Log.d(TAG, "..." + key + " => " + json.getString(key));
             }*/
             //if(json.getString("action").toString().equals("alert"))
            // {
            	Intent lastIntent = new Intent(context,MainActivity.class);
                 lastIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 lastIntent.putExtras(intent.getExtras());               
                 context.startActivity(lastIntent);            	 
            // }
         } catch (JSONException e) {
             Log.d(TAG, "JSONException: " + e.getMessage());
         }
    	
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }
    /*
    @Override
    public void onReceive(Context context, Intent intent) {
     try {
    
      JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
    
      String notificationTitle = context.getString(R.string.app_name);
      String notificationContent = json.getString("alert").toString();
   
      Intent resultIntent = new Intent(context, MainActivity.class);
      resultIntent.putExtra("alert", notificationContent);
    
      TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
      stackBuilder.addParentStack(MainActivity.class);
      stackBuilder.addNextIntent(resultIntent);
      PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    
      NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
    
      //show custom notification
      NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
       .setSmallIcon(R.drawable.app_icon)
       .setContentTitle(notificationTitle)
       .setContentText(notificationContent)
       .setStyle(inboxStyle)
       .setContentIntent(resultPendingIntent)
       .setAutoCancel(true);
    
      int mNotificationId = 001;
      NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
      mNotifyMgr.notify(mNotificationId, builder.build());
    
     } catch (JSONException e) {
      Log.d(TAG, e.getMessage());
     }
    }
    */
}