package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import io.github.joshtiffany.ultimatecalculator.R;

public class AreaRectangleActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV, widthTV;
    private TextView result;
    private Double side, width, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_rectangle);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0 && widthTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());
                    width = Double.parseDouble(widthTV.getText().toString());

                    area = side * width;
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.recCalcBTN);
        sideTV = findViewById(R.id.recSideInputTV);
        widthTV = findViewById(R.id.recWidthInputTV);
        result = findViewById(R.id.recAreaOutputTV);

        adView = findViewById(R.id.adViewar);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
