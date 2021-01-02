package com.shourov.mycgpa.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent oi = new Intent(getApplicationContext() , MainActivity.class);
                    startActivity(oi);
                    finish();

            }
        },0) ;

    }
}
