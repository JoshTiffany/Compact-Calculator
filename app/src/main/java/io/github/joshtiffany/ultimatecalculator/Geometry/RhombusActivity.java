package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class RhombusActivity extends AppCompatActivity {

    private Button calc;
    private EditText lengthTV, widthTV;
    private TextView result;
    private Double length, width, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhombus);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lengthTV.getText().length() > 0 && widthTV.getText().length() > 0) {
                    length = Double.parseDouble(lengthTV.getText().toString());
                    width = Double.parseDouble(widthTV.getText().toString());

                    area = length * width / 2;
                    result.setText(String.valueOf(area));

                }
            }
        });


    }

    public void uisetup() {
        calc = findViewById(R.id.rhoCalcBTN);
        lengthTV = findViewById(R.id.rhoLengthInputTV);
        widthTV = findViewById(R.id.rhoWidthInputTV);
        result = findViewById(R.id.rhoAreaOutputTV);
    }

}
