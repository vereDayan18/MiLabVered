package com.example.poohquotes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

/**
 * The broadcastReceiver sets the notification channel and manager
 * and sets the notification that will be sent
 *
 * uses getQuote() from Quotes class to set a different quote in each notification
 *
 */


public class broadcastReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "NotifyChannel";
    private static int notificationID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager nm = (NotificationManager)context.getSystemService(NotificationManager.class);
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT));
        }

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.star_big_on)
                .setContentTitle("Your quote:")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(Quotes.getQuote()))
                .build();

        notificationManager.notify(notificationID, notification);
        Log.i("Info log","Notification sent" );

        notificationID++;
    }
}
