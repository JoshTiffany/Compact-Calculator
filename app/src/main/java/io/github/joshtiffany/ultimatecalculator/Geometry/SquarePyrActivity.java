package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class SquarePyrActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV, heightTV;
    private TextView result;
    private Double side, height, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_pyr);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0 && heightTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());

                    volume = side * side * height / 3;
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.squpyrCalcBTN);
        sideTV = findViewById(R.id.squpyrSideInputTV);
        heightTV = findViewById(R.id.squpyrHeightInputTV);
        result = findViewById(R.id.squpyrAreaOutputTV);
    }

}
