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

public class CubeVolumeActivity extends AppCompatActivity {

    private Button calc;
    private EditText sideTV;
    private TextView result;
    private Double side, volume;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube_volume);
        uisetup();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideTV.getText().length() > 0) {
                    side = Double.parseDouble(sideTV.getText().toString());

                    volume = side * side * side;
                    result.setText(String.valueOf(volume));

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.cubeCalcBTN);
        sideTV = findViewById(R.id.cubeSideInputTV);
        result = findViewById(R.id.cubeAreaOutputTV);

        adView = findViewById(R.id.adViewcuv);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
