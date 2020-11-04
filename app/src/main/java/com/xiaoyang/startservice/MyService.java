package com.xiaoyang.startservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Notification notification = new Notification.Builder(this, NotificationChannel.DEFAULT_CHANNEL_ID)
                    .setContentTitle("Service Demo")
                    .setContentText("Service running")
                    .setContentIntent(pendingIntent)
                    .setTicker("Ticker")
                    .build();
            startForeground(1, notification);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        stopForeground(true);
        Intent intent = new Intent("com.xiaoyang.service.destroy");
        sendBroadcast(intent);
        super.onDestroy();
    }
}