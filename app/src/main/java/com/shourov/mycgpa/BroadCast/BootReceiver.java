package com.shourov.mycgpa.BroadCast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import com.shourov.mycgpa.Database.DatabaseSource_Schedule;
import com.shourov.mycgpa.ModelClass.Schedule_Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;

public class BootReceiver extends BroadcastReceiver {

    AlarmManager alarmManager;
    SharedPreferences sharedPreferences;

    int requestCode = 1;
    DatabaseSource_Schedule databaseSource;

    Intent intent;
    PendingIntent pendingIntent ;

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

            Thread thread =new Thread(new Runnable() {
                @Override
                public void run() {


                    setAlarm2(context);

                }
            });
            thread.start();
        }

    }

    void setAlarm2(Context context) {

        sharedPreferences =context.getSharedPreferences("alarm_code", MODE_PRIVATE);
        requestCode = sharedPreferences.getInt("requestCodeValue", 1);
        databaseSource=new DatabaseSource_Schedule(context);

        long l;
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(context, AlarmReceiver.class);

        try {

            for (int j = 1; j < requestCode; j++) {

                //   intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(context, j, intent, 0);


                if(pendingIntent!=null){

                    alarmManager.cancel(pendingIntent);
                }

            }

        }catch (Exception e){

        }

        ArrayList<Schedule_Model> list;
        list = databaseSource.getAllSchedule();

        requestCode=1;
        for (int i = 0; i < list.size(); i++) {

            Schedule_Model model = list.get(i);
            String date = model.getDate();
            String checking=model.getIs_notification();
            String a=model.getBefore_day();
            if(date.equals("Select Date and Time")){
                continue;
            }
            if(a.equals("null") || a.equals("0")){
                l=0;
            }
            else {

                l=Integer.valueOf(a) * 86400000;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
            Calendar calendar = Calendar.getInstance();
            Calendar cal = Calendar.getInstance();

            try {
                calendar.setTime(sdf.parse(date));

                int dateForAlarm = calendar.get(Calendar.DAY_OF_MONTH);
                int monthForAlarm = calendar.get(Calendar.MONTH);
                int yearForAlarm = calendar.get(Calendar.YEAR);
                int hourForAlarm = calendar.get(Calendar.HOUR_OF_DAY);
                int minuteForAlarm = calendar.get(Calendar.MINUTE);
                int secondForAlarm = 0;

                cal.set(yearForAlarm, monthForAlarm, dateForAlarm, hourForAlarm, minuteForAlarm, secondForAlarm);


            } catch (ParseException e) {
                e.printStackTrace();
            }

            if ( cal.getTimeInMillis() - l >= Calendar.getInstance().getTimeInMillis() && checking.equals("true")) {

                alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(context, AlarmReceiver.class);
                intent.putExtra("titleName", model.getTitle());
                intent.putExtra("beforeDate", model.getBefore_day());
                intent.putExtra("id", model.getId());
                intent.putExtra("flag", "true");
                intent.putExtra("code", requestCode);

                pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()-l, pendingIntent);
                else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()-l, pendingIntent);
                else
                    alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()-l, pendingIntent);
                requestCode++;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("requestCodeValue", requestCode);
                editor.apply();

            }
        }
    }
}
