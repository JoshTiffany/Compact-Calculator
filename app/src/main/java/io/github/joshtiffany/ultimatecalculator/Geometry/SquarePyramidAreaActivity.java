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

public class SquarePyramidAreaActivity extends AppCompatActivity {
    private Button calc;
    private EditText sideTV, heightTV;
    private TextView result;
    private Double side, height, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_pyramid_area);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0 && heightTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());

                    Double val1 = Math.pow(side, 2) / 4 + Math.pow(height, 2);
                    area = Math.pow(side, 2) + 2 * side * Math.sqrt(val1);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.squPyraCalcBTN);
        sideTV = findViewById(R.id.squPyraSideInputTV);
        heightTV = findViewById(R.id.squPyraHeightInputTV);
        result = findViewById(R.id.squPyraOutputTV);

        adView = findViewById(R.id.adViewat);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
