package com.shourov.mycgpa.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shourov.mycgpa.Adapter.ScheduleAdapter;
import com.shourov.mycgpa.BroadCast.AlarmReceiver;
import com.shourov.mycgpa.ModelClass.Schedule_Model;
import com.shourov.mycgpa.Database.DataBaseHelper;
import com.shourov.mycgpa.Database.DatabaseSource_Schedule;
import com.shourov.mycgpa.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Schedule_Record extends AppCompatActivity {
    FloatingActionButton fab;
    ArrayList<Schedule_Model> arrayList;
    SwipeMenuListView listView;
    AlarmManager alarmManager;
    SharedPreferences sharedPreferences;
    int requestCode = 1;
    TextView txt;
    Intent intent;
    PendingIntent pendingIntent;
    Toolbar toolbar;
    int pos;
    int e=0;
    boolean finish,p, failedToLoad,network_status;
    ScheduleAdapter scheduleAdapter;
    private InterstitialAd mInterstitialAd;
    DatabaseSource_Schedule databaseSource_schedule;
    String weekDay;
    String activityFrom="";
    ConnectivityManager connectivityManager;
    ConnectivityManager.NetworkCallback networkCallback;
    public static final String TAG_ACTIVITY_FROM = "WhichActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule__record);
        fab=findViewById(R.id.fab_view);
        listView=findViewById(R.id.list_view);
        txt=findViewById(R.id.empty_view_text);

        toolbar =findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Schedules");

        SimpleDateFormat dayFormat = new SimpleDateFormat("E", Locale.getDefault());

        Calendar calen = Calendar.getInstance();
        weekDay = dayFormat.format(calen.getTime());

        String g = new SimpleDateFormat("dd MMM yy").format(Calendar.getInstance().getTime());
        getSupportActionBar().setSubtitle(weekDay+","+g);

        loadAdd();


        databaseSource_schedule=new DatabaseSource_Schedule(this);

        arrayList=databaseSource_schedule.getAllSchedule();

        callBack();

        if(arrayList.size()==0){

            txt.setVisibility(View.VISIBLE);

        }else {

            txt.setVisibility(View.GONE);
        }

        if(!isNetworkConnected()){

            if(arrayList.size() > 0){

                new MaterialAlertDialogBuilder(Schedule_Record.this,R.style.AlertDialogTheme)
                        .setTitle("Internet Connection")
                        .setMessage("Please connect with Internet. Internet connection required to load Schedule.")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })


                        .setCancelable(true)
                        .show();
            }

        }

        if (getIntent().getExtras() != null) {
             activityFrom =  getIntent().getStringExtra(TAG_ACTIVITY_FROM);

            finish=true;

                 if(activityFrom.equals("notify")){

                    int v=getIntent().getIntExtra("idn",1);

                    ArrayList<Schedule_Model> arr=databaseSource_schedule.getAllSchedule();

                    for(int j=0;j<arr.size();j++){     //the schedule position got from click on the notification
                        if(arr.get(j).getId()==v){
                            pos=j;
                            break;
                        }
                    }

                 //   loadAll();

                    listView.clearFocus();
                    listView.requestFocusFromTouch();
                    listView.setSelection(pos);


                }

                if (activityFrom.equals("update")) {

                    int i = getIntent().getIntExtra("idu",1);

                    ArrayList<Schedule_Model> arr = databaseSource_schedule.getAllSchedule();

                    for (int j = 0; j < arr.size(); j++) {
                        if (arr.get(j).getId() == i) {
                            pos = j;
                            break;
                        }
                    }
                    loadAll();

                    listView.clearFocus();
                    listView.requestFocusFromTouch();
                    listView.setSelection(pos);

                }

                if (activityFrom.equals("add")) {


                    ArrayList<Schedule_Model> arr2 = databaseSource_schedule.getAllSchedule();



                    for (int j = 0; j < arr2.size(); j++) {
                        if (arr2.get(j).getId() == databaseSource_schedule.getLastRow1()) {
                            pos = j;
                            break;
                        }
                    }

                    loadAll();

                    listView.clearFocus();
                    listView.requestFocusFromTouch();
                    listView.setSelection(pos);

                }
        }




        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            private int mLastFirstVisibleItem;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState){

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if(mLastFirstVisibleItem < firstVisibleItem){
                    // Scrolling down
                    fab.setVisibility(View.GONE);
                }
                if(mLastFirstVisibleItem > firstVisibleItem){
                    // scrolling up

                    fab.setVisibility(View.VISIBLE);
                }
                mLastFirstVisibleItem = firstVisibleItem;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent1 = new Intent(Schedule_Record.this, Schedule_List_Detail.class);

                    intent1.putExtra("tit", arrayList.get(position).getTitle());
                    intent1.putExtra("des", arrayList.get(position).getDes());
                    intent1.putExtra("date", arrayList.get(position).getDate());
                    intent1.putExtra("notify", arrayList.get(position).getIs_notification());
                    intent1.putExtra("mili", arrayList.get(position).getMili_sort());
                    intent1.putExtra("img", arrayList.get(position).getImageUri());
                    intent1.putExtra("before", arrayList.get(position).getBefore_day());
                    intent1.putExtra("me", arrayList.get(position).getBefore_day());
                    startActivity(intent1);


            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p=true;
             startActivity(new Intent(getApplicationContext(),Schedule_Add.class));
            }
        });

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(R.color.list);
                // set item width
                openItem.setWidth(200);
                // set item title
                openItem.setIcon(R.drawable.ic_autorenew_black_24dp);
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(R.color.list);
                // set item width
                deleteItem.setWidth(200);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete_black_24dp);

                deleteItem.setTitleSize(18);
                // set item title font color
                deleteItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                final Schedule_Model model = arrayList.get(position);
                switch (index) {
                    case 0:

                        fab.setVisibility(View.VISIBLE);
                        e=position;
                        p=true;

                        if (model != null) {

                            Intent intent = new Intent(getApplicationContext(), Schedule_Add.class);

                            intent.putExtra("key", "update");
                            intent.putExtra("title", model.getTitle());
                            intent.putExtra("des", model.getDes());
                            intent.putExtra("date", model.getDate());
                            intent.putExtra("check", model.getIs_notification());
                            intent.putExtra("id", model.getId());
                            intent.putExtra("image", model.getImageUri());
                            intent.putExtra("before", model.getBefore_day());

                            startActivity(intent);

                        }

                        break;
                    case 1:

                        boolean status = databaseSource_schedule.deleteSchedule(model);

                        if (status) {

                            Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                            loadAll();

                            fab.setVisibility(View.VISIBLE);
                            listView.clearFocus();
                            listView.requestFocusFromTouch();
                            listView.setSelection(position-1);

                        } else {

                            Toast.makeText(getApplicationContext(), "Not Deleted!! Try Again", Toast.LENGTH_LONG).show();
                        }

                        clear();

                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }

    private void callBack() {



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {


            connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkRequest request = new NetworkRequest.Builder().build();
            networkCallback = new ConnectivityManager.NetworkCallback() {


                @Override
                public void onLost(@NonNull Network network) {
                    network_status = false;

                }

                @Override
                public void onAvailable(@NonNull Network network) {

                    network_status = true;

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            if (failedToLoad) {
                                loadAdd();

                            }
                            // Stuff that updates the UI


                            loadAll();
                            if(!activityFrom.equals("")){

                                listView.clearFocus();
                                listView.requestFocusFromTouch();
                                listView.setSelection(pos);
                                activityFrom="";
                            }


                        }
                    });

                }

            };
            connectivityManager.registerNetworkCallback(request, networkCallback);

        }else {

            if(isNetworkConnected()){

                network_status=true;

                loadAll();

            }else {


                network_status=false;
            }
        }
    }


    void loadAll(){


        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {

            network_status= isNetworkConnected();

            if (failedToLoad) {
                loadAdd();

            }
        }

       arrayList=databaseSource_schedule.getAllSchedule();
       scheduleAdapter = new ScheduleAdapter(this,arrayList);

       listView.setAdapter(scheduleAdapter);

       if(arrayList.size() > 0) {

           txt.setVisibility(View.GONE);

           if (network_status) {

               listView.setVisibility(View.VISIBLE);

           }else {

               listView.setVisibility(View.GONE);
               Toast toast = Toast.makeText(getApplicationContext(),"Connect with Internet to load schedule", Toast.LENGTH_LONG);
               toast.setGravity(Gravity.CENTER, 0, 0);
               toast.show();
           }
       }else {

               txt.setVisibility(View.VISIBLE);
           }

       }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.demo, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setIconifiedByDefault(true);
        searchView.setQueryHint("Enter Title name");
        int searchImgId = getResources().getIdentifier("android:id/search_button", null, null);
        ImageView v =  searchView.findViewById(searchImgId);
        v.setImageResource(R.drawable.ic_search_black_24dp);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){

                    try{
                        fab.setVisibility(View.VISIBLE);
                        scheduleAdapter.filter("");
                        listView.clearTextFilter();

                    }catch (Exception e){

                    }
                }
                else {

                    try{
                        scheduleAdapter.filter(s);
                        fab.setVisibility(View.GONE);

                    }catch (Exception e){

                    }

                }
                return true;
            }

        });

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        call();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.action_refresh){
            //do your functionality here

            fab.setVisibility(View.VISIBLE);

           loadAll();

           return true;
        }
        else if (id==R.id.action_delete1){
            //do your functionality here

            new AlertDialog.Builder(Schedule_Record.this)

                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            fab.setVisibility(View.VISIBLE);
                            DataBaseHelper dataBaseHelper = new DataBaseHelper(Schedule_Record.this);

                            SQLiteDatabase sqLiteDatabase=dataBaseHelper.getWritableDatabase();

                            sqLiteDatabase.delete(DataBaseHelper.COURSE_TABLE1, null, null);

                            clear();
                            loadAll();

                        }
                    })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })

                    .setTitle("Delete All")
                    .setMessage("Are you sure to delete all the records?")
                    .setCancelable(false)
                    .show();

            return true;
        }


      else if (id==R.id.action_delete2) {


            new AlertDialog.Builder(Schedule_Record.this)

                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            fab.setVisibility(View.VISIBLE);
                            ArrayList<Schedule_Model> arr =databaseSource_schedule.getAllSchedule();

                            for (int k=0;k<arr.size();k++){

                                Schedule_Model sm=arr.get(k);
                                String m=sm.getMili_sort();
                                String n=sm.getDate();


                                if(Long.parseLong(m)<System.currentTimeMillis() && !n.equals("Select Date and Time")){

                                    databaseSource_schedule.deleteSchedule(sm);

                                }
                            }

                            loadAll();

                        }
                    })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })


                    .setTitle("Delete (expired)")
                    .setMessage("Are you sure to delete all expired records?")
                    .setCancelable(false)
                    .show();


             return true;
        }

       else if (id==R.id.action_delete3) {

            new AlertDialog.Builder(Schedule_Record.this)

                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            fab.setVisibility(View.VISIBLE);
                            ArrayList<Schedule_Model> arrl =databaseSource_schedule.getAllSchedule();


                            for (int k=0;k<arrl.size();k++){


                                Schedule_Model sm=arrl.get(k);
                                String m1=sm.getDate();

                                if(m1.equals("Select Date and Time")){

                                    databaseSource_schedule.deleteSchedule(sm);

                                }
                            }

                            loadAll();
                        }
                    })


                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })


                    .setTitle("Delete (without date)")
                    .setMessage("Are you sure to delete all without date records?")
                    .setCancelable(false)
                    .show();


        }else if(id==android.R.id.home){
           onBackPressed();

        }


        return super.onOptionsItemSelected(item);
    }


    void setAlarm2() {

        sharedPreferences = getSharedPreferences("alarm_code", MODE_PRIVATE);
        requestCode = sharedPreferences.getInt("requestCodeValue", 1);

        long l;
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(getApplicationContext(), AlarmReceiver.class);

        try {

            for (int j = 1; j < requestCode; j++) {

                //   intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), j, intent, 0);


                if(pendingIntent!=null){

                    alarmManager.cancel(pendingIntent);
                }


            }


        }catch (Exception e){

        }


        ArrayList<Schedule_Model> list;
        list = databaseSource_schedule.getAllSchedule();

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

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                intent.putExtra("titleName", model.getTitle());
                intent.putExtra("beforeDate", model.getBefore_day());
                intent.putExtra("id", model.getId());
                intent.putExtra("flag", "true");
                intent.putExtra("code", requestCode);
                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()-l, pendingIntent);
                else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()-l, pendingIntent);
                else
                    alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()-l, pendingIntent);
                // alarmManager.cancel(pendingIntent);
                requestCode++;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("requestCodeValue", requestCode);
                editor.apply();

            }else {


            }

        }

    }

    @Override
    protected void onStop() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
        super.onStop();
    }


    public void clear() {

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {

                setAlarm2();

            }
        });
        myThread.start();

    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }



    private void loadAdd() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1366242071094783/6971469399");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdLoaded() {


                failedToLoad=false;
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                failedToLoad=true;

                super.onAdFailedToLoad(loadAdError);

            }

        });

    }

    @Override
    public void onBackPressed() {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                     Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

        if (isTaskRoot()) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();

        }else {
            super.onBackPressed();
        }
    }

   void call() {

       if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
           connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
           final NetworkRequest request = new NetworkRequest.Builder().build();
           networkCallback = new ConnectivityManager.NetworkCallback() {

               @Override
               public void onLost(@NonNull Network network) {
                   network_status = false;

               }

               @Override
               public void onAvailable(@NonNull Network network) {

                   network_status = true;

               }

           };
           connectivityManager.registerNetworkCallback(request, networkCallback);

       }else {

           network_status= isNetworkConnected();
       }

   }

}

