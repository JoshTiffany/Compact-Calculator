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

public class EllipsoidAreaActivity extends AppCompatActivity {
    private Button calc;
    private EditText radiATV, radiBTV, radiCTV;
    private TextView result;
    private Double radiA, radiB, radiC, area, val1, val2, val3, val4;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipsoid_area);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiATV.getText().length() > 0 && radiBTV.getText().length() > 0 && radiCTV.getText().length() > 0) {
                    radiA = Double.parseDouble(radiATV.getText().toString());
                    radiB = Double.parseDouble(radiBTV.getText().toString());
                    radiC = Double.parseDouble(radiCTV.getText().toString());

                    val2 = Math.pow(radiA * radiB, 1.6);
                    val3 = Math.pow(radiA * radiC, 1.6);
                    val4 = Math.pow(radiC * radiB, 1.6);
                    val1 = (val2 + val3 + val4) / 3;
                    area = 4.0 * Math.PI * Math.pow(val1, 1 / 1.6);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.elvArCalcBTN);
        radiATV = findViewById(R.id.elvRadiAArInputTV);
        radiBTV = findViewById(R.id.elvRadiBArInputTV);
        radiCTV = findViewById(R.id.elvRadiCArInputTV);
        result = findViewById(R.id.elvArOutputTV);

        adView = findViewById(R.id.adViewvell);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
