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

import static javax.measure.unit.NonSI.DYNE;
import static javax.measure.unit.NonSI.FEET_PER_SECOND;
import static javax.measure.unit.NonSI.KILOGRAM_FORCE;
import static javax.measure.unit.NonSI.KILOMETRES_PER_HOUR;
import static javax.measure.unit.NonSI.MILES_PER_HOUR;
import static javax.measure.unit.NonSI.POUND_FORCE;
import static javax.measure.unit.SI.METRES_PER_SECOND;
import static javax.measure.unit.SI.NEWTON;

public class ForceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button calc;
    private Spinner infospinner, resultspinner;
    private EditText info;
    private TextView result;
    private Double val1;
    private UnitConverter ut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force);
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
                R.array.force1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infospinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.force2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultspinner.setAdapter(adapter2);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    // Newton to...
                    if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = NEWTON.getConverterTo(KILOGRAM_FORCE);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM_FORCE).doubleValue(KILOGRAM_FORCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = NEWTON.getConverterTo(DYNE);
                        val1 = ut.convert(Measure.valueOf(val1, DYNE).doubleValue(DYNE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = NEWTON.getConverterTo(POUND_FORCE);
                        val1 = ut.convert(Measure.valueOf(val1, POUND_FORCE).doubleValue(POUND_FORCE));
                        result.setText(String.valueOf(val1));

                    }

                    //
                    //  KilogramF to...
                    if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM_FORCE.getConverterTo(NEWTON);
                        val1 = ut.convert(Measure.valueOf(val1, NEWTON).doubleValue(NEWTON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM_FORCE.getConverterTo(DYNE);
                        val1 = ut.convert(Measure.valueOf(val1, DYNE).doubleValue(DYNE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = KILOGRAM_FORCE.getConverterTo(POUND_FORCE);
                        val1 = ut.convert(Measure.valueOf(val1, POUND_FORCE).doubleValue(POUND_FORCE));
                        result.setText(String.valueOf(val1));

                    }

                    // Dyne to...
                    if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DYNE.getConverterTo(NEWTON);
                        val1 = ut.convert(Measure.valueOf(val1, NEWTON).doubleValue(NEWTON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DYNE.getConverterTo(KILOGRAM_FORCE);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM_FORCE).doubleValue(KILOGRAM_FORCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = DYNE.getConverterTo(POUND_FORCE);
                        val1 = ut.convert(Measure.valueOf(val1, POUND_FORCE).doubleValue(POUND_FORCE));
                        result.setText(String.valueOf(val1));


                    }

                    // Pound to...
                    if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND_FORCE.getConverterTo(NEWTON);
                        val1 = ut.convert(Measure.valueOf(val1, NEWTON).doubleValue(NEWTON));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND_FORCE.getConverterTo(KILOGRAM_FORCE);
                        val1 = ut.convert(Measure.valueOf(val1, KILOGRAM_FORCE).doubleValue(KILOGRAM_FORCE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = POUND_FORCE.getConverterTo(DYNE);
                        val1 = ut.convert(Measure.valueOf(val1, DYNE).doubleValue(DYNE));
                        result.setText(String.valueOf(val1));

                    }


                }
            }
        });

    }

    public void uisetup() {
        calc = findViewById(R.id.forceCalcBTN);
        infospinner = findViewById(R.id.forceInfoSpinner);
        resultspinner = findViewById(R.id.forceResultSpinner);
        result = findViewById(R.id.forceResultTV);
        info = findViewById(R.id.forceInfoTV);
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
        getMenuInflater().inflate(R.menu.force, menu);
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
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
