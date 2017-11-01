package com.example.netactivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Changer extends Activity {
    TextView txtkod;
    TextView txtzeme;
    TextView txtmena;
    EditText editCz;
    EditText editSome;
    CheckBox checkBox;
    Double kurz;
    String pom,zeme,kod,mena;
    boolean focused = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changer);

        Bundle extras = getIntent().getExtras();

        zeme = extras.getString("Zeme");
        kod = extras.getString("Kod");
        mena = extras.getString("Mena");

        txtkod = (TextView) findViewById(R.id.txtKod);
        txtzeme = (TextView) findViewById(R.id.txtZeme);
        txtmena = (TextView) findViewById(R.id.txtKurz);
        editCz = (EditText) findViewById(R.id.setCountCz);
        editSome = (EditText) findViewById(R.id.setCountAny);

        txtzeme.setText(zeme);
        txtkod.setText(kod);
        txtmena.setText(mena);

        pom = mena.replace(",", ".");
        kurz = Double.valueOf(pom.toString());
        Log.i("Kurz:", pom.toString());

        checkBox = (CheckBox)findViewById(R.id.checkBox);

        /*checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){

                    editCz.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            editSome.setText(Double.toString(changeTo(kurz)));
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                        }
                    });

                }else {
                    editCz.setText("");
                    editSome.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                            editCz.setText(Double.toString(changeToCzk(kurz)).toString());


                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                        }
                    });
                }
            }
        });*/
        editCz.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                        editCz.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                editSome.setText(Double.toString(changeTo(kurz)));
                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                focused = false;
                            }
                        });
                }else{

                        editCz.setText("");
                        editSome.setText("");
                        editSome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) {

                                editSome.addTextChangedListener(new TextWatcher() {
                                    @Override
                                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                    }

                                    @Override
                                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                                        editCz.setText(Double.toString(changeToCzk(kurz)).toString());


                                    }

                                    @Override
                                    public void afterTextChanged(Editable s) {
                                    }
                                });
                            }
                        });
                    }

                }

        });


        /*editCz.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    editSome.setText(Double.toString(changeTo(kurz)).toString());


            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        editSome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    editCz.setText(Double.toString(changeToCzk(kurz)).toString());


            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        */



    }



    public double changeTo(double kurz){
        double result=0;
            if(!editCz.getText().toString().equals("0") && !editCz.getText().toString().isEmpty()){

                DecimalFormat twoDform = new DecimalFormat("#.###");
                result = Double.valueOf((twoDform.format(Double.parseDouble(editCz.getText().toString())/kurz))) ;
                return result;
            }else{
                Toast.makeText(this,"Nulou nelze delit",Toast.LENGTH_LONG);
            }
        return 0;
    }

    public double changeToCzk(double kurz){
        double result=0;

            DecimalFormat twoDform = new DecimalFormat("#.###");
            result = Double.valueOf((twoDform.format(Double.parseDouble(editSome.getText().toString())*kurz))) ;
        return result;
    }

}
