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

public class SphereAreaActivty extends AppCompatActivity {
    private Button calc;
    private EditText radiusTV;
    private TextView result;
    private Double radius, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere_area_activty);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusTV.getText().length() > 0) {
                    radius = Double.parseDouble(radiusTV.getText().toString());

                    area = 4 * Math.PI * Math.pow(radius, 2);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.sphArCalcBTN);
        radiusTV = findViewById(R.id.sphArRadiusInputTV);
        result = findViewById(R.id.sphArOutputTV);

        adView = findViewById(R.id.adViewvsp);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
