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

public class SphereVolumeActivity extends AppCompatActivity {

    private Button calc;
    private EditText radiusTV;
    private TextView result;
    private Double radius, volume;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere_volume);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusTV.getText().length() > 0) {
                    radius = Double.parseDouble(radiusTV.getText().toString());

                    volume = 4.0 / 3.0 * Math.PI * radius * radius * radius;
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.sphCalcBTN);
        radiusTV = findViewById(R.id.sphRadiusInputTV);
        result = findViewById(R.id.sphAreaOutputTV);

        adView = findViewById(R.id.adViewvsp);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }


}
