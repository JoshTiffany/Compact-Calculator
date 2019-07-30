package io.github.joshtiffany.ultimatecalculator.Conversions;

import android.content.Intent;
import android.os.Bundle;
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

import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import javax.measure.unit.SI;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.R;

import static javax.measure.unit.NonSI.ELECTRON_VOLT;
import static javax.measure.unit.NonSI.ERG;
import static javax.measure.unit.SI.JOULE;

public class EnergyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button calc;
    private Spinner infospinner, resultspinner;
    private EditText info;
    private TextView result;
    private double val1;
    private UnitConverter ut;
    private boolean val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);
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
                R.array.energy1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infospinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.energy2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultspinner.setAdapter(adapter2);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (info.getText().length() > 0) {


                    // Megapascal to...
                    if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MEGA(JOULE).getConverterTo(SI.MetricPrefix.KILO(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.KILO(JOULE)).doubleValue(SI.MetricPrefix.KILO(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MEGA(JOULE).getConverterTo(JOULE);
                        val1 = ut.convert(Measure.valueOf(val1, JOULE).doubleValue(JOULE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MEGA(JOULE).getConverterTo(ERG);
                        val1 = ut.convert(Measure.valueOf(val1, ERG).doubleValue(ERG));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.MEGA(JOULE).getConverterTo(ELECTRON_VOLT);
                        val1 = ut.convert(Measure.valueOf(val1, ELECTRON_VOLT).doubleValue(ELECTRON_VOLT));
                        result.setText(String.valueOf(val1));

                    }


                    // Kilopascal to...
                    if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.KILO(JOULE).getConverterTo(SI.MetricPrefix.MEGA(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MEGA(JOULE)).doubleValue(SI.MetricPrefix.MEGA(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.KILO(JOULE).getConverterTo(JOULE);
                        val1 = ut.convert(Measure.valueOf(val1, JOULE).doubleValue(JOULE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.KILO(JOULE).getConverterTo(ERG);
                        val1 = ut.convert(Measure.valueOf(val1, ERG).doubleValue(ERG));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SI.MetricPrefix.KILO(JOULE).getConverterTo(ELECTRON_VOLT);
                        val1 = ut.convert(Measure.valueOf(val1, ELECTRON_VOLT).doubleValue(ELECTRON_VOLT));
                        result.setText(String.valueOf(val1));

                    }
                    // Pascal to...
                    if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = JOULE.getConverterTo(SI.MetricPrefix.MEGA(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MEGA(JOULE)).doubleValue(SI.MetricPrefix.MEGA(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = JOULE.getConverterTo(SI.MetricPrefix.KILO(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.KILO(JOULE)).doubleValue(SI.MetricPrefix.KILO(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = JOULE.getConverterTo(ERG);
                        val1 = ut.convert(Measure.valueOf(val1, ERG).doubleValue(ERG));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = JOULE.getConverterTo(ELECTRON_VOLT);
                        val1 = ut.convert(Measure.valueOf(val1, ELECTRON_VOLT).doubleValue(ELECTRON_VOLT));
                        result.setText(String.valueOf(val1));

                    }
                    // Bar to...
                    if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ERG.getConverterTo(SI.MetricPrefix.MEGA(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MEGA(JOULE)).doubleValue(SI.MetricPrefix.MEGA(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ERG.getConverterTo(SI.MetricPrefix.KILO(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.KILO(JOULE)).doubleValue(SI.MetricPrefix.KILO(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ERG.getConverterTo(JOULE);
                        val1 = ut.convert(Measure.valueOf(val1, JOULE).doubleValue(JOULE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ERG.getConverterTo(ELECTRON_VOLT);
                        val1 = ut.convert(Measure.valueOf(val1, ELECTRON_VOLT).doubleValue(ELECTRON_VOLT));
                        result.setText(String.valueOf(val1));

                    }
                    // Atmosphere to...
                    if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ELECTRON_VOLT.getConverterTo(SI.MetricPrefix.MEGA(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.MEGA(JOULE)).doubleValue(SI.MetricPrefix.MEGA(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ELECTRON_VOLT.getConverterTo(SI.MetricPrefix.KILO(JOULE));
                        val1 = ut.convert(Measure.valueOf(val1, SI.MetricPrefix.KILO(JOULE)).doubleValue(SI.MetricPrefix.KILO(JOULE)));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ELECTRON_VOLT.getConverterTo(ERG);
                        val1 = ut.convert(Measure.valueOf(val1, ERG).doubleValue(ERG));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = ELECTRON_VOLT.getConverterTo(ELECTRON_VOLT);
                        val1 = ut.convert(Measure.valueOf(val1, ELECTRON_VOLT).doubleValue(ELECTRON_VOLT));
                        result.setText(String.valueOf(val1));

                    }

                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.energyCalcBTN);
        infospinner = findViewById(R.id.energyInfoSpinner);
        resultspinner = findViewById(R.id.energyResultSpinner);
        info = findViewById(R.id.energyInfoTV);
        result = findViewById(R.id.energyResultTV);
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
        getMenuInflater().inflate(R.menu.energy, menu);
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

        if (id == R.id.nav_standard) {
            Intent startintent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_scientific) {
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
        } else if (id == R.id.nav_angle) {
            Intent startintent = new Intent(getApplicationContext(), AngleActivity.class);
            startActivity(startintent);
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
