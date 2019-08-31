package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class PentagonActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV;
    private TextView result;
    private Double side, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pentagon);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());

                    area = (Math.sqrt(5 * (5 + 2 * (Math.sqrt(5)))) * side * side) / 4;
                    result.setText(String.valueOf(area));

                }
            }
        });


    }

    public void uisetup() {
        calc = findViewById(R.id.penCalcBTN);
        sideTV = findViewById(R.id.penSideInputTV);
        result = findViewById(R.id.penAreaOutputTV);
    }

}
