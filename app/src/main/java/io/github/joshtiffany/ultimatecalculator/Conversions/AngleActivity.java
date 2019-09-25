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

import com.google.android.material.navigation.NavigationView;

import javax.measure.Measure;
import javax.measure.converter.UnitConverter;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.Geometry.AreaActivity;
import io.github.joshtiffany.ultimatecalculator.R;

import static javax.measure.unit.NonSI.DEGREE_ANGLE;
import static javax.measure.unit.NonSI.MINUTE_ANGLE;
import static javax.measure.unit.NonSI.SECOND_ANGLE;
import static javax.measure.unit.SI.RADIAN;

public class AngleActivity extends AppCompatActivity
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
        setContentView(R.layout.activity_angle);
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
                R.array.angle1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infospinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.angle2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultspinner.setAdapter(adapter2);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    // Radian to...
                    if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = RADIAN.getConverterTo(DEGREE_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, DEGREE_ANGLE).doubleValue(DEGREE_ANGLE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = RADIAN.getConverterTo(MINUTE_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, MINUTE_ANGLE).doubleValue(MINUTE_ANGLE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = RADIAN.getConverterTo(SECOND_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND_ANGLE).doubleValue(SECOND_ANGLE));
                        result.setText(String.valueOf(val1));

                    }

                    // Degree to...
                    if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DEGREE_ANGLE.getConverterTo(RADIAN);
                        val1 = ut.convert(Measure.valueOf(val1, RADIAN).doubleValue(RADIAN));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DEGREE_ANGLE.getConverterTo(MINUTE_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, MINUTE_ANGLE).doubleValue(MINUTE_ANGLE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DEGREE_ANGLE.getConverterTo(SECOND_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND_ANGLE).doubleValue(SECOND_ANGLE));
                        result.setText(String.valueOf(val1));

                    }

                    // Minute to...
                    if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = MINUTE_ANGLE.getConverterTo(RADIAN);
                        val1 = ut.convert(Measure.valueOf(val1, RADIAN).doubleValue(RADIAN));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = MINUTE_ANGLE.getConverterTo(DEGREE_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, DEGREE_ANGLE).doubleValue(DEGREE_ANGLE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = MINUTE_ANGLE.getConverterTo(SECOND_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND_ANGLE).doubleValue(SECOND_ANGLE));
                        result.setText(String.valueOf(val1));


                    }

                    // Second to...
                    if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SECOND_ANGLE.getConverterTo(RADIAN);
                        val1 = ut.convert(Measure.valueOf(val1, RADIAN).doubleValue(RADIAN));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SECOND_ANGLE.getConverterTo(DEGREE_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, DEGREE_ANGLE).doubleValue(DEGREE_ANGLE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = SECOND_ANGLE.getConverterTo(SECOND_ANGLE);
                        val1 = ut.convert(Measure.valueOf(val1, SECOND_ANGLE).doubleValue(SECOND_ANGLE));
                        result.setText(String.valueOf(val1));

                    }


                }
            }
        });


    }


    public void uisetup() {
        calc = findViewById(R.id.angleCalcBTN);
        infospinner = findViewById(R.id.angleInfoSpinner);
        resultspinner = findViewById(R.id.angleResultSpinner);
        info = findViewById(R.id.angleInfoTV);
        result = findViewById(R.id.angleResultTV);
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
        getMenuInflater().inflate(R.menu.angle, menu);
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
