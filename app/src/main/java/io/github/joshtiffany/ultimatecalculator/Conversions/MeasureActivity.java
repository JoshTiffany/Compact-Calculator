package io.github.joshtiffany.ultimatecalculator.Conversions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Length;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.SI.*;
import javax.measure.*;
import javax.measure.unit.Unit;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.R;

public class MeasureActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    private Button calc;
    private Spinner infospinner;
    private Spinner resultspinner;
    private EditText info;
    private TextView result;
    private Integer measurement;
    private Double val1;
    private UnitConverter ut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
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
                R.array.measurements1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infospinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.measurements2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultspinner.setAdapter(adapter2);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    // Inches to...
                    if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(FOOT);
                        val1 = ut.convert(Measure.valueOf(val1, FOOT).doubleValue(FOOT));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(YARD);
                        val1 = ut.convert(Measure.valueOf(val1, YARD).doubleValue(YARD));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(MILE);
                        val1 = ut.convert(Measure.valueOf(val1, MILE).doubleValue(MILE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(NAUTICAL_MILE);
                        val1 = ut.convert(Measure.valueOf(val1, NAUTICAL_MILE).doubleValue(NAUTICAL_MILE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 5) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(MILLIMETRE);
                        val1 = ut.convert(Measure.valueOf(val1, MILLIMETRE).doubleValue(MILLIMETRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 6) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(CENTIMETRE);
                        val1 = ut.convert(Measure.valueOf(val1, CENTIMETRE).doubleValue(CENTIMETRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 7) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(METRE);
                        val1 = ut.convert(Measure.valueOf(val1, METRE).doubleValue(METRE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 0 && resultspinner.getSelectedItemId() == 8) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(KILOMETRE);
                        val1 = ut.convert(Measure.valueOf(val1, KILOMETRE).doubleValue(KILOMETRE));
                        result.setText(String.valueOf(val1));
                    }


                    // Feet to...
                    if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = FOOT.getConverterTo(INCH);
                        val1 = ut.convert(Measure.valueOf(val1, FOOT).doubleValue(FOOT));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = FOOT.getConverterTo(YARD);
                        val1 = ut.convert(Measure.valueOf(val1, YARD).doubleValue(YARD));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = FOOT.getConverterTo(MILE);
                        val1 = ut.convert(Measure.valueOf(val1, MILE).doubleValue(MILE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 1 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = FOOT.getConverterTo(NAUTICAL_MILE);
                        val1 = ut.convert(Measure.valueOf(val1, NAUTICAL_MILE).doubleValue(NAUTICAL_MILE));
                        result.setText(String.valueOf(val1));

                    }
                    // Yards to...
                    if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = YARD.getConverterTo(INCH);
                        val1 = ut.convert(Measure.valueOf(val1, INCH).doubleValue(INCH));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = YARD.getConverterTo(FOOT);
                        val1 = ut.convert(Measure.valueOf(val1, FOOT).doubleValue(FOOT));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = YARD.getConverterTo(MILE);
                        val1 = ut.convert(Measure.valueOf(val1, MILE).doubleValue(MILE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 2 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = YARD.getConverterTo(NAUTICAL_MILE);
                        val1 = ut.convert(Measure.valueOf(val1, NAUTICAL_MILE).doubleValue(NAUTICAL_MILE));
                        result.setText(String.valueOf(val1));

                    }
                    // Mile to...
                    if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(FOOT);
                        val1 = ut.convert(Measure.valueOf(val1, FOOT).doubleValue(FOOT));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(YARD);
                        val1 = ut.convert(Measure.valueOf(val1, YARD).doubleValue(YARD));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(MILE);
                        val1 = ut.convert(Measure.valueOf(val1, MILE).doubleValue(MILE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 3 && resultspinner.getSelectedItemId() == 4) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(NAUTICAL_MILE);
                        val1 = ut.convert(Measure.valueOf(val1, NAUTICAL_MILE).doubleValue(NAUTICAL_MILE));
                        result.setText(String.valueOf(val1));

                    }
                    // N-Miles to...
                    if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(FOOT);
                        val1 = ut.convert(Measure.valueOf(val1, FOOT).doubleValue(FOOT));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(YARD);
                        val1 = ut.convert(Measure.valueOf(val1, YARD).doubleValue(YARD));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(MILE);
                        val1 = ut.convert(Measure.valueOf(val1, MILE).doubleValue(MILE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(NAUTICAL_MILE);
                        val1 = ut.convert(Measure.valueOf(val1, NAUTICAL_MILE).doubleValue(NAUTICAL_MILE));
                        result.setText(String.valueOf(val1));

                    }
                    if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 0) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(FOOT);
                        val1 = ut.convert(Measure.valueOf(val1, FOOT).doubleValue(FOOT));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 1) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(YARD);
                        val1 = ut.convert(Measure.valueOf(val1, YARD).doubleValue(YARD));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 2) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(MILE);
                        val1 = ut.convert(Measure.valueOf(val1, MILE).doubleValue(MILE));
                        result.setText(String.valueOf(val1));

                    } else if (infospinner.getSelectedItemId() == 4 && resultspinner.getSelectedItemId() == 3) {
                        val1 = Double.parseDouble(info.getText().toString());
                        ut = INCH.getConverterTo(NAUTICAL_MILE);
                        val1 = ut.convert(Measure.valueOf(val1, NAUTICAL_MILE).doubleValue(NAUTICAL_MILE));
                        result.setText(String.valueOf(val1));

                    }


                }

            }
        });

    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void uiSetup() {
        calc = findViewById(R.id.measureCalcBTN);
        resultspinner = findViewById(R.id.resultSpinner);
        infospinner = findViewById(R.id.infoSpinner);
        info = findViewById(R.id.measureInfoTV);
        result = findViewById(R.id.measureResultTV);
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
        getMenuInflater().inflate(R.menu.measure, menu);
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

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
