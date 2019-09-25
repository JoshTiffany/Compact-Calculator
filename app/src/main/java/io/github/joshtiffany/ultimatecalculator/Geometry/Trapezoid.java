package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.github.joshtiffany.ultimatecalculator.R;

public class Trapezoid extends AppCompatActivity {

    private Button calc;
    private EditText baseTV, heightTV, topTV;
    private TextView result;
    private Double top, height, base, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapezoid);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseTV.getText().length() > 0 && heightTV.getText().length() > 0 && topTV.getText().length() > 0) {
                    top = Double.parseDouble(topTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());
                    base = Double.parseDouble(baseTV.getText().toString());

                    area = (top + base) * height / 1 / 2;
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.trapCalcBTN);
        baseTV = findViewById(R.id.trapBaseInputTV);
        heightTV = findViewById(R.id.trapHeightInputTV);
        topTV = findViewById(R.id.trapTopInputTV);
        result = findViewById(R.id.trapAreaOutputTV);
    }

}
