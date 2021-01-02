package com.shourov.mycgpa.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.shourov.mycgpa.R;

public class Schedule_List_Detail extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imageView;
    TextView titles,descri,before_date;
    String title, des, image1, before_check, mili, noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule__list__detail);
        titles=findViewById(R.id.s_title);
        descri=findViewById(R.id.descri);
        imageView = findViewById(R.id.imageView);
        before_date=findViewById(R.id.before);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null) {
            title = bundle1.getString("tit");
            des = bundle1.getString("des");
            image1 = bundle1.getString("img");
            before_check = bundle1.getString("me");
            mili = bundle1.getString("mili");
            noti = bundle1.getString("notify");

        }

       if(!image1.equals("null")) {

           Glide.with(getApplicationContext()).load(image1).into(imageView);

       }else {

           imageView.setVisibility(View.GONE);
       }

       if (!title.equals("")) {

            titles.setText("Title: "+title);
        } else {

            titles.setText("No Title Entered");
        }

        if (!des.equals("")) {

            descri.setText("Des: "+des);
        } else {

            descri.setText("No Description Entered");
        }


  if(!before_check.equals("null")) {

            long lo = 86400000 * Integer.valueOf(before_check);
            if (Long.parseLong(mili) - lo > System.currentTimeMillis()){

                if (Integer.valueOf(before_check) > 1) {

                    before_date.setText("You will get Notification before " + before_check + " days ago");
                }
                else if (Integer.valueOf(before_check) == 1) {

                    before_date.setText("You will get Notification before " + before_check + " day ago");

                }  else if (Integer.valueOf(before_check) == 0) {
                    before_date.setText("You will get Notification on Time");

                }

            }else {

                before_date.setText("Date Expired");
            }

        }else {

                before_date.setText("Notification was Unchecked");

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


}