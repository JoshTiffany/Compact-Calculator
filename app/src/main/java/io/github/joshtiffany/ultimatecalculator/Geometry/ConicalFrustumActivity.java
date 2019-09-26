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

public class ConicalFrustumActivity extends AppCompatActivity {

    private Button calc;
    private EditText baseTV, topTV, heightTV;
    private TextView result;
    private Double base, height, top, volume;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conical_frustum);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseTV.getText().length() > 0 && heightTV.getText().length() > 0 && topTV.getText().length() > 0) {
                    base = Double.parseDouble(baseTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());
                    top = Double.parseDouble(topTV.getText().toString());

                    volume = 1.0 / 3.0 * Math.PI * height * (top * top + base * base + top * base);
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.confruCalcBTN);
        baseTV = findViewById(R.id.confruBaseInputTV);
        heightTV = findViewById(R.id.confruHeightInputTV);
        topTV = findViewById(R.id.confruTopInputTV);
        result = findViewById(R.id.confruVolumeOutputTV);

        adView = findViewById(R.id.adViewcf);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
