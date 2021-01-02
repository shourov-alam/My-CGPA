package com.shourov.mycgpa.Notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.shourov.mycgpa.R;
import com.shourov.mycgpa.Activity.Schedule_Record;
import java.util.UUID;

public class NotificationHelper extends ContextWrapper {
    // random value used int h=0;
    public static final String channelId = "channel ID";
    public static final String channelName = "channel Name";
    private NotificationManager manager;
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createChannels();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannels() {

        NotificationChannel channel1 = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(R.color.colorPrimary);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(channel1);

    }

    public NotificationManager getManager(){

        if (manager == null){

            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        }

        return manager;
    }


    public NotificationCompat.Builder getChannelNotification(String title, String message,int id){

        Intent intent =new Intent(this, Schedule_Record.class);
        intent.putExtra(Schedule_Record.TAG_ACTIVITY_FROM,"notify");
        intent.putExtra("idn",id);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent1=PendingIntent.getActivity(this, UUID.randomUUID().hashCode(),intent,PendingIntent.FLAG_CANCEL_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(), channelId)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                //.setContentIntent(activityIntent)
                .setSmallIcon(R.drawable.ic_event_note_black_24dp)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                //.setTicker("u")`
                .setVibrate(new long[] {3000, 3000,3000,3000,3000})
                .setAutoCancel(true)
                .setContentIntent(pendingIntent1);
                //.setAutoCancel(true)
                //.setOngoing(false);

    }
}
