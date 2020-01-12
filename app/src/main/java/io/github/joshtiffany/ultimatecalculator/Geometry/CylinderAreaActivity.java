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

public class CylinderAreaActivity extends AppCompatActivity {
    private Button calc;
    private EditText radiusTV, heightTV;
    private TextView result;
    private Double radius, height, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder_area);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusTV.getText().length() > 0 && heightTV.getText().length() > 0) {
                    radius = Double.parseDouble(radiusTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());

                    area = 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.cylArCalcBTN);
        radiusTV = findViewById(R.id.cylRadiusArInputTV);
        heightTV = findViewById(R.id.cylHeightArInputTV);
        result = findViewById(R.id.cylArOutputTV);

        adView = findViewById(R.id.adViewcyv);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
