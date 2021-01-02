package com.shourov.mycgpa.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

import com.shourov.mycgpa.Notification.NotificationHelper;
public class AlarmReceiver extends BroadcastReceiver {

    int codes;
    NotificationHelper helper;
    @Override
    public void onReceive(Context context, Intent intent) {

       // sharedPreferences = context.getSharedPreferences("alarmRequestCode", MODE_PRIVATE);
       // code = sharedPreferences.getInt("requestCodeValue", 1);

        String titleName  = intent.getStringExtra("titleName");
        String beforeDate  = intent.getStringExtra("beforeDate");
        int id  = intent.getIntExtra("id",1);
        String flag = intent.getStringExtra("flag");
        codes=intent.getIntExtra("code",1);

        helper = new NotificationHelper(context);

        if ("true".equals(flag)){

            if(beforeDate!=null){
                if(Integer.parseInt(beforeDate) == 0){

                    showNotification(titleName,
                            "The Schedule Time is now. Tap for Details or swipe to skip.",id);
                }

               else if(Integer.parseInt(beforeDate) == 1){

                    showNotification(titleName,
                            "The Schedule Time is Tomorrow. Tap for Details or swipe to skip.",id);
                }
                else if(Integer.parseInt(beforeDate) == 2){

                    showNotification(titleName,
                            "The Schedule Time is 2 days later. Tap for Details or swipe to skip.",id);
                }

                else if(Integer.parseInt(beforeDate) == 3){

                    showNotification(titleName,
                            "The Schedule Time is 3 days later. Tap for Details or swipe to skip.",id);
                }

                else if(Integer.parseInt(beforeDate) == 4){

                    showNotification(titleName,
                            "The Schedule Time is 4 days later. Tap for Details or swipe to skip.",id);
                }

                else if(Integer.parseInt(beforeDate) == 5){

                    showNotification(titleName,
                            "The Schedule Time is 5 days later. Tap for Details or swipe to skip.",id);
                }

                else if(Integer.parseInt(beforeDate) == 7){

                    showNotification(titleName,
                            "The Schedule Time is 7 days later. Tap for Details or swipe to skip.",id);
                }

                else if(Integer.parseInt(beforeDate) == 14){

                    showNotification(titleName,
                            "The Schedule Time is two weeks later. Tap for Details or swipe to skip.",id);
                }

            }

        }

    }
    private void showNotification(String title, String message,int id) {


        NotificationCompat.Builder notification = helper.getChannelNotification(title,message,id);
        helper.getManager().notify(codes, notification.build());

      /*  code++;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("requestCodeValue", code);
        editor.apply(); */

    }

}

