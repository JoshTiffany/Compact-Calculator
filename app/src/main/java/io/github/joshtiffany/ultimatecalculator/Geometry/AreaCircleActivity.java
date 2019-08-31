package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaCircleActivity extends AppCompatActivity {

    private Button calc;
    private EditText radiusTV;
    private TextView result;
    private Double radius, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circle);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusTV.getText().length() > 0) {
                    radius = Double.parseDouble(radiusTV.getText().toString());

                    area = Math.PI * radius * radius;
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.cirCalcBTN);
        radiusTV = findViewById(R.id.cirRadiusInputTV);
        result = findViewById(R.id.cirAreaOutputTV);
    }

}
