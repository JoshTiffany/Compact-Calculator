package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaHexagonActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV;
    private TextView result;
    private Double side, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_hexagon);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());

                    area = ((3 * Math.sqrt(3) * (side * side)) / 2);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.hexCalcBTN);
        sideTV = findViewById(R.id.hexSideInputTV);
        result = findViewById(R.id.hexAreaOutputTV);
    }

}
