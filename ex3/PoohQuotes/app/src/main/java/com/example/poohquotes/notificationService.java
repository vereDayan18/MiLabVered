package com.example.poohquotes;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


/**
 * The notificationService sets an intent service to send notifications
 * every five minutes, that will be sent even when the app is closed
 *
 * the private variable TIME_INTERVAL is set to 5 minutes
 *
 * Uses AlarmManager to track the time
 */

public class notificationService extends IntentService {
    private static final String ACTION_NOTIFICATION = "com.example.poohquotes.action.NOTIFICATION";
    private static final long TIME_INTERVAL = AlarmManager.INTERVAL_FIFTEEN_MINUTES/3;


    public notificationService() {
        super("notificationService");
    }

    public static void startAction(Context context){
        Intent intent = new Intent(context, notificationService.class);
        intent.setAction(ACTION_NOTIFICATION);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_NOTIFICATION.equals(action)) {
                handleNotification();
            } else {
                throw new RuntimeException("unknown action");
            }
        }
    }

    private void handleNotification(){
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent in = new Intent(getApplicationContext(), broadcastReceiver.class);
        in.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, in, 0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), TIME_INTERVAL, pendingIntent);

    }
}
