package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaParallelogramActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV, heightTV;
    private TextView result;
    private Double side, height, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_parallelogram);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0 && heightTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());

                    area = side * height;
                    result.setText(String.valueOf(area));

                }
            }
        });


    }

    public void uisetup() {
        calc = findViewById(R.id.paraCalcBTN);
        sideTV = findViewById(R.id.paraSideInputTV);
        heightTV = findViewById(R.id.paraHeightInputTV);
        result = findViewById(R.id.paraAreaOutputTV);
    }

}
