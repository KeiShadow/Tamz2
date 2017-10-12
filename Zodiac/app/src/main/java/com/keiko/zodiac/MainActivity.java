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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {

    public DatePicker datePicker;
    public ImageView imageZodiac;
    public TextView zodiac;
    SharedPreferences mySharedPrefer;

    int publicMonth;


    static String[] zodiacNames ={"Kozoroh","Vodnář","Ryby","Beran", "Býk","Blíženci","Rak","Lev","Panna","Váhy","Štír","Střelec"};
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
        imageZodiac.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
               switch(motionEvent.getAction()){
                   case MotionEvent.ACTION_DOWN:{
                       Toast.makeText(getApplicationContext(),"Action Up",Toast.LENGTH_LONG).show();
                       imageZodiac.getDrawable().setColorFilter(Color.argb(125,168,255,255), PorterDuff.Mode.DST_IN);
                       break;

                   }

                   case MotionEvent.ACTION_UP:{
                       Toast.makeText(getApplicationContext(),"Action Down",Toast.LENGTH_LONG).show();
                       imageZodiac.getDrawable().clearColorFilter();
                       break;

                   }


               }


                return true;
            }
        });


    }


    @Override
    public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        publicMonth=monthOfYear;
        zodiac.setText(zodiacNames[publicMonth]);
        imageZodiac.setImageResource(zodiacImage[publicMonth]);

       // mySharedPrefer =

    }

    public void myClick(View v){
        Toast.makeText(getApplicationContext(),"myClick",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ZodiacActivity.class);
        intent.putExtra("Zodiac",zodiacNames[publicMonth]);
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
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
