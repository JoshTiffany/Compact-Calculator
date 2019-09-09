package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class CylinderVolumeActivity extends AppCompatActivity {

    private Button calc;
    private EditText radiusTV, heightTV;
    private TextView result;
    private Double radius, height, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder_volume);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusTV.getText().length() > 0 && heightTV.getText().length() > 0) {
                    radius = Double.parseDouble(radiusTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());

                    volume = Math.PI * radius * radius * height;
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.cylCalcBTN);
        radiusTV = findViewById(R.id.cylRadiusInputTV);
        heightTV = findViewById(R.id.cylHeightInputTV);
        result = findViewById(R.id.cylAreaOutputTV);
    }
}