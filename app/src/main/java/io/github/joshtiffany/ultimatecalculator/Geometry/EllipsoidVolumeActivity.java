package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.joshtiffany.ultimatecalculator.R;

public class EllipsoidVolumeActivity extends AppCompatActivity {

    private Button calc;
    private EditText radiATV, radiBTV, radiCTV;
    private TextView result;
    private Double radiA, radiB, radiC, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipsoid_volume);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiATV.getText().length() > 0 && radiBTV.getText().length() > 0 && radiCTV.getText().length() > 0) {
                    radiA = Double.parseDouble(radiATV.getText().toString());
                    radiB = Double.parseDouble(radiBTV.getText().toString());
                    radiC = Double.parseDouble(radiCTV.getText().toString());

                    volume = 4.0 / 3.0 * Math.PI * radiA * radiB * radiC;
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.elvCalcBTN);
        radiATV = findViewById(R.id.elvRadiAInputTV);
        radiBTV = findViewById(R.id.elvRadiBInputTV);
        radiCTV = findViewById(R.id.elvRadiCInputTV);
        result = findViewById(R.id.elvVolumeOutputTV);
    }
}