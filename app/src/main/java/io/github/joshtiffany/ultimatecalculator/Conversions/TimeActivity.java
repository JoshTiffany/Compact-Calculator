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

import javax.measure.Measure;
import javax.measure.converter.UnitConverter;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.R;

import static javax.measure.unit.NonSI.DAY;
import static javax.measure.unit.NonSI.FOOT;
import static javax.measure.unit.NonSI.HOUR;
import static javax.measure.unit.NonSI.INCH;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.NonSI.MINUTE;
import static javax.measure.unit.NonSI.NAUTICAL_MILE;
import static javax.measure.unit.NonSI.WEEK;
import static javax.measure.unit.NonSI.YARD;
import static javax.measure.unit.SI.CENTIMETRE;
import static javax.measure.unit.SI.KILOMETRE;
import static javax.measure.unit.SI.METRE;
import static javax.measure.unit.SI.MILLIMETRE;
import static javax.measure.unit.SI.SECOND;

public class TimeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button calc;
    private Spinner infospinner, resultspinner;
    private TextView result;
    private EditText info;
    private Double val1;
    private UnitConverter ut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        uiSetup();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.time1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infospinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.time2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultspinner.setAdapter(adapter2);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    // Second to...
                    if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SECOND.getConverterTo(MINUTE);
                        val1 = ut.convert(Measure.valueOf(val1, MINUTE).doubleValue(MINUTE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SECOND.getConverterTo(HOUR);
                        val1 = ut.convert(Measure.valueOf(val1, HOUR).doubleValue(HOUR));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SECOND.getConverterTo(DAY);
                        val1 = ut.convert(Measure.valueOf(val1, DAY).doubleValue(DAY));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SECOND.getConverterTo(WEEK);
                        val1 = ut.convert(Measure.valueOf(val1, WEEK).doubleValue(WEEK));
                        result.setText(String.valueOf(val1));
                    }

                    // Minute to...
                    if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = MINUTE.getConverterTo(SECOND);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND).doubleValue(SECOND));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = MINUTE.getConverterTo(HOUR);
                        val1 = ut.convert(Measure.valueOf(val1, HOUR).doubleValue(HOUR));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = MINUTE.getConverterTo(DAY);
                        val1 = ut.convert(Measure.valueOf(val1, DAY).doubleValue(DAY));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = MINUTE.getConverterTo(WEEK);
                        val1 = ut.convert(Measure.valueOf(val1, WEEK).doubleValue(WEEK));
                        result.setText(String.valueOf(val1));
                    }

                    // Hour to...
                    if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = HOUR.getConverterTo(SECOND);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND).doubleValue(SECOND));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = HOUR.getConverterTo(MINUTE);
                        val1 = ut.convert(Measure.valueOf(val1, MINUTE).doubleValue(MINUTE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = HOUR.getConverterTo(DAY);
                        val1 = ut.convert(Measure.valueOf(val1, DAY).doubleValue(DAY));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = HOUR.getConverterTo(WEEK);
                        val1 = ut.convert(Measure.valueOf(val1, WEEK).doubleValue(WEEK));
                        result.setText(String.valueOf(val1));
                    }

                    // Day to...
                    if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DAY.getConverterTo(SECOND);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND).doubleValue(SECOND));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DAY.getConverterTo(MINUTE);
                        val1 = ut.convert(Measure.valueOf(val1, MINUTE).doubleValue(MINUTE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DAY.getConverterTo(HOUR);
                        val1 = ut.convert(Measure.valueOf(val1, HOUR).doubleValue(HOUR));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DAY.getConverterTo(WEEK);
                        val1 = ut.convert(Measure.valueOf(val1, WEEK).doubleValue(WEEK));
                        result.setText(String.valueOf(val1));
                    }

                    // Week to...
                    if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = WEEK.getConverterTo(SECOND);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND).doubleValue(SECOND));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = WEEK.getConverterTo(MINUTE);
                        val1 = ut.convert(Measure.valueOf(val1, MINUTE).doubleValue(MINUTE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = WEEK.getConverterTo(HOUR);
                        val1 = ut.convert(Measure.valueOf(val1, HOUR).doubleValue(HOUR));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = WEEK.getConverterTo(DAY);
                        val1 = ut.convert(Measure.valueOf(val1, DAY).doubleValue(DAY));
                        result.setText(String.valueOf(val1));
                    }

                }
            }
        });

    }

    public void uiSetup() {
        calc = findViewById(R.id.timeCalcBTN3);
        resultspinner = findViewById(R.id.timeResultSpinner3);
        infospinner = findViewById(R.id.timeInfoSpinner5);
        info = findViewById(R.id.timeInfoTV5);
        result = findViewById(R.id.timeResultTV3);
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
        getMenuInflater().inflate(R.menu.time, menu);
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
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
