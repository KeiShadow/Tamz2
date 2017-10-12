package com.keiko.zodiac;

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

    ImageView myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

       myImage = (ImageView)findViewById(R.id.w01);
        myImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        myImage.getDrawable().setColorFilter(Color.argb(125,168,255,255), PorterDuff.Mode.DST_IN);
                        break;

                    }

                    case MotionEvent.ACTION_UP:{
                        myImage.getDrawable().clearColorFilter();
                        Intent intent = new Intent();
                        intent.putExtra("wallpaper","w01");
                        setResult(333,intent);
                        finish();
                        break;

                    }


                }


                return false;
            }
        });
    }


}
