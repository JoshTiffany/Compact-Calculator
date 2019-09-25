package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaCircleArcActivty extends AppCompatActivity {

    private Button calc;
    private EditText radiusTV, angleTV;
    private TextView result;
    private Double radius, angle, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circle_arc_activty);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiusTV.getText().length() > 0 && angleTV.getText().length() > 0) {
                    radius = Double.parseDouble(radiusTV.getText().toString());
                    angle = Double.parseDouble(angleTV.getText().toString());

                    area = ((22 * radius * radius) / 7) * (angle / 360);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.ciraCalcBTN);
        radiusTV = findViewById(R.id.ciraRadiusInputTV);
        angleTV = findViewById(R.id.ciraAngleInputTV);
        result = findViewById(R.id.ciraAreaOutputTV);
    }

}
