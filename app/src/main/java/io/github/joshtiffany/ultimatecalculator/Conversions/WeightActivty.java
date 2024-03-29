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

import static javax.measure.unit.NonSI.METRIC_TON;
import static javax.measure.unit.NonSI.OUNCE;
import static javax.measure.unit.NonSI.POUND;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.KILOGRAM;

public class WeightActivty extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button calc;
    private Spinner infospinner, resultspinner;
    private EditText info;
    private TextView result;
    private double val1;
    private UnitConverter ut;
    private AdView adview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_activty);
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
                R.array.weight1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infospinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.weight2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultspinner.setAdapter(adapter2);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (info.getText().length() > 0) {

                    // Milligram to...
                    if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(GRAM).getConverterTo(SI.MetricPrefix.CENTI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.CENTI(GRAM)).doubleValue(SI.MetricPrefix.CENTI(GRAM)));
                        result.setText(String.valueOf(val1));


                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(GRAM).getConverterTo(GRAM);
                        val1 = ut.convert(Measure.valueOf(val1, GRAM).doubleValue(GRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(GRAM).getConverterTo(KILOGRAM);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM).doubleValue(KILOGRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(GRAM).getConverterTo(METRIC_TON);
                        val1 = ut.convert(Measure.valueOf(val1, METRIC_TON).doubleValue(METRIC_TON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(GRAM).getConverterTo(OUNCE);
                        val1 = ut.convert(Measure.valueOf(val1, OUNCE).doubleValue(OUNCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 6) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MILLI(GRAM).getConverterTo(POUND);
                        val1 = ut.convert(Measure.valueOf(val1, POUND).doubleValue(POUND));
                        result.setText(String.valueOf(val1));

                    }


                    // Centigram to...
                    if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.CENTI(GRAM).getConverterTo(SI.MetricPrefix.MILLI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(GRAM)).doubleValue(SI.MetricPrefix.MILLI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.CENTI(GRAM).getConverterTo(GRAM);
                        val1 = ut.convert(Measure.valueOf(val1, GRAM).doubleValue(GRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.CENTI(GRAM).getConverterTo(KILOGRAM);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM).doubleValue(KILOGRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.CENTI(GRAM).getConverterTo(METRIC_TON);
                        val1 = ut.convert(Measure.valueOf(val1, METRIC_TON).doubleValue(METRIC_TON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.CENTI(GRAM).getConverterTo(OUNCE);
                        val1 = ut.convert(Measure.valueOf(val1, OUNCE).doubleValue(OUNCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 6) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.CENTI(GRAM).getConverterTo(POUND);
                        val1 = ut.convert(Measure.valueOf(val1, POUND).doubleValue(POUND));
                        result.setText(String.valueOf(val1));

                    }
                    // Gram to...
                    if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GRAM.getConverterTo(SI.MetricPrefix.MILLI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(GRAM)).doubleValue(SI.MetricPrefix.MILLI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GRAM.getConverterTo(SI.MetricPrefix.CENTI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.CENTI(GRAM)).doubleValue(SI.MetricPrefix.CENTI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GRAM.getConverterTo(KILOGRAM);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM).doubleValue(KILOGRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GRAM.getConverterTo(METRIC_TON);
                        val1 = ut.convert(Measure.valueOf(val1, METRIC_TON).doubleValue(METRIC_TON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GRAM.getConverterTo(OUNCE);
                        val1 = ut.convert(Measure.valueOf(val1, OUNCE).doubleValue(OUNCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 6) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = GRAM.getConverterTo(POUND);
                        val1 = ut.convert(Measure.valueOf(val1, POUND).doubleValue(POUND));
                        result.setText(String.valueOf(val1));

                    }
                    // Kilogram to...
                    if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM.getConverterTo(SI.MetricPrefix.MILLI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(GRAM)).doubleValue(SI.MetricPrefix.MILLI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM.getConverterTo(SI.MetricPrefix.CENTI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.CENTI(GRAM)).doubleValue(SI.MetricPrefix.CENTI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM.getConverterTo(GRAM);
                        val1 = ut.convert(Measure.valueOf(val1, GRAM).doubleValue(GRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM.getConverterTo(METRIC_TON);
                        val1 = ut.convert(Measure.valueOf(val1, METRIC_TON).doubleValue(METRIC_TON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM.getConverterTo(OUNCE);
                        val1 = ut.convert(Measure.valueOf(val1, OUNCE).doubleValue(OUNCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 6) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM.getConverterTo(POUND);
                        val1 = ut.convert(Measure.valueOf(val1, POUND).doubleValue(POUND));
                        result.setText(String.valueOf(val1));

                    }
                    // Metric_Ton to...
                    if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = METRIC_TON.getConverterTo(SI.MetricPrefix.MILLI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(GRAM)).doubleValue(SI.MetricPrefix.MILLI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = METRIC_TON.getConverterTo(SI.MetricPrefix.CENTI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.CENTI(GRAM)).doubleValue(SI.MetricPrefix.CENTI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = METRIC_TON.getConverterTo(GRAM);
                        val1 = ut.convert(Measure.valueOf(val1, GRAM).doubleValue(GRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = METRIC_TON.getConverterTo(KILOGRAM);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM).doubleValue(KILOGRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = METRIC_TON.getConverterTo(OUNCE);
                        val1 = ut.convert(Measure.valueOf(val1, OUNCE).doubleValue(OUNCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 6) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = METRIC_TON.getConverterTo(POUND);
                        val1 = ut.convert(Measure.valueOf(val1, POUND).doubleValue(POUND));
                        result.setText(String.valueOf(val1));

                    }
                    //Ounce to...
                    if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = OUNCE.getConverterTo(SI.MetricPrefix.MILLI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(GRAM)).doubleValue(SI.MetricPrefix.MILLI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = OUNCE.getConverterTo(SI.MetricPrefix.CENTI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.CENTI(GRAM)).doubleValue(SI.MetricPrefix.CENTI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = OUNCE.getConverterTo(GRAM);
                        val1 = ut.convert(Measure.valueOf(val1, GRAM).doubleValue(GRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = OUNCE.getConverterTo(KILOGRAM);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM).doubleValue(KILOGRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = OUNCE.getConverterTo(METRIC_TON);
                        val1 = ut.convert(Measure.valueOf(val1, METRIC_TON).doubleValue(METRIC_TON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 5 && resultspinner.getSelectedItemId() == 6) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = OUNCE.getConverterTo(POUND);
                        val1 = ut.convert(Measure.valueOf(val1, POUND).doubleValue(POUND));
                        result.setText(String.valueOf(val1));

                    }

                    // Pound to...
                    if (infospinner.getSelectedItemId() == 6 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND.getConverterTo(SI.MetricPrefix.MILLI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MILLI(GRAM)).doubleValue(SI.MetricPrefix.MILLI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 6 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND.getConverterTo(SI.MetricPrefix.CENTI(GRAM));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.CENTI(GRAM)).doubleValue(SI.MetricPrefix.CENTI(GRAM)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 6 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND.getConverterTo(GRAM);
                        val1 = ut.convert(Measure.valueOf(val1, GRAM).doubleValue(GRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 6 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND.getConverterTo(KILOGRAM);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM).doubleValue(KILOGRAM));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 6 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND.getConverterTo(METRIC_TON);
                        val1 = ut.convert(Measure.valueOf(val1, METRIC_TON).doubleValue(METRIC_TON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 6 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND.getConverterTo(OUNCE);
                        val1 = ut.convert(Measure.valueOf(val1, OUNCE).doubleValue(OUNCE));
                        result.setText(String.valueOf(val1));

                    }
                }
            }
        });
    }


    public void uisetup() {
        calc = findViewById(R.id.weightCalcBTN);
        infospinner = findViewById(R.id.weightInfoSpinner);
        resultspinner = findViewById(R.id.weightResultSpinner);
        info = findViewById(R.id.weightInfoTV);
        result = findViewById(R.id.weightResultTV);

        adview = findViewById(R.id.adViewwei);
        AdRequest adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);
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
        getMenuInflater().inflate(R.menu.weight_activty, menu);
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
