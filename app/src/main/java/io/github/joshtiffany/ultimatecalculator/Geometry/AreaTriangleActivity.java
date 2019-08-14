package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaTriangleActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV, heightTV;
    private TextView result;
    private Double side, height, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_triangle);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0 && heightTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());

                    area = (side * height) / 2;
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.triCalcBTN);
        sideTV = findViewById(R.id.sideInputTV);
        heightTV = findViewById(R.id.heightInputTV);
        result = findViewById(R.id.areaOutputTV);
    }

}
