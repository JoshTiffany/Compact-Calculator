package io.github.joshtiffany.ultimatecalculator.Conversions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static javax.measure.unit.NonSI.CUBIC_INCH;
import static javax.measure.unit.NonSI.DAY;
import static javax.measure.unit.NonSI.FOOT;
import static javax.measure.unit.NonSI.GALLON_LIQUID_US;
import static javax.measure.unit.NonSI.HOUR;
import static javax.measure.unit.NonSI.INCH;
import static javax.measure.unit.NonSI.LITRE;
import static javax.measure.unit.NonSI.METRIC_TON;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.NonSI.MINUTE;
import static javax.measure.unit.NonSI.NAUTICAL_MILE;
import static javax.measure.unit.NonSI.WEEK;
import static javax.measure.unit.NonSI.YARD;
import static javax.measure.unit.SI.CENTIMETRE;
import static javax.measure.unit.SI.CUBIC_METRE;
import static javax.measure.unit.SI.KILOMETRE;
import static javax.measure.unit.SI.METRE;
import static javax.measure.unit.SI.MILLIMETRE;
import static javax.measure.unit.SI.SECOND;

import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Volume;
import javax.measure.unit.SI;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.R;

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
        } else if (id == R.id.speed) {
            Intent startintent = new Intent(getApplicationContext(), SpeedActivity.class);
            startActivity(startintent);
        } else if (id == R.id.volume) {
            Intent startintent = new Intent(getApplicationContext(), VolumeActivity.class);
            startActivity(startintent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
