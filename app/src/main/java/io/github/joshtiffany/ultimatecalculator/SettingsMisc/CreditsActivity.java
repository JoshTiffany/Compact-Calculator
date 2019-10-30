package io.github.joshtiffany.ultimatecalculator.SettingsMisc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.github.joshtiffany.ultimatecalculator.R;

public class CreditsActivity extends AppCompatActivity {

    Button javax, flat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        uisetup();

        javax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jcp.org/en/home/index"));
                startActivity(browserIntent);
            }
        });

        flat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/"));
                startActivity(browserIntent);
            }
        });

    }

    public void uisetup() {
        javax = findViewById(R.id.javaXBTN);
        flat = findViewById(R.id.flaticonBTN);
    }

}
