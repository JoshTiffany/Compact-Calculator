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

public class RectangPrismAreaActivity extends AppCompatActivity {
    private Button calc;
    private EditText lenTV, widthTV, heightTV;
    private TextView result;
    private Double len, width, height, area;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectang_prism_area);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (widthTV.getText().length() > 0 && heightTV.getText().length() > 0 && lenTV.getText().length() > 0) {
                    len = Double.parseDouble(lenTV.getText().toString());
                    height = Double.parseDouble(heightTV.getText().toString());
                    width = Double.parseDouble(widthTV.getText().toString());

                    area = 2.0 * (width * len + height * len + height * width);
                    result.setText(String.valueOf(area));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.rectangARCalcBTN);
        widthTV = findViewById(R.id.rectangWidthInputTV);
        heightTV = findViewById(R.id.rectangHeightInputTV);
        lenTV = findViewById(R.id.rectangLenInputTV);
        result = findViewById(R.id.rectangAreaOutputTV);

        adView = findViewById(R.id.adViewtrape);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
