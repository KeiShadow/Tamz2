package com.keiko.zodiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ZodiacActivity extends AppCompatActivity {

    TextView zodiac;
    TextView description;
    String zodiacFromIntent;
    TextView fromto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);

        zodiac = (TextView)findViewById(R.id.zodiacText);
        Intent intent = getIntent();

        fromto=(TextView)findViewById(R.id.from_to_text);

        description = (TextView)findViewById(R.id.descText);

        zodiac.setText(intent.getStringExtra("Zodiac"));
        zodiacFromIntent = intent.getStringExtra("Zodiac");


        getDesc(zodiacFromIntent);




    }

    public void getDesc(String desc){
        switch (desc){
            case "Kozoroh":
                fromto.setText("22. 12. až 20. 1.");
                description.setText("Kozoroh je desáté astrologické znamení zvěrokruhu mající původ v souhvězdí Kozoroha. V astrologii je Kozoroh považován za negativní znamení. Je také považován za zemské znamení. Kozoroh je tradičně ovládán planetou Saturn.");
                break;
            case "Vodnář":
                fromto.setText("21. 1. až 20. 2.");
                description.setText("Vodnář je jedenácté astrologické znamení zvěrokruhu, mající původ v souhvězdí Vodnáře. V astrologii je Vodnář považován za pozitivní znamení. Je také považován za větrné znamení a je jedním ze čtyř pevných znamení.");
                break;
            case "Ryby":
                fromto.setText("21. 2. až 20. 3.");
                description.setText("Ryby jsou dvanácté, poslední znamení zvěrokruhu, spojené se souhvězdím Ryb. Ryby jsou vodní znamení a jedno ze čtyř nejproměnlivějších znamení.");
                break;
            case "Beran":
                fromto.setText("21. 3. až 20. 4.");
                description.setText("Beran neboli skopec je první astrologické znamení zvěrokruhu pojmenované po souhvězdí Berana. V astrologii je Beran považován za pozitivní znamení. Je také považován za ohnivé znamení a je jedním ze čtyř základních znamení.");
                break;
            case "Býk":
                fromto.setText("21. 4. až 21. 5.");
                description.setText("Býk je druhé astrologické znamení zvěrokruhu s původem v souhvězdí Býka. V astrologii je Býk považován za negativní znamení. Je také považován za zemské znamení a je jedním ze čtyř pevných znamení. Býk je tradičně ovládán planetou Venuše");
                break;
            case "Blíženci":
                fromto.setText("22. 5. až 21. 6.");
                description.setText("Blíženci jsou třetí astrologické znamení zvěrokruhu mající původ v souhvězdí Blíženců. V astrologii jsou Blíženci považováni za pozitivní znamení. Jsou také považováni za větrné znamení. Blíženci jsou tradičně ovládáni planetou Merkur.");
                break;
            case "Rak":
                fromto.setText("22. 6. až 22. 7.");
                description.setText("Rak je čtvrté astrologické znamení zvěrokruhu mající původ v souhvězdí Raka. V astrologii je Rak považován za negativní znamení. Je také považován za vodní znamení. Rak je tradičně ovládán Měsícem.");
                break;
            case "Lev":
                fromto.setText("23. 7. až 22. 8.");
                description.setText("Lev je páté astrologické znamení zvěrokruhu mající původ v souhvězdí Lva. V astrologii je Lev považován za pozitivní znamení. Je také považován za ohnivé znamení a je jedním ze čtyř pevných znamení. Lev je tradičně ovládán Sluncem.");
                break;
            case "Panna":
                fromto.setText("23. 8. až 22. 9.");
                description.setText("Panna je šesté znamení zvěrokruhu, spojené se souhvězdím Panny. Znamení Panny je v tradiční astrologii spojováno s planetou Merkur.");
                break;
            case "Váhy":
                fromto.setText("23. 9. až 23. 10.");
                description.setText("Váhy je sedmé astrologické znamení zvěrokruhu mající původ v souhvězdí Vah. V astrologii jsou Váhy považovány za pozitivní znamení. Jsou také považovány za větrné znamení. Váhy jsou tradičně ovládány planetou Venuše.");
                break;
            case "Štír":
                fromto.setText("24. 10. až 22. 11.");
                description.setText("Štír je osmé astrologické znamení zvěrokruhu mající původ v souhvězdí Štíra. V astrologii je Štír považován za negativní znamení. Je také považován za vodní znamení a je jedním ze čtyř pevných znamení.");
                break;
            case "Střelec":
                fromto.setText("23. 11. až 21. 12.");
                description.setText("Střelec je deváté astrologické znamení zvěrokruhu mající původ v souhvězdí Střelce. V astrologii je Střelec považován za pozitivní znamení. Je také považován za ohnivé znamení. Střelec je tradičně ovládán planetou Jupiter.");
                break;

        }

    }
}
