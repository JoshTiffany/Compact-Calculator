package io.github.joshtiffany.ultimatecalculator.Conversions;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;

import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import javax.measure.unit.SI;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.Geometry.AreaActivity;
import io.github.joshtiffany.ultimatecalculator.R;
import io.github.joshtiffany.ultimatecalculator.SettingsMisc.SettingsActivity;

import static javax.measure.unit.NonSI.CUBIC_INCH;
import static javax.measure.unit.NonSI.GALLON_LIQUID_US;
import static javax.measure.unit.NonSI.LITRE;
import static javax.measure.unit.SI.CUBIC_METRE;

public class VolumeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button calc;
    private Spinner infospinner, resultspinner;
    private EditText info;
    private TextView result;
    private double val1;
    private UnitConverter ut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
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
        uisetup();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.volume1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infospinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.volume2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultspinner.setAdapter(adapter2);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_INCH.getConverterTo(CUBIC_METRE);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_METRE).doubleValue(CUBIC_METRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_INCH.getConverterTo(SI.MetricPrefix.MILLI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(LITRE)).doubleValue(SI.MetricPrefix.MILLI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_INCH.getConverterTo(SI.MetricPrefix.DECI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.DECI(LITRE)).doubleValue(SI.MetricPrefix.DECI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_INCH.getConverterTo(LITRE);
                        val1 = ut.convert(Measure.valueOf(val1, LITRE).doubleValue(LITRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 5) {

                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_INCH.getConverterTo(GALLON_LIQUID_US);
                        val1 = ut.convert(Measure.valueOf(val1, GALLON_LIQUID_US).doubleValue(GALLON_LIQUID_US));
                        result.setText(String.valueOf(val1));
                    }


                    // Feet to...
                    if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_METRE.getConverterTo(CUBIC_INCH);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_INCH).doubleValue(CUBIC_INCH));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_METRE.getConverterTo(SI.MetricPrefix.MILLI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(LITRE)).doubleValue(SI.MetricPrefix.MILLI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_METRE.getConverterTo(SI.MetricPrefix.DECI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.DECI(LITRE)).doubleValue(SI.MetricPrefix.DECI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_METRE.getConverterTo(LITRE);
                        val1 = ut.convert(Measure.valueOf(val1, LITRE).doubleValue(LITRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = CUBIC_METRE.getConverterTo(GALLON_LIQUID_US);
                        val1 = ut.convert(Measure.valueOf(val1, GALLON_LIQUID_US).doubleValue(GALLON_LIQUID_US));
                        result.setText(String.valueOf(val1));

                    }
                    // Yards to...
                    if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(LITRE).getConverterTo(CUBIC_INCH);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_INCH).doubleValue(CUBIC_INCH));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(LITRE).getConverterTo(CUBIC_METRE);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_METRE).doubleValue(CUBIC_METRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(LITRE).getConverterTo(SI.MetricPrefix.DECI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.DECI(LITRE)).doubleValue(SI.MetricPrefix.DECI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(LITRE).getConverterTo(LITRE);
                        val1 = ut.convert(Measure.valueOf(val1, LITRE).doubleValue(LITRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(LITRE).getConverterTo(GALLON_LIQUID_US);
                        val1 = ut.convert(Measure.valueOf(val1, GALLON_LIQUID_US).doubleValue(GALLON_LIQUID_US));
                        result.setText(String.valueOf(val1));

                    }
                    // Mile to...
                    if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.DECI(LITRE).getConverterTo(CUBIC_INCH);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_INCH).doubleValue(CUBIC_INCH));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.DECI(LITRE).getConverterTo(CUBIC_METRE);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_METRE).doubleValue(CUBIC_METRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.DECI(LITRE).getConverterTo(SI.MetricPrefix.MILLI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(LITRE)).doubleValue(SI.MetricPrefix.MILLI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.DECI(LITRE).getConverterTo(LITRE);
                        val1 = ut.convert(Measure.valueOf(val1, LITRE).doubleValue(LITRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.DECI(LITRE).getConverterTo(GALLON_LIQUID_US);
                        val1 = ut.convert(Measure.valueOf(val1, GALLON_LIQUID_US).doubleValue(GALLON_LIQUID_US));
                        result.setText(String.valueOf(val1));

                    }
                    // N-Miles to...
                    if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = LITRE.getConverterTo(CUBIC_INCH);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_INCH).doubleValue(CUBIC_INCH));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = LITRE.getConverterTo(CUBIC_METRE);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_METRE).doubleValue(CUBIC_METRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = LITRE.getConverterTo(SI.MetricPrefix.MILLI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(LITRE)).doubleValue(SI.MetricPrefix.MILLI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = LITRE.getConverterTo(SI.MetricPrefix.DECI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.DECI(LITRE)).doubleValue(SI.MetricPrefix.DECI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = LITRE.getConverterTo(GALLON_LIQUID_US);
                        val1 = ut.convert(Measure.valueOf(val1, GALLON_LIQUID_US).doubleValue(GALLON_LIQUID_US));
                        result.setText(String.valueOf(val1));

                    }
                    //Millimeter to...
                    if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GALLON_LIQUID_US.getConverterTo(CUBIC_INCH);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_INCH).doubleValue(CUBIC_INCH));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GALLON_LIQUID_US.getConverterTo(CUBIC_METRE);
                        val1 = ut.convert(Measure.valueOf(val1, CUBIC_METRE).doubleValue(CUBIC_METRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GALLON_LIQUID_US.getConverterTo(SI.MetricPrefix.MILLI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(LITRE)).doubleValue(SI.MetricPrefix.MILLI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GALLON_LIQUID_US.getConverterTo(SI.MetricPrefix.DECI(LITRE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.DECI(LITRE)).doubleValue(SI.MetricPrefix.DECI(LITRE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GALLON_LIQUID_US.getConverterTo(LITRE);
                        val1 = ut.convert(Measure.valueOf(val1, LITRE).doubleValue(LITRE));
                        result.setText(String.valueOf(val1));

                    }

                }
            }
        });
    }

    public void uisetup() {
        calc = findViewById(R.id.volumeCalcBTN);
        infospinner = findViewById(R.id.volumeInfoSpinner);
        resultspinner = findViewById(R.id.volumeResultSpinner);
        info = findViewById(R.id.volumeInfoTV);
        result = findViewById(R.id.volumeResultTV);

        AdView adView = findViewById(R.id.adViewvol);
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
        getMenuInflater().inflate(R.menu.volume, menu);
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
