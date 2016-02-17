package com.example.alex.onlinebu;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.*;
import android.support.v7.*;

/**
 * Created by Alex on 17/02/2016.
 */
public class TimerNotif extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        NotificationManager notif;
        notif = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        Notification notification = new Notification(R.mipmap.livre, "ALERTE EMPRUNTS", System.currentTimeMillis());
        PendingIntent contentIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, PendingIntent.FLAG_ONE_SHOT);

        Notification.Builder builder = new Notification.Builder(context);
        builder
                .setSmallIcon(R.mipmap.livre)
                .setContentTitle("ALERTE EMPRUNTS")
                .setContentText("Surveiller Vos Emprunts !!!")
                .setAutoCancel(true);


        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());


    }



}
