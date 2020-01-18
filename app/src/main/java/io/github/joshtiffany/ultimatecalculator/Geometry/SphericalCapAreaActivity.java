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

public class SphericalCapAreaActivity extends AppCompatActivity {
    private Button calc;
    private EditText radiusTV, heightTV;
    private TextView result;
    private Double radius, height, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spherical_cap_area);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusTV.getText().length() > 0 && heightTV.getText().length() > 0) {
                    radius = Double.parseDouble(radiusTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());

                    area = 2 * Math.PI * radius * height + Math.PI * Math.pow(radius, 2);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.spcArCalcBTN);
        radiusTV = findViewById(R.id.spcArRadiusInputTV);
        heightTV = findViewById(R.id.spcArHeightInputTV);
        result = findViewById(R.id.spcArOutputTV);

        adView = findViewById(R.id.adViewvspc);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
