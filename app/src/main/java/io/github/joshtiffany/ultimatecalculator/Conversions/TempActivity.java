package io.github.joshtiffany.ultimatecalculator.Conversions;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.Geometry.AreaActivity;
import io.github.joshtiffany.ultimatecalculator.R;
import io.github.joshtiffany.ultimatecalculator.SettingsMisc.SettingsActivity;

public class TempActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private EditText info;
    private TextView result;
    private Button infoselc;
    private Button resultselc;
    private Button calc;
    int temp;
    int val1;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        uiSetUp();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    if (infoselc.getTag().equals(0) && resultselc.getTag().equals(0)) {
                        val1 = Integer.parseInt(info.getText().toString());

                        temp = ((val1 - 32) * 5) / 9;
                        result.setText(String.valueOf(temp));
                    } else if (infoselc.getTag().equals(1) && resultselc.getTag().equals(1)) {
                        val1 = Integer.parseInt(info.getText().toString());

                        temp = (val1 * 9 / 5) + 32;
                        result.setText(String.valueOf(temp));
                    }
                }

            }
        });
        infoselc.setTag(0);
        infoselc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int status = (Integer) v.getTag();
                switch (status) {
                    case 0:
                        v.setTag(1);
                        infoselc.setText("°C");
                        break;
                    case 1:
                        v.setTag(0);
                        infoselc.setText("°F");
                        break;
                }
            }
        });

        resultselc.setTag(0);
        resultselc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int status = (Integer) v.getTag();
                switch (status) {
                    case 0:
                        v.setTag(1);
                        resultselc.setText("°F");
                        break;
                    case 1:
                        v.setTag(0);
                        resultselc.setText("°C");
                        break;
                }
            }
        });
    }


    public void uiSetUp() {
        info = findViewById(R.id.tempInfoTV);
        result = findViewById(R.id.tempResultTV);
        infoselc = findViewById(R.id.infoSelc);
        resultselc = findViewById(R.id.resultSelc);
        calc = findViewById(R.id.calc);

        adView = findViewById(R.id.adViewtemp);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.temp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent homeIntent = new Intent(this, SettingsActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent startintent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_gallery) {
            Intent startintent = new Intent(getApplicationContext(), ScientificActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_share) {
            Intent startintent = new Intent(getApplicationContext(), TempActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_send) {
            Intent startintent = new Intent(getApplicationContext(), MeasureActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_time) {
            Intent startintent = new Intent(getApplicationContext(), TimeActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_speed) {
            Intent startintent = new Intent(getApplicationContext(), SpeedActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_volume) {
            Intent startintent = new Intent(getApplicationContext(), VolumeActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_force) {
            Intent startintent = new Intent(getApplicationContext(), ForceActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_weight) {
            Intent startintent = new Intent(getApplicationContext(), WeightActivty.class);
            startActivity(startintent);
        } else if (id == R.id.nav_power) {
            Intent startintent = new Intent(getApplicationContext(), PowerActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_pressure) {
            Intent startintent = new Intent(getApplicationContext(), Pressure.class);
            startActivity(startintent);
        } else if (id == R.id.nav_energy) {
            Intent startintent = new Intent(getApplicationContext(), EnergyActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_angle) {
            Intent startintent = new Intent(getApplicationContext(), AngleActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_area) {
            Intent startintent = new Intent(getApplicationContext(), AreaActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_geovolume) {
            Intent startintent = new Intent(getApplicationContext(), io.github.joshtiffany.ultimatecalculator.Geometry.VolumeActivity.class);
            startActivity(startintent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
