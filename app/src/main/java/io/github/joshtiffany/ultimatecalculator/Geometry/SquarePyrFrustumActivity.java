package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class SquarePyrFrustumActivity extends AppCompatActivity {

    private Button calc;
    private EditText baseTV, topTV, heightTV;
    private TextView result;
    private Double base, height, top, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_pyr_frustum);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseTV.getText().length() > 0 && heightTV.getText().length() > 0 && topTV.getText().length() > 0) {
                    base = Double.parseDouble(baseTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());
                    top = Double.parseDouble(topTV.getText().toString());

                    volume = 1.0 / 3.0 * (base * base + base * top + top * top) * height;
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.squpyfruCalcBTN);
        baseTV = findViewById(R.id.squpyrfruBaseInputTV);
        heightTV = findViewById(R.id.squpyfruHeightInputTV);
        topTV = findViewById(R.id.squpyrfruTopInputTV);
        result = findViewById(R.id.squpyfruVolumeOutputTV);
    }

}
