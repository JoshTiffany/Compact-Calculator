package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaEllipseActivity extends AppCompatActivity {

    private Button calc;
    private EditText radiusATV, radiusBTV;
    private TextView result;
    private Double radiusA, radiusB, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_ellipse);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusATV.getText().length() > 0 && radiusBTV.getText().length() > 0) {
                    radiusA = Double.parseDouble(radiusATV.getText().toString());
                    radiusB = Double.parseDouble(radiusBTV.getText().toString());

                    area = Math.PI * radiusA * radiusB;
                    result.setText(String.valueOf(area));

                }
            }
        });
    }

    public void uisetup() {
        calc = findViewById(R.id.ellCalcBTN);
        radiusATV = findViewById(R.id.ellRadiusAInputTV);
        radiusBTV = findViewById(R.id.ellRadiusBInputTV);
        result = findViewById(R.id.ellAreaOutputTV);
    }

}
