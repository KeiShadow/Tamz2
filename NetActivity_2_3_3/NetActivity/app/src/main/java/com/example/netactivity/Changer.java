package com.example.netactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Changer extends Activity {
    TextView txtkod;
    TextView txtzeme;
    TextView txtmena;
    EditText editCz;
    EditText editSome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changer);

        Bundle extras = getIntent().getExtras();

        String zeme = extras.getString("Zeme");
        String kod = extras.getString("Kod");
        String mena = extras.getString("Mena");

        txtkod = (TextView)findViewById(R.id.txtKod);
        txtzeme = (TextView)findViewById(R.id.txtZeme);
        txtmena= (TextView)findViewById(R.id.txtKurz);
        editCz = (EditText) findViewById(R.id.setCountCz);
        editSome = (EditText)findViewById(R.id.setCountAny);

        txtzeme.setText(zeme);
        txtkod.setText(kod);
        txtmena.setText(mena);

        if(editSome.getText().toString()==""){
            editSome.setText(chance(Integer.parseInt(txtkod.getText().toString()) ));
        }
    }

    public int chance(int kod){
        int result;
        result = Integer.parseInt(editCz.getText().toString())*Integer.parseInt(txtkod.getText().toString());
        return result;
    }

}
