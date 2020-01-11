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

public class SquarePyrFrustumAreaActivity extends AppCompatActivity {
    private Button calc;
    private EditText baseTV, topTV, heightTV;
    private TextView result;
    private Double base, height, top, area, f, val1, val2;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_pyr_frustum_area);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseTV.getText().length() > 0 && heightTV.getText().length() > 0 && topTV.getText().length() > 0) {
                    base = Double.parseDouble(baseTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());
                    top = Double.parseDouble(topTV.getText().toString());

                    val2 = base - top;
                    val1 = (val2 / 2);
                    f = 2 * (base + top) * Math.sqrt(Math.pow(val1, 2) + Math.pow(height, 2));
                    area = f + Math.pow(base, 2) + Math.pow(top, 2);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.squpyrfruArCalcBTN);
        baseTV = findViewById(R.id.squpyrfruArBaseInputTV);
        heightTV = findViewById(R.id.squpyrfruHeightArInputTV);
        topTV = findViewById(R.id.squpyrfruArTopInputTV);
        result = findViewById(R.id.squpyrfruArOutputTV);

        adView = findViewById(R.id.adViewsqqupyf);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
