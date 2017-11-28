package com.keiko.zodiac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {

    public DatePicker datePicker;
    public ImageView imageZodiac;
    public TextView zodiac;
    SharedPreferences mySharedPrefer;

    int publicMonth;


    static String[] zodiacNames ={"Kozoroh","Vodnar","Ryby","Beran", "Byk","Blizenci","Rak","Lev","Panna","Vahy","Stir","Strelec"};
    static int[] zodiacImage ={
            R.drawable.kozoroh01,
            R.drawable.vodnar02,
            R.drawable.ryby03,
            R.drawable.beran04,
            R.drawable.byk05,
            R.drawable.blizenci06,
            R.drawable.rak07,
            R.drawable.lev08,
            R.drawable.panna09,
            R.drawable.vahy10,
            R.drawable.stir11,
            R.drawable.strelec12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySharedPrefer = getSharedPreferences("myPrefer",MODE_PRIVATE);
        publicMonth = mySharedPrefer.getInt("month",1);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        datePicker = (DatePicker)findViewById(R.id.datePicker);
        datePicker.init(2017, 0, 1, this);
        zodiac = (TextView)findViewById(R.id.zodiacText);
        zodiac.setText(zodiacNames[0] );

        imageZodiac = (ImageView)findViewById(R.id.imageView);

    }


    @Override
    public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
      if((dayOfMonth >=21 && monthOfYear ==0) || (dayOfMonth<=20 && monthOfYear == 1)){
          zodiac.setText(zodiacNames[1]);
          imageZodiac.setImageResource(R.drawable.vodnar02);
          publicMonth = 1;
      }else if((dayOfMonth >=21 && monthOfYear ==1) || (dayOfMonth<=20 && monthOfYear == 2)){
          zodiac.setText(zodiacNames[2]);
          imageZodiac.setImageResource(R.drawable.ryby03);
          publicMonth = 2;
      }else if((dayOfMonth >=21 && monthOfYear ==2) || (dayOfMonth<=20 && monthOfYear == 3)){
          zodiac.setText(zodiacNames[3]);
          imageZodiac.setImageResource(R.drawable.beran04);
          publicMonth = 3;
      }else if((dayOfMonth >=21 && monthOfYear ==3) || (dayOfMonth<=21 && monthOfYear == 4)){
          zodiac.setText(zodiacNames[4]);
          imageZodiac.setImageResource(R.drawable.byk05);
          publicMonth = 4;
      }else if((dayOfMonth >=22 && monthOfYear ==4) || (dayOfMonth<=21 && monthOfYear == 5)){
          zodiac.setText(zodiacNames[5]);
          imageZodiac.setImageResource(R.drawable.blizenci06);
          publicMonth = 5;
      }else if((dayOfMonth >=22 && monthOfYear ==5) || (dayOfMonth<=22 && monthOfYear == 6)){
          zodiac.setText(zodiacNames[6]);
          imageZodiac.setImageResource(R.drawable.rak07);
          publicMonth = 6;
      }else if((dayOfMonth >=23 && monthOfYear ==6) || (dayOfMonth<=22 && monthOfYear == 7)){
          zodiac.setText(zodiacNames[7]);
          imageZodiac.setImageResource(R.drawable.lev08);
          publicMonth = 7;
      }else if((dayOfMonth >=23 && monthOfYear ==7) || (dayOfMonth<=22 && monthOfYear == 8)) {
          zodiac.setText(zodiacNames[8]);
          imageZodiac.setImageResource(R.drawable.panna09);
          publicMonth = 8;
      }else if((dayOfMonth >=23 && monthOfYear ==8) || (dayOfMonth<=23 && monthOfYear == 9)){
          zodiac.setText(zodiacNames[9]);
          imageZodiac.setImageResource(R.drawable.vahy10);
          publicMonth = 9;
      }else if((dayOfMonth >=24 && monthOfYear ==9) || (dayOfMonth<=22 && monthOfYear == 10)){
          zodiac.setText(zodiacNames[10]);
          imageZodiac.setImageResource(R.drawable.stir11);
          publicMonth = 10;
      }else if((dayOfMonth >=23 && monthOfYear ==10) || (dayOfMonth<=21 && monthOfYear == 11)){
          zodiac.setText(zodiacNames[11]);
          imageZodiac.setImageResource(R.drawable.strelec12);
          publicMonth = 11;
      }else if((dayOfMonth >=22 && monthOfYear ==11) || (dayOfMonth<=20 && monthOfYear == 0)){
          zodiac.setText(zodiacNames[0]);
          imageZodiac.setImageResource(R.drawable.kozoroh01);
          publicMonth = 0;
      }
    }

    public void myClick(View v){
        Toast.makeText(getApplicationContext(),"myClick",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ZodiacActivity.class);
        intent.putExtra("Name",zodiacNames[publicMonth]);
        startActivity(intent);
    }
    @Nullable
    @Override
    public android.app.ActionBar getActionBar() {
        return super.getActionBar();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id=item.getItemId();
        switch (id) {
            case R.id.About:
                Intent aboutIntent = new Intent(this,AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.settings:
                Intent settings = new Intent(this,settingsActivity.class);
                startActivityForResult(settings,333);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        try {
            if(requestCode==333){
                String message = data.getStringExtra("wallpaper");
                Toast.makeText(getApplicationContext(),"wallpaper"+message,Toast.LENGTH_SHORT);
                View vMain = (View)findViewById(R.id.actMain);

                if(message.equals("w01")){
                    vMain.setBackgroundResource(R.drawable.wall01);
                }else if(message.equals("w02")){
                    vMain.setBackgroundResource(R.drawable.wall02);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
