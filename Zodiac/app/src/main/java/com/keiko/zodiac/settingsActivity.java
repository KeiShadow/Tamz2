package com.keiko.zodiac;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class settingsActivity extends AppCompatActivity {

    ImageView myImage01;
    ImageView myImage02;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

       myImage01 = (ImageView)findViewById(R.id.w01);
        myImage02 = (ImageView)findViewById(R.id.w02);

       myImage01.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.putExtra("wallpaper","w01");
               setResult(333,intent);
               finish();
           }
       });
        myImage01.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        myImage01.getDrawable().setColorFilter(Color.argb(125, 168, 255, 255), PorterDuff.Mode.DST_IN);
                        break;

                    }
                    case MotionEvent.ACTION_UP:{
                        myImage01.getDrawable().clearColorFilter();
                        break;
                    }
                }
                return false;
            }
        });
        myImage02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("wallpaper","w02");
                setResult(333,intent);
                finish();
            }
        });
        myImage02.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        myImage02.getDrawable().setColorFilter(Color.argb(125, 168, 255, 255), PorterDuff.Mode.DST_IN);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        myImage02.getDrawable().clearColorFilter();
                        break;
                    }
                }
                return false;
            }
        });
    }


}
