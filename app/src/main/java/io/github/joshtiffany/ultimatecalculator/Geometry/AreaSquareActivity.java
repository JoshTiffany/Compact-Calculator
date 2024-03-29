package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaSquareActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV;
    private TextView result;
    private Double side, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_square);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());

                    area = side * side;
                    result.setText(String.valueOf(area));

                }
            }
        });


    }

    public void uisetup() {
        calc = findViewById(R.id.squCalcBTN);
        sideTV = findViewById(R.id.squSideInputTV);
        result = findViewById(R.id.squAreaOutputTV);

        adView = findViewById(R.id.adViewas);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
