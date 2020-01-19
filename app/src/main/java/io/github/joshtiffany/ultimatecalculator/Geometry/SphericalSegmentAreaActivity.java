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

public class SphericalSegmentAreaActivity extends AppCompatActivity {

    private Button calc;
    private EditText baseTV, topTV, heightTV;
    private TextView result;
    private Double base, height, top, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spherical_segment_area);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseTV.getText().length() > 0 && heightTV.getText().length() > 0 && topTV.getText().length() > 0) {
                    base = Double.parseDouble(baseTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());
                    top = Double.parseDouble(topTV.getText().toString());

                    area = Math.PI * (2 * top * height + Math.pow(base, 2) + Math.pow(top, 2));
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.spsArCalcBTN);
        baseTV = findViewById(R.id.spsArBaseInputTV);
        heightTV = findViewById(R.id.spsArHeightInputTV);
        topTV = findViewById(R.id.spsArTopInputTV);
        result = findViewById(R.id.spsArOutputTV);

        adView = findViewById(R.id.adViewsphs);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
