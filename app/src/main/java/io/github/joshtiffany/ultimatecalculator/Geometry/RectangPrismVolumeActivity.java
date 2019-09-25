package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.github.joshtiffany.ultimatecalculator.R;

public class RectangPrismVolumeActivity extends AppCompatActivity {

    private Button calc;
    private EditText lengthTV, widthTV, heightTV;
    private TextView result;
    private Double length, height, width, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectang_prism_volume);
        uisetup();
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lengthTV.getText().length() > 0 && heightTV.getText().length() > 0 && widthTV.getText().length() > 0) {
                    length = Double.parseDouble(lengthTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());
                    width = Double.parseDouble(widthTV.getText().toString());

                    volume = length * width * height;
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.repriCalcBTN);
        lengthTV = findViewById(R.id.repriLengthInputTV);
        heightTV = findViewById(R.id.repriHeightInputTV);
        widthTV = findViewById(R.id.repriWidthInputTV);
        result = findViewById(R.id.repriVolumeOutputTV);
    }

}
